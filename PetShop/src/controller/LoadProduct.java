package controller;

import DAO.CommentDAO;
import DAO.PetDAO;
import DAO.SizeDAO;
import bean.Comment;
import bean.Pet;
import bean.Size;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Shop-grid", urlPatterns = "/shop-grid")
public class LoadProduct extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pet> listPet = PetDAO.getInfoPet();
        int size = listPet.size();
        request.setAttribute("size", size);
        request.setAttribute("listPet", listPet);

        List<Pet> listPetSale = PetDAO.listPetSale();
        request.setAttribute("listPetSale",listPetSale);

        //load latest product
        List<Pet> listLatestProduct = PetDAO.getListLatestProduct(6);
        List<Pet> listLatestProduct1 = new ArrayList<>();
        List<Pet> listLatestProduct2 = new ArrayList<>();
        for (int i =0; i<listLatestProduct.size()/2;i++){
            listLatestProduct1.add(listLatestProduct.get(i));
        }
        for (int i =listLatestProduct.size()/2; i<listLatestProduct.size();i++){
            listLatestProduct2.add(listLatestProduct.get(i));
        }
        request.setAttribute("listLatestProduct1", listLatestProduct1);
        request.setAttribute("listLatestProduct2", listLatestProduct2);

        //load size

        List<Size> listSize = SizeDAO.listSize();
        request.setAttribute("listSize", listSize);

        request.getRequestDispatcher("user/shop-grid.jsp").forward(request,response);
    }
}
