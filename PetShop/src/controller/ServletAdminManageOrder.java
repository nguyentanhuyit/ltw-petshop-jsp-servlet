package controller;

import DAO.BillDAO;
import bean.Account;
import bean.Bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;


@WebServlet(name = "managerOder", urlPatterns = "/managerOther")

public class ServletAdminManageOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        HttpSession session = request.getSession();
//        Account account = (Account) session.getAttribute("acc");
//        int role_id = account.getRole_id();
      // goi bill entity
//        if(account!=null && role_id == 0) {
            BillDAO bill = new BillDAO();
            Collection<Bill> list = bill.getAll();
            if (!list.isEmpty())
                request.setAttribute("list", list);
            request.getRequestDispatcher("admin/order.jsp").forward(request, response);
//        }
//        else {request.getRequestDispatcher("user/login.jsp").forward(request, response);}
    }
}
