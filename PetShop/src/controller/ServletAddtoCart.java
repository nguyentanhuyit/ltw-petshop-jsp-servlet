package controller;

import DAO.PetDAO;
import bean.Account;
import bean.Cart;
import bean.Item;
import bean.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "addtoCart", urlPatterns = "/addtoCart")

public class ServletAddtoCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session1 = request.getSession();
        Account account = (Account) session1.getAttribute("account");
        if(account==null){
            request.getRequestDispatcher("user/login.jsp").forward(request,response);
        }else {
            PetDAO petDAO = new PetDAO();
            String pet_id = request.getParameter("pid");
            System.out.println(pet_id);
            if (pet_id == null) {
                response.sendRedirect(request.getContextPath() + "/");
            }
            if (pet_id != null) {
                int id = Integer.parseInt(pet_id);
                Pet pet = PetDAO.getPetInfoDetail(id);
                System.out.println(pet);
                if (pet == null) {
                    response.sendRedirect(request.getContextPath() + "/");
                    return;
                }
                HttpSession session = request.getSession(true);
                Cart cart = Cart.getCart(session);

                cart.put(pet);
                cart.commit(session);
            }
            response.sendRedirect("home");
        }

    }
}
