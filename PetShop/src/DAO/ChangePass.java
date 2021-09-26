package DAO;

import connection.DBConnection;
import sun.security.pkcs11.Secmod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import java.text.SimpleDateFormat;


public class ChangePass {
    public boolean saveData(String mail, String code) throws Exception {

       //check email exist
        String sql = "Select email from password_changing where email=?";
        boolean check = new  CheckData().checkExistMail(sql,mail);

        //datetime format
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String todaysDate = dateFormat.format(System.currentTimeMillis());



       // if mail not exist
        if (!check){
        String query = "INSERT INTO password_changing(id, email, expirationdate ,code) values(null,?,?,?)";
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            s.setString(1,mail);
            s.setString(2,todaysDate);
            s.setString(3,code);

            s.executeUpdate();
            ResultSet rs = s.getGeneratedKeys();
            System.out.println(sql);
            int newId = 0;
            if (rs.next()) {
                newId = rs.getInt(1);
                return true;
            }
            s.close();
            rs.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        //if  mail exist
        }if(check) {
            String query = "UPDATE password_changing SET expirationdate=?,code=? WHERE email=?";
            try {
                PreparedStatement s = DBConnection.CreateConnection().prepareStatement(query);
                s.setString(1,todaysDate);
                s.setString(2,code);
                s.setString(3,mail);

                s.executeUpdate();
                System.out.println(sql);
                int newId = 0;

                System.out.println(query);
                s.close();
            }catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }

        }
  return false;
    }
    public String getCode(String email){
        String sql = "Select code from password_changing where email=?";
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            String code = null;
            s.setString(1, email);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                 code = rs.getString(1);
            }
        return code;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        return null;
        }
    }
    public boolean updatePass(String email,String newPass){
        String sql = "UPDATE account SET pass=? WHERE email=?";
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setString(1, newPass);
            s.setString(2, email);
            s.executeUpdate();
            s.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }

    public static void main(String[] args) throws Exception {
        ChangePass save = new ChangePass();
//        String code = new SendMail().getRandom();
//        boolean s = save.saveData("tmt", code);
        boolean s = save.updatePass("phamk.huy211199@gmail.com","2345");
        System.out.println( s);
    }
    }
