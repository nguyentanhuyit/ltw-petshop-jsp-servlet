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

@WebServlet(name = "SearchBySizeServlet", urlPatterns = "/petSize")
public class SearchBySizeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String size = request.getParameter("size");
        List<Pet> listPet = PetDAO.getListBySize(size);
        request.setAttribute("listPet", listPet);
        request.getRequestDispatcher("user/search.jsp").forward(request, response);
    }
}
