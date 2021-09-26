package controller;

import DAO.CategoryDAO;
import DAO.SpeciesDAO;
import bean.Account;
import bean.Category;
import bean.Species;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoriesServlet", urlPatterns = "/categories")
public class CategoriesAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        if(account == null){
            response.sendRedirect(request.getContextPath()+"/login");
        }
        List<Category> listCategory = CategoryDAO.getListCategory();
        request.setAttribute("listCategory", listCategory);
        request.getRequestDispatcher("admin/categories.jsp").forward(request,response);
    }
}
