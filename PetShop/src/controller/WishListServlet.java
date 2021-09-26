package controller;

import DAO.LoveListDAO;
import bean.Account;
import bean.LoveList;
import bean.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "WishListServlet", urlPatterns = "/wish-list")
public class WishListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        if(account==null){
            request.getRequestDispatcher("user/login.jsp").forward(request,response);
//            response.sendRedirect("user/login.jsp");
        }
        List<Pet> listPet = LoveListDAO.getLoveList(account.getAccount_id());
        request.setAttribute("listPet", listPet);

        request.getRequestDispatcher("user/wish-list.jsp").forward(request,response);
    }
}
