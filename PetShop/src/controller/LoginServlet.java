package controller;

import DAO.AccountDAO;
import bean.Account;
import service.MD5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username").trim();
        String password = request.getParameter("pass").trim();
        String savePass = request.getParameter("check");
        boolean savepasss = "A".equals(savePass);

        boolean check = false;
        if(userName != "" || userName != null){
            if(userName.length() >= 8){
                check = true;
            }
            else{
                check = false;
            }
        }
        if(password != "" || password != null){
            if(password.length() >= 8){
                check = true;
            }
            else{
                check = false;
            }
        }
        if(check){
            Account account = null;
            boolean hasError = false;
            String errorStr = null;
            account=AccountDAO.loginAccount(userName,MD5.encryption(password));
            if(account==null)
            {
                hasError=true;
                errorStr="Tên đăng nhập hoặc mật khẩu không chính xác!!!";
            }
            if(hasError){//trường hợp có lỗi
                request.setAttribute("errorStr", errorStr);
                request.setAttribute("account", account);
                request.getRequestDispatcher("user/login.jsp").forward(request,response);
            }
            if(hasError==false)
            {

                if (savepasss) {
                    Cookie cookie=new Cookie("nameCookie",account.getAccount_name());
                    cookie.setMaxAge(3*24*60*60);
                    response.addCookie(cookie);
                }
                else {
                    Cookie cookie=new Cookie("nameCookie",null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if(account.getRole_id()==2)//user
                {
                    HttpSession session = request.getSession();
                    session.setAttribute("account",account);
                    response.sendRedirect(request.getContextPath() + "/home");
                }
                else if(account.getRole_id()==1)
                {
                    HttpSession session = request.getSession();
                    session.setAttribute("account", account);
                    response.sendRedirect(request.getContextPath() + "/admin");
                }
            }
        }else{
            request.setAttribute("errorStr","Tên đăng nhập hoặc mật khẩu không chính xác!!!");
            request.getRequestDispatcher("user/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user/login.jsp").forward(request,response);
    }
}
