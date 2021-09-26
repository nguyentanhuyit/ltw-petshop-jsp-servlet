package controller;

import DAO.SaleDAO;
import bean.Sale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SaleServlet", urlPatterns = "/sale")
public class SaleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sale> listSale = SaleDAO.getSaleList();
        request.setAttribute("listSale", listSale);
        request.getRequestDispatcher("admin/sale.jsp").forward(request, response);
    }
}
