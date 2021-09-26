package controller;

import DAO.BillDAO;
import bean.Bill;
import bean.BillDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


@WebServlet(name = "orderDetail", urlPatterns = "/orderDetail")

public class ServletOrderDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BillDAO bill = new BillDAO();
        String bill_id = request.getParameter("bid");
        System.out.println(bill_id);
        //lay thong tin bill
        String[] arr = bill.getBillDetail(bill_id);

     //lay so luong thu cung da dat
        int id = Integer.valueOf(bill_id);
        Collection<BillDetail> list = bill.getListPetBill(id);
        System.out.println(bill.print(arr));
        //lay tong gia
        int total = bill.total(id);
        System.out.println(total);
        request.setAttribute("total", total);
        request.setAttribute("arr", arr);
        if (!list.isEmpty()){
            request.setAttribute("list", list);
        }
        request.getRequestDispatcher("admin/order_details.jsp").forward(request, response);
    }
}
