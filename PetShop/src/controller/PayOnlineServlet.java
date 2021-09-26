package controller;

import DAO.BankDAO;
import DAO.GetInfoAcc;
import bean.Account;
import bean.Bank;
import bean.Cart;
import bean.DiscountCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


@WebServlet(name = "pay-online", urlPatterns = "/pay-online")

public class PayOnlineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int account_id = Integer.parseInt(request.getParameter("id"));
        GetInfoAcc getInfo = new GetInfoAcc();
        getInfo.getInfobyID(account_id);
        HttpSession session = request.getSession();
        Cart cart = Cart.getCart(session);

        BankDAO bankDAO = new BankDAO();
        List<Bank> list = bankDAO.getBank();
        request.setAttribute("listBank", list);

        if (cart == null) cart = new Cart();
        request.setAttribute("cart", cart);

        Account acc = (Account) session.getAttribute("account");
        if (acc != null) {
            request.getRequestDispatcher("user/pay-Online.jsp").forward(request,response);
        } else {
            response.getWriter().print("<script>alert('Bạn chưa đăng nhập')</script>");
            response.sendRedirect("shoppingCart");
        }
    }
}
