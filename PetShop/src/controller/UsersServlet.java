package controller;

import DAO.AccountDAO;
import DAO.RoleDAO;
import bean.Account;
import bean.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> listAccount = AccountDAO.getListAccount();
        request.setAttribute("listAccount", listAccount);
        List<Role> listRole = RoleDAO.getRoleList();
        request.setAttribute("listRole", listRole);
        request.getRequestDispatcher("admin/users.jsp").forward(request,response);
    }
}
