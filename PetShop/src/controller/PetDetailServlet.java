package controller;

import DAO.*;
import bean.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PetDetailServlet", urlPatterns = "/shop-details")
public class PetDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String petID = request.getParameter("petID");
        Pet petDetail = PetDAO.getPetInfoDetail(Integer.parseInt(petID));
        Category category = CategoryDAO.getCategoryInPetDetail(Integer.parseInt(petID));
        request.setAttribute("category", category);
        request.setAttribute("petDetail", petDetail);

        List<Pet> listPetRelative = PetDAO.getListRelative(4, category.getCategory_name());
        request.setAttribute("listPetRelative", listPetRelative);

        //load comment
        int count=0;
        List<Comment> listComment = CommentDAO.getListComment(Integer.parseInt(petID));
        for (Comment comment:listComment){
            List<SubComment> listSubCmt = SubCommentDAO.getListSubcomment(comment.getCmt_id());
            for (SubComment subComment:listSubCmt){
                count++;
            }
        }
        request.setAttribute("NhanXet", listComment.size()+count);
        request.setAttribute("listComment", listComment);
        request.getRequestDispatcher("user/shop-details.jsp").forward(request,response);
    }
}
