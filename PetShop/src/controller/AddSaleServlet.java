package controller;

import DAO.PetDAO;
import DAO.SaleDAO;
import bean.Pet;
import bean.Sale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddSaleServlet", urlPatterns = "/addSale")
public class AddSaleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String pet = request.getParameter("pet");
        double rate = Double.parseDouble(request.getParameter("rate"));
        String begin_date = request.getParameter("begin_date");
        String end_date = request.getParameter("end_date");

        String[] arrPet = pet.split(" ");
        int pet_id = Integer.parseInt(arrPet[0]);
        Sale sale = new Sale();
        sale.setPet_id(pet_id);
        sale.setRate(rate);
        sale.setBegin_date(begin_date);
        sale.setEnd_date(end_date);

        SaleDAO.insertSale(sale);

        response.sendRedirect(request.getContextPath() + "/sale");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> listPet = PetDAO.getListPetNameNotSale();
        request.setAttribute("listPet", listPet);
        request.getRequestDispatcher("admin/addSale.jsp").forward(request, response);
    }
}
