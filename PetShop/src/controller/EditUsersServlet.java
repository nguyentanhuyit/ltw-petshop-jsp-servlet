package controller;

import DAO.AccountDAO;
import DAO.RoleDAO;
import bean.Account;
import bean.Role;
import service.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EditUsersServlet", urlPatterns = "/editUser")
public class EditUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String role_name = request.getParameter("role_name").trim();
        int role_id = RoleDAO.getRole_id(role_name);
        String photo = request.getParameter("photo").trim();
        String user_name = request.getParameter("user_name").trim();
        String password = request.getParameter("password").trim();
        String account_name = request.getParameter("account_name").trim();
        String gender = request.getParameter("gender");
        String email = request.getParameter("email").trim();
        String birthday = request.getParameter("birthday");
        String phone_num = request.getParameter("phone_num").trim();
        int account_id = Integer.parseInt(request.getParameter("account_id"));

        boolean check = true;

        if(user_name=="" || password == "" || user_name.length() < 8 ||password.length() < 8){
        check =false;
        }
        if(check) {
            Account account = new Account();
            account.setUser_name(user_name);
            account.setPass(MD5.encryption(password));
            account.setAccount_name(account_name);
            account.setGender(gender);
            account.setEmail(email);
            account.setBirthday(birthday);
            account.setPhone_num(phone_num);
            account.setImage(photo);
            account.setRole_id(role_id);
            account.setAccount_id(account_id);

            AccountDAO.updateAccountAdmin(account);

            response.sendRedirect(request.getContextPath() + "/users");
        }else{
            Account account = AccountDAO.getInfoAccountById(account_id);
            request.setAttribute("account", account);
            List<Role> listRole = RoleDAO.getRoleList();
            request.setAttribute("listRole", listRole);
            request.getRequestDispatcher("admin/editUsers.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int account_id = Integer.parseInt(request.getParameter("user_id"));
        Account account = AccountDAO.getInfoAccountById(account_id);
        request.setAttribute("account", account);
        List<Role> listRole = RoleDAO.getRoleList();
        request.setAttribute("listRole", listRole);
        request.getRequestDispatcher("admin/editUsers.jsp").forward(request, response);
    }
}
