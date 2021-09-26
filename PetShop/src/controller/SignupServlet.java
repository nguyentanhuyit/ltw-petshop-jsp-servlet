package controller;

import DAO.AccountDAO;
import bean.Account;
import service.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignupServlet", urlPatterns = "/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username").trim();
        String pass = request.getParameter("pass").trim();
        String passConfirm = request.getParameter("pass-confirm").trim();
        String checkY = request.getParameter("check");
        Boolean agree = "Y".equals(checkY);
        boolean check = false;

        if(agree){
            check = true;
        }
        if(userName != "" || userName != null){
            if(userName.trim().length() >= 8){
                check = true;
            }
            else{
                check = false;
            }
        }
        if(pass != "" || pass != null){
            if(pass.trim().length() >= 8){
                check = true;
            }
            else{
                check = false;
            }
        }
        if (passConfirm.equalsIgnoreCase(pass)){
            check = true;
        }
        else{
            check = false;
        }
        if(check){
            Account account = new Account();
            account.setUser_name(userName);
            account.setPass(MD5.encryption(pass));
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            account.setReg_day(date);
            account.setRole_id(2);
            account.setImage("user/img/avatar/avatar_default.jpg");
            if(AccountDAO.signUpAccount(account)){
                request.setAttribute("Inform","Đăng ký thành công, vui lòng đăng nhập lại");
                request.getRequestDispatcher("user/login.jsp").forward(request,response);
            }

        }else{
            request.setAttribute("Erro", "Đăng ký thất bại");
            request.getRequestDispatcher("user/sign-up.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user/sign-up.jsp").forward(request,response);
    }

}
