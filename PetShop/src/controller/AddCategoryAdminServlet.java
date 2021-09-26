package controller;

import DAO.AccountDAO;
import DAO.CategoryDAO;
import DAO.SpeciesDAO;
import bean.Account;
import bean.Category;
import bean.Species;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddCategoryAdminServlet", urlPatterns = "/addCategory")

public class AddCategoryAdminServlet extends HttpServlet {
    // vị trí để lưu trữ file uploaded

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String photo = request.getParameter("photo");
        String species = request.getParameter("species");
        String category_name = request.getParameter("categoryName").trim();

        Category category = new Category();
        category.setPhoto(photo);
        category.setCategory_name(category_name);
        category.setSpecies_id(SpeciesDAO.getSpeciesID(species));
        CategoryDAO.insertCategory(category);
        List<Category> listCategory = CategoryDAO.getListCategory();
        request.setAttribute("listCategory", listCategory);
        request.getRequestDispatcher("admin/categories.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Species> listSpecies = SpeciesDAO.getListSpecies();
        request.setAttribute("listSpecies", listSpecies);
        request.getRequestDispatcher("admin/addCategory.jsp").forward(request,response);
    }
}
