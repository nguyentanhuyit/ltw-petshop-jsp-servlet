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

@WebServlet(name = "SearchUserServlet", urlPatterns = "/searchUser")
public class SearchUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("search").trim();
        List<Account> listAccount = AccountDAO.searchAccount(keyword);
        request.setAttribute("listAccount", listAccount);
        request.getRequestDispatcher("admin/users.jsp").forward(request, response);
    }
}
