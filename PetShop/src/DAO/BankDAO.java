package DAO;

import bean.Bank;
import bean.BankCart;
import connection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BankDAO {
    public List<Bank> getBank() {
        List<Bank> list = new LinkedList<>();
        String sql = "select * from bank";
        Bank bank = new Bank();
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                bank = new Bank(rs.getString("bank_id"), rs.getString("bank_name"));
                list.add(bank);
            }
            s.close();
            rs.close();
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Bank getBank(String bank_id) {
        String sql = "Select * from bank where bank_id=?";
        Bank bank = new Bank();
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setString(1, bank_id);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                bank = new Bank(rs.getString("bank_id"), rs.getString("bank_name"));
            }
            return bank;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public BankCart getBankCart(String bank_id) {

        String sql = "Select * from bankcart where bankcart.bank_id=?";
        BankCart bankCart = new BankCart();
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setString(1, bank_id);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                bankCart = new BankCart(rs.getString("owner_name"), rs.getString("bank_id"), rs.getString("bank_code"), rs.getLong("money"));
            }
            s.close();
            rs.close();
            return bankCart;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    //    trừ tiền nè
    public void deduction(double total_price, String owner_name, String bank_id, String bank_code) {

        String sql = "update bankcart set money = money-" + total_price + " where owner_name=? and bank_id=? and bank_code=?";
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setString(1, owner_name);
            s.setString(2, bank_id);
            s.setString(3, bank_code);
            s.executeUpdate();
            s.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void addmoney(double total_price) {

        String sql = "update bankcart set money = money+" + total_price + " where owner_name='PET SHOP' and bank_id='bidv' and bank_code='123456789'";
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.executeUpdate();
            s.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

    public static void main(String[] args) {
        BankDAO bank = new BankDAO();
        System.out.println(bank.getBankCart("bidv"));
    }
}


//


