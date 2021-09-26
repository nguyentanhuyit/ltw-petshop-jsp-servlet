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


@WebServlet(name = "verifyCode", urlPatterns = "/verifyCode")

public class VerifyCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChangePass changePass = new ChangePass();
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        String code = request.getParameter("verify");
        if (acc != null){
        System.out.println(acc.getEmail()+"----------------------------");

        if (code.equals(changePass.getCode(acc.getEmail()))){
            request.getRequestDispatcher("user/reset-password.jsp").forward(request,response);
        }
        else {
            request.setAttribute("err","nhập sai code" );
            request.getRequestDispatcher("user/verify.jsp").forward(request,response);
        }}
       else {
            response.sendRedirect("/forgot-pass");
        }


    }
}
