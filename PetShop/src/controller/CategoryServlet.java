package controller;

import DAO.PetDAO;
import bean.Pet;
import bean.Size;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category_name = request.getParameter("category_name");
        List<Pet> listPet = PetDAO.searchPet(category_name);
        int size = listPet.size();
        request.setAttribute("size",size);
        request.setAttribute("listPet", listPet);

        List<Size> listSize = new ArrayList<>();
        request.setAttribute("listSize", listSize);
        request.getRequestDispatcher("user/search.jsp").forward(request,response);
    }
}
