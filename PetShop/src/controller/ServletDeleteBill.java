package controller;

import DAO.BillDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "deleteBill", urlPatterns = "/deleteBill")

public class ServletDeleteBill extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bill_id = request.getParameter("bid");
        BillDAO bill = new BillDAO();
        bill.deleteBill(bill_id);
        response.sendRedirect("managerOther");
    }
}
