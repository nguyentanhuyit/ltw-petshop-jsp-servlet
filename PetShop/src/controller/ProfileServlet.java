package controller;

import DAO.AccountDAO;
import bean.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username").trim();
        String  name = request.getParameter("name").trim();
        String email = request.getParameter("email").trim();
        String phonenum = request.getParameter("phonenumber").trim();
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        boolean check=true;
        if(userName.length()<8){
            check=false;
        }
        if (check){
            Account account = new Account();
            account.setUser_name(userName);
            account.setAccount_name(name);
            account.setEmail(email);
            account.setPhone_num(phonenum);
            account.setGender(gender);
            account.setBirthday(birthday);
            Account user = (Account) request.getSession().getAttribute("account");
            if(user==null){
                request.getRequestDispatcher("user/login.jsp");
            }
            account.setAccount_id(user.getAccount_id());
            account.setImage(user.getImage());
            account.setReg_day(user.getReg_day());
            account.setRole_id(user.getRole_id());
            account.setPass(user.getPass());
            AccountDAO.updateInfoAccount(account);
            request.getSession().removeAttribute("account");
            request.getSession().setAttribute("account", account);
            request.getRequestDispatcher("user/account/profile.jsp").forward(request,response);
        }
        if (check==false){
            request.getRequestDispatcher("user/account/profile.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user/account/profile.jsp").forward(request,response);
    }
}
