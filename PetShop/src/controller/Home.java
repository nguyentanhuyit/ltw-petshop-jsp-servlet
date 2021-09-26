package controller;

import DAO.CategoryDAO;
import DAO.LoveListDAO;
import DAO.PetDAO;
import DAO.SpeciesDAO;
import bean.Account;
import bean.Category;
import bean.Pet;
import bean.Species;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Home", urlPatterns = "/home")
public class Home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        if(account!=null){
            List<Pet> listPet = LoveListDAO.getLoveList(account.getAccount_id());
            request.setAttribute("listPetSize", listPet.size());
        }

        List<Category> listCategory = CategoryDAO.getListCategory();
        request.setAttribute("listCategory", listCategory);

       List<Pet> listPet = PetDAO.getListLatestProduct(6);
        List<Pet> listPet1 = new ArrayList<>();
        List<Pet> listPet2 = new ArrayList<>();
        for (int i =0; i<listPet.size()/2;i++){
            listPet1.add(listPet.get(i));
        }
        for (int i =listPet.size()/2; i<listPet.size();i++){
            listPet2.add(listPet.get(i));
        }
       request.setAttribute("listPet1", listPet1);
        request.setAttribute("listPet2", listPet2);
        List<Species> listSpecies = SpeciesDAO.getListSpecies();
        for (int i = 0 ; i< listSpecies.size();i++){
            List<Pet> listPetSpecies = PetDAO.listPetSpecies(listSpecies.get(i).getSpecies_name());
            request.setAttribute("listPetSpecies"+i,listPetSpecies );
        }
        request.setAttribute("listSpecies", listSpecies);

        List<Pet> listPetLatestSale = PetDAO.listLatestSale(6);
        List<Pet> listPetLatestSale1 = new ArrayList<>();
        List<Pet> listPetLatestSale2 = new ArrayList<>();
        for (int i =0; i<listPetLatestSale.size()/2;i++){
            listPetLatestSale1.add(listPetLatestSale.get(i));
        }
        for (int i =listPetLatestSale.size()/2; i<listPetLatestSale.size();i++){
            listPetLatestSale2.add(listPetLatestSale.get(i));
        }
        request.setAttribute("listPetLatestSale1", listPetLatestSale1);
        request.setAttribute("listPetLatestSale2", listPetLatestSale2);

        List<Pet> listBestSale = PetDAO.listBestSell(6);
        List<Pet> listBestSale1 = new ArrayList<>();
        List<Pet> listBestSale2 = new ArrayList<>();
        for (int i =0; i<listBestSale.size()/2;i++){
            listBestSale1.add(listBestSale.get(i));
        }
        for (int i =listBestSale.size()/2; i<listBestSale.size();i++){
            listBestSale2.add(listBestSale.get(i));
        }
        request.setAttribute("listBestSale1", listBestSale1);
        request.setAttribute("listBestSale2", listBestSale2);
        request.getRequestDispatcher("user/index.jsp").forward(request,response);
    }

}
