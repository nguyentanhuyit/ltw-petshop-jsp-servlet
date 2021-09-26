package DAO;

import bean.SubComment;
import connection.DBConnection;
import sun.security.pkcs11.Secmod;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubCommentDAO {
    public static void replyComment(SubComment subComment){
        String sql = "insert into subcomments values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, subComment.getSub_cmt_id());
            preparedStatement.setString(2, subComment.getSub_cmt_content());
            preparedStatement.setDate(3, subComment.getSub_cmt_date());
            preparedStatement.setInt(4, subComment.getAccount_id());
            preparedStatement.setInt(5, subComment.getCmt_id());
            preparedStatement.setString(6, subComment.getPhoto());
            preparedStatement.setInt(7, subComment.getLike());
            preparedStatement.setInt(8, subComment.getDislike());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<SubComment> getListSubcomment(int cmt_id){
        List<SubComment> list = new ArrayList<>();
        String sql = "select * from subcomments where cmt_id =?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, cmt_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int sub_cmt_id = resultSet.getInt("sub_cmt_id");
                String sub_cmt_content = resultSet.getString("sub_cmt_content");
                Date sub_cmt_date = resultSet.getDate("sub_cmt_date");
                int account_id = resultSet.getInt("account_id");
                int cmt_ids = resultSet.getInt("cmt_id");
                String photo = resultSet.getString("photo");
                int like = resultSet.getInt("like");
                int dislike = resultSet.getInt("dislike");
                SubComment subComment = new SubComment(sub_cmt_id, sub_cmt_content, sub_cmt_date, account_id, cmt_ids, photo, like, dislike);
                list.add(subComment);
            }
            resultSet.close();;
            preparedStatement.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SubComment subComment = new SubComment(2, "hihi", new Date(System.currentTimeMillis()), 22, 2, "",0,0);
        replyComment(subComment);
    }
}
