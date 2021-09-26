package DAO;

import bean.Size;
import connection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SizeDAO {
    public static List<Size> listSize(){
        List<Size> list = new ArrayList<>();
        String sql ="select size_id, size_name from size";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int size_id = resultSet.getInt("size_id");
                String size_name = resultSet.getString("size_name");

                Size size = new Size();
                size.setSize_id(size_id);
                size.setSize_name(size_name);

                list.add(size);
            }
            preparedStatement.close();
            resultSet.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(listSize());
    }
}
