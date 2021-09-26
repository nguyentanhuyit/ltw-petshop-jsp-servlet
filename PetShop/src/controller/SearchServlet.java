package controller;

import DAO.PetDAO;
import DAO.SizeDAO;
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

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("key");
        List<Pet> listPet = PetDAO.searchPet(keyword);
        int size = listPet.size();
        request.setAttribute("size",size);
        request.setAttribute("listPet", listPet);
        List<Size> listSize = SizeDAO.listSize();
        request.setAttribute("listSize", listSize);
        request.getRequestDispatcher("user/search.jsp").forward(request,response);
    }
}
