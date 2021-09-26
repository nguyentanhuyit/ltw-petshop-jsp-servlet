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


@WebServlet(name = "removeItem", urlPatterns = "/removeItem")

public class ServletRemoveItemLovelist extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PetDAO petDAO = new PetDAO();
        String pet_id = request.getParameter("pid");
        System.out.println(pet_id);
        int id = Integer.parseInt(pet_id);
        if (pet_id == null) {
            response.sendRedirect(request.getContextPath() + "/");
        }
        if (pet_id != null) {
            Pet pet = PetDAO.getPetInfoDetail(id);
            System.out.println(pet);
            if (pet == null) {
                response.sendRedirect(request.getContextPath() + "/");
                return;
            }
            HttpSession session = request.getSession(true);
            Cart lovecart = (Cart) session.getAttribute("lovecart");
            lovecart.remove(pet.getId());
            session.setAttribute("lovecart",lovecart);

        }
        response.sendRedirect("lovelist");
    }

}
