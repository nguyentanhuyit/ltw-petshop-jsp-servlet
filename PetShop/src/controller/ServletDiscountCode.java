package controller;

import DAO.DiscountCodeEntity;
import bean.DiscountCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "discountCode", urlPatterns = "/discountCode")

public class ServletDiscountCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("discountCode");
        DiscountCode dc = new DiscountCodeEntity().getCode(code);
        HttpSession session = request.getSession();
        boolean check = false;
        session.setAttribute("dc", dc);
       if (dc==null){
           request.setAttribute("noticeCode", "Không có mã khuyến mãi này");
           check =false;
       }
       else {
           request.setAttribute("noticeCode", "Bạn được giảm" + DiscountCode.percentFormat(dc.getRate()));
           check = true;
           request.setAttribute("dc", dc);



       }
        request.setAttribute("check", check);
       request.setAttribute("code", code);
        request.getRequestDispatcher("/shoppingCart").forward(request, response);
    }
}
