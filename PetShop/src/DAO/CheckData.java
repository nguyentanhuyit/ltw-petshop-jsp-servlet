package DAO;
import bean.Account;
import connection.DBConnection;

import java.sql.*;

public class CheckData {

   public boolean checkExistMail(String sql,String mail){
       try {
           PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
           s.setString(1, mail);
           ResultSet rs = s.executeQuery();
           String mail_after = null;
           while (rs.next()) mail_after = rs.getString(1);
           if (mail.equalsIgnoreCase(mail_after)) return true;
           else return false;



       } catch (SQLException throwables) {
           throwables.printStackTrace();
           return false;
       }
   }

    public static void main(String[] args) {
        CheckData check = new CheckData();
        System.out.println(check.checkExistMail( "Select email from account where email=?","Phamk.huy211199@gmail.com"));
//        System.out.println(check.changeFistChar("phamk.huy211199@gmail.com"));

    }
}
