package controller;

import DAO.CategoryDAO;
import DAO.CommentDAO;
import DAO.PetDAO;
import bean.Account;
import bean.Category;
import bean.Comment;
import bean.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "CommentServlet", urlPatterns = "/comment")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(false);
        Account account = (Account) session.getAttribute("account");
        if(account!=null) {
            String content = request.getParameter("content");
            int pet_id = Integer.parseInt(request.getParameter("pet_id"));

            Comment comment = new Comment();
            comment.setAccount_id(account.getAccount_id());
            comment.setTime_cmt(new Date(System.currentTimeMillis()));
            comment.setContent(content);
            comment.setPet_id(pet_id);

            CommentDAO.comment(comment);

            Pet petDetail = PetDAO.getPetInfoDetail(pet_id);
            Category category = CategoryDAO.getCategoryInPetDetail(pet_id);
            request.setAttribute("category", category);
            request.setAttribute("petDetail", petDetail);

            List<Pet> listPetRelative = PetDAO.getListRelative(4, category.getCategory_name());
            request.setAttribute("listPetRelative", listPetRelative);

            //load comment
            List<Comment> listComment = CommentDAO.getListComment(pet_id);
            request.setAttribute("listComment", listComment);
            request.getRequestDispatcher("user/shop-details.jsp").forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
