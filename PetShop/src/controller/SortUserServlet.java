package controller;

import DAO.AccountDAO;
import bean.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SortUserServlet", urlPatterns = "/sortUser")
public class SortUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("roles");
        System.out.println(keyword);
        List<Account> listAccount = AccountDAO.sortAccount(keyword);
        request.setAttribute("listAccount", listAccount);
        request.getRequestDispatcher("admin/users.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }
}
