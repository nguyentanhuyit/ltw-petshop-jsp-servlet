package DAO;

import bean.Account;
import bean.Address;
import connection.DBConnection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetInfoAcc {
    public Account getInfo(String mail){
        Account acc = new Account();
        String sql = "Select account_id,user_name,email,birthday,phone_num,image from account where email=?";
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setString(1, mail);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                acc.setUser_name(rs.getString("user_name"));
                acc.setEmail(rs.getString("email"));
                acc.setBirthday(rs.getString("birthday"));
                acc.setPhone_num(rs.getString(5));
                acc.setImage(rs.getString(6));
            }
            return acc;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public Account getInfobyID(int account_id){
        Account acc = new Account();
        String sql = "Select account.account_id, account.user_name, account.account_name, account.email, account.birthday," +
                " account.phone_num, account.image, address.address_id, address.province, address.district, address.address_detail, account.role_id from account join address on account.account_id = address.account_id where account.account_id=?";
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setInt(1, account_id);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                 acc = new Account(rs.getInt("account.account_id"),
                         rs.getString("user_name"),
                         rs.getString("account_name"),
                         rs.getString("email"),
                         rs.getString("birthday"),
                         rs.getString("phone_num"),
                         new Address(
                                 rs.getInt("address.address_id"),
                                 rs.getString("address.address_detail"),
                                 rs.getString("address.district"),
                                 rs.getString("address.province")),
                         rs.getString("image"),
                         rs.getInt("role_id"));

            }
            return acc;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public Account getInfobyName(String name){
        Account acc = new Account();
        String sql = "Select account_id,account_name,email,birthday,phone_num,image from account where account_name=?";
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setString(1, name);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                acc.setUser_name(rs.getString(2));
                acc.setEmail(rs.getString(3));
                acc.setBirthday(rs.getString(4));
                acc.setPhone_num(rs.getString(5));
                acc.setImage(rs.getString(6));
            }
            return acc;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        GetInfoAcc get = new GetInfoAcc();
//        System.out.println(get.getInfo("phamk.huy211199@gmail.com"));
//        System.out.println(get.getInfobyName("Phạm Huy"));
        System.out.println(get.getInfobyID(1));
    }
}
