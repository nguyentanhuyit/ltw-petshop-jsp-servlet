package controller;

import DAO.CategoryDAO;
import DAO.SpeciesDAO;
import bean.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditCategoryServlet", urlPatterns = "/editCategory")
public class EditCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("category_id");
        int category_id = Integer.parseInt(id);
        String photo = request.getParameter("photo");
        String category_name = request.getParameter("categoryName").trim();

        Category category = new Category();
        category.setCategory_id(category_id);
        category.setCategory_name(category_name);
        category.setPhoto(photo);
        CategoryDAO.updateCategory(category);
        response.sendRedirect(request.getContextPath()+"/categories");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("category_id");
        int category_id = Integer.parseInt(id);
        Category category = CategoryDAO.getCategory(category_id);
        String species_name = SpeciesDAO.getSearchSpeciesName(category_id);
        request.setAttribute("species_name", species_name);
        request.setAttribute("category", category);
        request.getRequestDispatcher("admin/editCategory.jsp").forward(request, response);
    }
}
