package controller;

import DAO.ChangePass;
import DAO.CheckData;
import DAO.GetInfoAcc;
import bean.Account;
import service.SendMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "forgot-pass", urlPatterns = "/forgot-pass")

public class ServletForgotPass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String to = request.getParameter("email");
        String sql = "Select email from account where email=?";
        boolean check = new CheckData().checkExistMail(sql,to);
        Account acc = new GetInfoAcc().getInfo(to) ;
        SendMail send = new SendMail();
        ChangePass change = new ChangePass();
        if (check) {
//            send mail
            String code = send.getRandom();
           boolean sendMail = send.sendMail(acc,code);
            try {
                boolean saveData = change.saveData(to,code);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (sendMail) {
               HttpSession session = request.getSession();
               session.setAttribute("acc", acc);
               response.sendRedirect("user/verify.jsp");

           }

        } else {
            request.setAttribute("notice", "Tài khoản không tồn tại");
            request.getRequestDispatcher("user/forget-password.jsp").forward(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("user/forget-password.jsp").forward(request, response);

    }

}
