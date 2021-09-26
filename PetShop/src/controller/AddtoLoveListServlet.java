package controller;

import DAO.PetDAO;
import bean.Cart;
import bean.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "addLovelist", urlPatterns = "/addLovelist")

public class AddtoLoveListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PetDAO petDAO = new PetDAO();
        String pet_id = request.getParameter("pid");
        System.out.println(pet_id);
        if (pet_id == null) {
            response.sendRedirect(request.getContextPath() + "/");
        }
        if (pet_id != null) {
            int id = Integer.parseInt(pet_id);
            Pet pet = petDAO.getPetInfoDetail(id);
            System.out.println(pet);
            if (pet == null) {
                response.sendRedirect(request.getContextPath() + "/");
                return;
            }
            else {
                Cart lovecart = new Cart();
                HttpSession ss1 = request.getSession(true);
                ss1.getAttribute("lovecart");
                lovecart.put(pet);
                ss1.setAttribute("lovecart", lovecart);
            }
        }
        response.sendRedirect("home");

    }
}
