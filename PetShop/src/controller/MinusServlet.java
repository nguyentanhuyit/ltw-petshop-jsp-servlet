package controller;

import bean.Cart;
import bean.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "minus", urlPatterns = "/minus")

public class MinusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int petid = Integer.parseInt(request.getParameter("maSP"));
        HttpSession session = request.getSession();
        Cart cart = Cart.getCart(session);
        for (Pet pet : cart.getDt()) {
            if (petid==(pet.getId())) {
                pet.quantityDown();
            }
        }
        response.getWriter().write("OK");
    }
}
