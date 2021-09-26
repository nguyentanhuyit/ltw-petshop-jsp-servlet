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

@WebServlet(name = "AddUserServlet", urlPatterns = "/addUser")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String role_name = request.getParameter("role_name");
        int role_id = RoleDAO.getRole_id(role_name);
        String photo = request.getParameter("photo");
        String user_name = request.getParameter("user_name");
        String password = request.getParameter("password");
        String account_name = request.getParameter("account_name");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String phone_num = request.getParameter("phone_num");
        boolean check = true;

        if(user_name=="" || password == "" || user_name.length() < 8 ||password.length() < 8){
            check =false;
        }
        if (check) {
            Account account = new Account();
            account.setUser_name(user_name);
            account.setPass(MD5.encryption(password));
            account.setAccount_name(account_name);
            account.setGender(gender);
            account.setEmail(email);
            account.setBirthday(birthday);
            account.setPhone_num(phone_num);
            account.setReg_day(new Date(System.currentTimeMillis()));
            account.setImage(photo);
            account.setRole_id(role_id);

            AccountDAO.signUpAccount(account);

            response.sendRedirect(request.getContextPath() + "/users");
        }else{
            List<Role> listRole = RoleDAO.getRoleList();
            request.setAttribute("listRole", listRole);
            request.getRequestDispatcher("admin/addUser.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Role> listRole = RoleDAO.getRoleList();
        request.setAttribute("listRole", listRole);
        request.getRequestDispatcher("admin/addUser.jsp").forward(request, response);
    }
}
