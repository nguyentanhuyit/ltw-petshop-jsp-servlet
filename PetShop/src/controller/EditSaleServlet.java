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

@WebServlet(name = "EditSaleServlet", urlPatterns = "/editSale")
public class EditSaleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pet_id = Integer.parseInt(request.getParameter("pet_id"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        String begin_date = request.getParameter("begin_date");
        String end_date = request.getParameter("end_date");

        System.out.println(begin_date);
        System.out.println(end_date);

        Sale sale = new Sale();
        sale.setPet_id(pet_id);
        sale.setRate(rate);
        sale.setBegin_date(begin_date);
        sale.setEnd_date(end_date);

        SaleDAO.updateSale(sale);

        response.sendRedirect(request.getContextPath() + "/sale");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pet_id = Integer.parseInt(request.getParameter("pet_id"));
        Pet pet = PetDAO.getPetInfoDetail(pet_id);

        Sale sale = SaleDAO.getInfoSaleByPetID(pet_id);

        request.setAttribute("pet_name", pet.getPetName());
        request.setAttribute("sale", sale);
        request.getRequestDispatcher("admin/editSale.jsp").forward(request,response);
    }
}
