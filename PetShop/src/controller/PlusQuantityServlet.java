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


@WebServlet(name = "plus", urlPatterns = "/plus")

public class PlusQuantityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pet_id = Integer.parseInt(request.getParameter("petid"));
        HttpSession session = request.getSession();
        Cart cart = Cart.getCart(session);
        for (Pet pet : cart.getDt()) {
            if (pet_id==(pet.getId())) {
                pet.quantityUP();
            }
        }
        response.getWriter().write("OK");
    }

}
