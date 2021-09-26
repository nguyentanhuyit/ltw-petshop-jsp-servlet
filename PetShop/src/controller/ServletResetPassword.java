package controller;

import DAO.ChangePass;
import bean.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "resetPassword", urlPatterns = "/resetPassword")

public class ServletResetPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChangePass change = new ChangePass();
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        if (acc != null){
            if (password.equals(confirmPassword)&& password!=null && confirmPassword!=null){
                change.updatePass(acc.getEmail(),password);
                request.setAttribute("done", "Đổi mật khẩu thành công");
                response.sendRedirect("login");
            }
            else {
                request.setAttribute("notEqual","Mật khẩu không khớp");
                request.getRequestDispatcher("resetPassword");
            }


        }
        else {
            response.sendRedirect("/forgot-pass");
        }

    }
}
