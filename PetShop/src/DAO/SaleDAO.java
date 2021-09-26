package DAO;

import bean.Sale;
import connection.DBConnection;
import sun.security.pkcs11.Secmod;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {
    public static List<Sale> getSaleList(){
        List<Sale> list = new ArrayList<>();
        String sql = "select rate, pet_id, begin_date, end_date from sale";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int pet_id = resultSet.getInt("pet_id");
                double rate = resultSet.getDouble("rate");
                String begin_date = resultSet.getString("begin_date");
                String end_date = resultSet.getString("end_date");

                Sale sale = new Sale();
                sale.setRate(rate);
                sale.setPet_id(pet_id);
                sale.setBegin_date(begin_date);
                sale.setEnd_date(end_date);

                list.add(sale);

            }
            preparedStatement.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }

    public static double getSaleByPetID(int pet_id){
        String sql = "select rate from sale where pet_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, pet_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getDouble("rate");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void insertSale(Sale sale){
        String sql = "insert into sale values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, sale.getPet_id());
            preparedStatement.setDouble(2, sale.getRate());
            preparedStatement.setString(3, sale.getBegin_date());
            preparedStatement.setString(4, sale.getEnd_date());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSale(int id){
        String sql = "delete from sale where pet_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Sale getInfoSaleByPetID(int pet_id){
        String sql = "select * from sale where pet_id =?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, pet_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int pet_idd = resultSet.getInt("pet_id");
                double rate = resultSet.getDouble("rate");
                String begin_date = resultSet.getString("begin_date");
                String end_date = resultSet.getString("end_date");

                Sale sale = new Sale();
                sale.setPet_id(pet_idd);
                sale.setRate(rate);
                sale.setBegin_date(begin_date);
                sale.setEnd_date(end_date);
                return sale;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static void updateSale(Sale sale){
        String sql = "update sale set rate = ?, begin_date = ?, end_date = ? where pet_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setDouble(1, sale.getRate());
            preparedStatement.setString(2, sale.getBegin_date());
            preparedStatement.setString(3, sale.getEnd_date());
            preparedStatement.setInt(4, sale.getPet_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        System.out.println(getInfoSaleByPetID(1));
        Sale sale = new Sale(0.3, 3, "01/01/2020", "01/20/2020");
        updateSale(sale);
    }
}
