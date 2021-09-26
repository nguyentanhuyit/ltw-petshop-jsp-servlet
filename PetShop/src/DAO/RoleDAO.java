package DAO;

import bean.Role;
import connection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    public static String getRoleName(int account_id){
        String sql = "select role.role_name from (role inner join account on role.role_id = account.role_id)" +
                "where account.account_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, account_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String role_name = resultSet.getString("role_name");
                return role_name;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Role> getRoleList(){
        List<Role> list = new ArrayList<>();
        String sql = "select * from role ";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int role_id = resultSet.getInt("role_id");
                String role_name = resultSet.getString("role_name");
                Role role = new Role();
                role.setRole_id(role_id);
                role.setRole_name(role_name);
                list.add(role);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getRole_id(String role_name){
        String sql = "select role_id from role where role_name =?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, role_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int role_id = resultSet.getInt("role_id");
                return role_id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(getRoleName(1));
        System.out.println(getRole_id("user"));
    }
}
