package DAO;

import bean.DiscountCode;
import bean.Pet;
import connection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscountCodeEntity {
    public DiscountCode getCode(String code) {

        String sql = "select * from discountcode where code = ?";
        DiscountCode discountCode = new DiscountCode();
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setString(1, code);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                discountCode = new DiscountCode(rs.getString(1),rs.getDouble(2));
            }
            s.close();
            rs.close();
            return discountCode;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    public static void main(String[] args) {
        DiscountCodeEntity ds = new DiscountCodeEntity();
        System.out.println(ds.getCode("giamgia"));
    }
}
