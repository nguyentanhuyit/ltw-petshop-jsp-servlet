package controller;

import DAO.AccountDAO;
import DAO.GetInfoAcc;
import bean.Account;
import bean.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet(name = "checkout", urlPatterns = "/checkout")

public class ServletCheckout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //load du lieu
        HttpSession session = request.getSession(true);
        Account acc = (Account) session.getAttribute("account");
        int id = Integer.parseInt(request.getParameter("uid"));
//        GetInfoAcc getInfo = new GetInfoAcc();
//        Account account = getInfo.getInfobyID(id);
//        if (acc!=null){
//            account.commit(session);
//            Cart cart = Cart.getCart(session);
//            request.setAttribute("account_name",account.getAccount_name());
//            request.setAttribute("province",account.getAddress().getProvince());
//            request.setAttribute("district",account.getAddress().getDistrict());
//            request.setAttribute("address_detail",account.getAddress().getAddress_detail());
//            request.setAttribute("phone",account.getPhone_num());
//            request.setAttribute("email",account.getEmail());
//            if (cart == null) cart = new Cart();
//            request.setAttribute("Cart", cart);
        if (acc == null) {
            response.sendRedirect("home");
        } else {
            Account account = AccountDAO.getInfoAccountById(id);
            request.setAttribute("account", account);
            request.getRequestDispatcher("user/checkout.jsp").forward(request, response);
        }
    }
//        else {
//            response.sendRedirect("shoppingCart");
//        }

//    }
}
