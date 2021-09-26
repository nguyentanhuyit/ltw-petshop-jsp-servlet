package DAO;

import bean.Account;
import connection.DBConnection;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    public static boolean signUpAccount(Account account){
        String sql = "insert into account values (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            Connection connection = DBConnection.CreateConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,account.getAccount_id());
            preparedStatement.setString(2, account.getUser_name());
            preparedStatement.setString(3, account.getPass());
            preparedStatement.setString(4, account.getAccount_name());
            preparedStatement.setString(5, account.getGender());
            preparedStatement.setString(6, account.getEmail());
            preparedStatement.setString(7, account.getBirthday());
            preparedStatement.setString(8, account.getPhone_num());
            preparedStatement.setDate(9, (Date) account.getReg_day());
            preparedStatement.setString(10, account.getImage());
            preparedStatement.setInt(11,account.getRole_id());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
    public static Account loginAccount(String userName, String password){
        String sql = "select * from account where user_name =? and pass=?";
        Account account = new Account();
        Connection connection = DBConnection.CreateConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()){
                int account_id =resultSet.getInt("account_id");
                 String user_name=resultSet.getString("user_name");
                 String pass=resultSet.getString("pass");
                 String account_name=resultSet.getString("account_name");
                 String gender=resultSet.getString("gender");
                 String email=resultSet.getString("email");
                 String birthday = resultSet.getString("birthday");
                 String phone_num = resultSet.getString("phone_num");
                 java.sql.Date reg_day = resultSet.getDate("reg_day"); //ngay dang ky
                 String image= resultSet.getString("image"); //hinh anh
                 int role_id=resultSet.getInt("role_id");

                account.setAccount_id(account_id);
                account.setUser_name(user_name);
                account.setPass(pass);
                account.setAccount_name(account_name);
                account.setGender(gender);
                account.setEmail(email);
                account.setBirthday(birthday);
                account.setPhone_num(phone_num);
                account.setReg_day(reg_day);
                account.setImage(image);
                account.setRole_id(role_id);
                preparedStatement.close();
                connection.close();

                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateInfoAccount(Account account){
        String sql = "update account set user_name = ?, account_name = ?, email = ?, phone_num = ?, gender = ?, birthday =? " +
                "where account_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1,account.getUser_name());
            preparedStatement.setString(2, account.getAccount_name());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPhone_num());
            preparedStatement.setString(5, account.getGender());
            preparedStatement.setString(6, account.getBirthday());
            preparedStatement.setInt(7, account.getAccount_id());
            preparedStatement.executeUpdate();
//            System.out.println("ss");
            preparedStatement.close();
            DBConnection.CreateConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changePassword(Account account){
        String sql = "update account set pass =? " +
                "where account_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, account.getPass());
            preparedStatement.setInt(2, account.getAccount_id());
            preparedStatement.executeUpdate();
//            System.out.println("ss");
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Account> getAccountList(String role){
        List<Account> list = new ArrayList<>();
        String sql = "select * from account inner join role on account.role_id = role.role_id where role.role_name = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, role);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int account_id = resultSet.getInt("account_id");
                String user_name = resultSet.getString("user_name");
                String pass = resultSet.getString("pass");
                String account_name = resultSet.getString("account_name");
                String gender = resultSet.getString("gender");
                String email = resultSet.getString("email");
                String birthday = resultSet.getString("birthday");
                String phone_num = resultSet.getString("phone_num");
                java.sql.Date reg_day = resultSet.getDate("reg_day"); //ngay dang ky
                String image = resultSet.getString("image"); //hinh anh
                int role_id = resultSet.getInt("role_id");
                Account account = new Account();
                account.setAccount_id(account_id);
                account.setUser_name(user_name);
                account.setPass(pass);
                account.setAccount_name(account_name);
                account.setGender(gender);
                account.setEmail(email);
                account.setBirthday(birthday);
                account.setPhone_num(phone_num);
                account.setReg_day(reg_day);
                account.setImage(image);
                account.setRole_id(role_id);
                list.add(account);
            }
            preparedStatement.close();
            DBConnection.CreateConnection().close();
            return  list;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean updateAvatar(int account_id, String avatar){
        String sql = "update account set image = ? where account_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, avatar);
            preparedStatement.setInt(2, account_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return false;
    }

    public static List<Account> getListAccount(){
        List<Account> list = new ArrayList<>();
        String sql = "select * from account ";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int account_id = resultSet.getInt("account_id");
                String user_name = resultSet.getString("user_name");
                String pass = resultSet.getString("pass");
                String account_name = resultSet.getString("account_name");
                String gender = resultSet.getString("gender");
                String email = resultSet.getString("email");
                String birthday = resultSet.getString("birthday");
                String phone_num = resultSet.getString("phone_num");
                java.sql.Date reg_day = resultSet.getDate("reg_day"); //ngay dang ky
                String image = resultSet.getString("image"); //hinh anh
                int role_id = resultSet.getInt("role_id");
                Account account = new Account();
                account.setAccount_id(account_id);
                account.setUser_name(user_name);
                account.setPass(pass);
                account.setAccount_name(account_name);
                account.setGender(gender);
                account.setEmail(email);
                account.setBirthday(birthday);
                account.setPhone_num(phone_num);
                account.setReg_day(reg_day);
                account.setImage(image);
                account.setRole_id(role_id);
                list.add(account);
            }
            preparedStatement.close();
            DBConnection.CreateConnection().close();
            return  list;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Account> searchAccount(String keyword){
        List<Account> list = new ArrayList<>();
        String sql = "select * from account where account_name like '%"+keyword+"%'";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int account_id = resultSet.getInt("account_id");
                String user_name = resultSet.getString("user_name");
                String pass = resultSet.getString("pass");
                String account_name = resultSet.getString("account_name");
                String gender = resultSet.getString("gender");
                String email = resultSet.getString("email");
                String birthday = resultSet.getString("birthday");
                String phone_num = resultSet.getString("phone_num");
                java.sql.Date reg_day = resultSet.getDate("reg_day"); //ngay dang ky
                String image = resultSet.getString("image"); //hinh anh
                int role_id = resultSet.getInt("role_id");
                Account account = new Account();
                account.setAccount_id(account_id);
                account.setUser_name(user_name);
                account.setPass(pass);
                account.setAccount_name(account_name);
                account.setGender(gender);
                account.setEmail(email);
                account.setBirthday(birthday);
                account.setPhone_num(phone_num);
                account.setReg_day(reg_day);
                account.setImage(image);
                account.setRole_id(role_id);
                list.add(account);
            }
            preparedStatement.close();
            DBConnection.CreateConnection().close();
            return  list;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Account> sortAccount(String keyword){
        List<Account> list = new ArrayList<>();
        String sql = "select * from (account inner join role on account.role_id = role.role_id) where role.role_name = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, keyword);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int account_id = resultSet.getInt("account_id");
                String user_name = resultSet.getString("user_name");
                String pass = resultSet.getString("pass");
                String account_name = resultSet.getString("account_name");
                String gender = resultSet.getString("gender");
                String email = resultSet.getString("email");
                String birthday = resultSet.getString("birthday");
                String phone_num = resultSet.getString("phone_num");
                java.sql.Date reg_day = resultSet.getDate("reg_day"); //ngay dang ky
                String image = resultSet.getString("image"); //hinh anh
                int role_id = resultSet.getInt("role_id");
                Account account = new Account();
                account.setAccount_id(account_id);
                account.setUser_name(user_name);
                account.setPass(pass);
                account.setAccount_name(account_name);
                account.setGender(gender);
                account.setEmail(email);
                account.setBirthday(birthday);
                account.setPhone_num(phone_num);
                account.setReg_day(reg_day);
                account.setImage(image);
                account.setRole_id(role_id);
                list.add(account);
            }
            preparedStatement.close();
            DBConnection.CreateConnection().close();
            return  list;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean deleteAccount(int account_id){
        String sql ="delete from account where account_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, account_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Account getInfoAccountById(int id) {
        String sql = "select * from (account inner join role on account.role_id = role.role_id) where account.account_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int account_id = resultSet.getInt("account_id");
                String user_name = resultSet.getString("user_name");
                String pass = resultSet.getString("pass");
                String account_name = resultSet.getString("account_name");
                String gender = resultSet.getString("gender");
                String email = resultSet.getString("email");
                String birthday = resultSet.getString("birthday");
                String phone_num = resultSet.getString("phone_num");
                java.sql.Date reg_day = resultSet.getDate("reg_day"); //ngay dang ky
                String image = resultSet.getString("image"); //hinh anh
                int role_id = resultSet.getInt("role_id");
                Account account = new Account();
                account.setAccount_id(account_id);
                account.setUser_name(user_name);
                account.setPass(pass);
                account.setAccount_name(account_name);
                account.setGender(gender);
                account.setEmail(email);
                account.setBirthday(birthday);
                account.setPhone_num(phone_num);
                account.setReg_day(reg_day);
                account.setImage(image);
                account.setRole_id(role_id);
               return account;
            }
            preparedStatement.close();
            DBConnection.CreateConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void updateAccountAdmin(Account account){
        String sql = "update account set user_name = ?, account_name = ?, email = ?, phone_num = ?, gender = ?, birthday =?, pass = ?, image = ?, role_id = ? " +
                "where account_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, account.getUser_name());
            preparedStatement.setString(2, account.getAccount_name());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPhone_num());
            preparedStatement.setString(5, account.getGender());
            preparedStatement.setString(6, account.getBirthday());
            preparedStatement.setString(7, account.getPass());
            preparedStatement.setString(8, account.getImage());
            preparedStatement.setInt(9, account.getRole_id());
            preparedStatement.setInt(10, account.getAccount_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        System.out.println(loginAccount("nguyentanhuy", "nguyentanhuy"));
        Account account = new Account(24, "hynguyen", "hynguyen123", "Nguyễn Tấn hy", "Nam", "abc@gmail.com", "2020-1-1", "0363778884", new Date(2020,1,1),"",2);
        updateInfoAccount(account);
//        changePassword(account);
//            System.out.println(getInfoAccountById(1));
    }
}
