package DAO;

import bean.Comment;
import connection.DBConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    public static void comment(Comment comment){
        String sql ="insert into comments values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, comment.getCmt_id());
            preparedStatement.setInt(2, comment.getAccount_id());
            preparedStatement.setDate(3, comment.getTime_cmt());
            preparedStatement.setString(4, comment.getContent());
            preparedStatement.setInt(5, comment.getPet_id());
            preparedStatement.setInt(6, comment.getLike());
            preparedStatement.setInt(7, comment.getDislike());
            preparedStatement.setString(8, comment.getPhoto());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Comment> getListComment(int pet_ids){
        List<Comment> list = new ArrayList<>();
        String sql = "select * from comments where pet_id =?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, pet_ids);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int cmt_id = resultSet.getInt("cmt_id");
                int account_id = resultSet.getInt("account_id");
                Date date = resultSet.getDate("time_cmt");
                String content = resultSet.getString("content");
                int pet_id = resultSet.getInt("pet_id");
                int like = resultSet.getInt("like");
                int dislike = resultSet.getInt("dislike");
                String photo = resultSet.getString("photo");

                Comment comment = new Comment(cmt_id, account_id, date, content,pet_id, like, dislike, photo);
                list.add(comment);
            }
            resultSet.close();
            preparedStatement.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void likeComment(int cmt_id){
//
//    }
    public static void main(String[] args) {
//        long millis = System.currentTimeMillis();
//        Date date = new Date(millis);
//        Comment comment = new Comment(1,1,date, "Đẹp quá",1, 0, 0, "");
//        comment(comment);
        System.out.println(getListComment(2));
    }
}
