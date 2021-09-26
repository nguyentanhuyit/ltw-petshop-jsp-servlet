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

@WebServlet(name = "ChangePasswordServlet", urlPatterns = "/changepassword")
public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String pass = request.getParameter("passwordNow").trim();
        String passNew = request.getParameter("passwordNew").trim();
        String passCofirm = request.getParameter("passwordConfirm").trim();
        boolean check=true;
        if(pass.length()<8){
            check=false;
        }
        if (passNew.length()<8){
            check=false;
        }
        if (!passCofirm.equals(passNew)){
            check = false;
        }
        if (check){
            Account account = new Account();
            Account user = (Account) request.getSession().getAttribute("account");
            if(user==null){
                request.getRequestDispatcher("user/login.jsp");
            }
            String password = user.getPass();
            if (!pass.equals(password)){
                request.setAttribute("erre","Mật khẩu không đúng, vui lòng nhập lại!");
                request.getRequestDispatcher("user/account/change-password.jsp").forward(request,response);
            }
            if (pass.equals(password)){
                account.setAccount_id(user.getAccount_id());
                account.setUser_name(user.getUser_name());
                account.setPass(MD5.encryption(passNew));
                account.setImage(user.getImage());
                account.setReg_day(user.getReg_day());
                account.setAccount_name(user.getAccount_name());
                account.setGender(user.getGender());
                account.setEmail(user.getEmail());
                account.setBirthday(user.getBirthday());
                account.setPhone_num(user.getPhone_num());
                account.setRole_id(user.getRole_id());
                AccountDAO.changePassword(account);
                request.getSession().removeAttribute("account");
                request.getSession().setAttribute("account", account);
                request.getRequestDispatcher("user/account/profile.jsp").forward(request,response);
            }

        }
        if (check==false){
            request.getRequestDispatcher("user/account/change-password.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user/account/change-password.jsp").forward(request,response);
    }
}
