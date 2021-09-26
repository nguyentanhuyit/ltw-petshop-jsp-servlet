package controller;

import DAO.PetDAO;
import bean.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductAdminServlet", urlPatterns = "/product")
public class ProductAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> listPet = PetDAO.getInfoPet();
        request.setAttribute("listPet", listPet);
        request.getRequestDispatcher("admin/product.jsp").forward(request, response);
    }

//    public static void main(String[] args) {
//        System.out.println(PetDAO.getInfoPet());
//    }
}
