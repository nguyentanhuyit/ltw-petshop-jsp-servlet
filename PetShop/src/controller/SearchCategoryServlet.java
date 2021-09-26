package controller;

import DAO.CategoryDAO;
import DAO.SpeciesDAO;
import bean.Category;
import bean.Species;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchCategoryServlet", urlPatterns = "/searchCategory")
public class SearchCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("search").trim();
        List<Category> listCategory = CategoryDAO.searchCategory(keyword);
        request.setAttribute("listCategory", listCategory);
        request.getRequestDispatcher("admin/categories.jsp").forward(request,response);
    }
}
