package DAO;

import bean.Bill;
import bean.BillDetail;
import com.mysql.jdbc.Statement;
import connection.DBConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class BillDAO {
    public Bill getBillByID(int bill_id) {
        String sql = "select bill.bill_id,account.account_name,bill.bill_date, bill.delivery_date,bill.payment,bill.total_price,bill.bill_status,bill.address,bill.deposit from bill join account on bill.account_id = account.account_id where bill_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, bill_id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Bill bill = new Bill(rs.getInt("bill_id"),
                        rs.getString("account_name"),
                        rs.getDate("bill_date"),
                        rs.getDate("delivery_date"),
                        rs.getBoolean("payment"),
                        rs.getInt("total_price"),
                        rs.getString("bill_status"),
                        rs.getString("address"),
                        rs.getInt("deposit"));
                return bill;
            }
            preparedStatement.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;

    }

    public List<Bill> getAll() {
        // lay data bill
        List<Bill> list = new LinkedList<>();
        String sql = "select bill.bill_id, account.account_name, bill.bill_date, bill.delivery_date, bill.payment, bill.total_price, " +
                "bill.bill_status,bill.address,bill.deposit from bill join account on bill.account_id = account.account_id ";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt("bill_id"),
                        rs.getString("account_name"),
                        rs.getDate("bill_date"),
                        rs.getDate("delivery_date"),
                        rs.getBoolean("payment"),
                        rs.getInt("total_price"),
                        rs.getString("bill_status"),
                        rs.getString("address"),
                        rs.getInt("deposit")));
            }
            rs.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //lay thong tin chung cua bill
    public String[] getBillDetail(String bill_id) {
        String[] arr = new String[7];
        String sql = "SELECT bill.bill_id,account.account_name, bill.address, account.phone_num, bill.bill_status, bill.deposit, bill.payment FROM account" +
                " JOIN bill on account.account_id = bill.account_id JOIN address on address.account_id = account.account_id WHERE bill_id=?";

        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setString(1, bill_id);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                String s1 = rs.getString("bill_id");
                String s2 = rs.getString("account_name");
                String s3 = rs.getString("address");
                String s4 = rs.getString("phone_num");
                String s5 = rs.getString("bill_status");
                String s6 = rs.getString("deposit");
                boolean check = rs.getBoolean("payment");
                String s7;
                if (check = true) {
                    s7 = "Đã thanh toán";
                } else {
                    s7 = "Chưa thanh toán";
                }
                arr = new String[]{s1, s2, s3, s4, s5, s6, s7};
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == null) {
                        arr[i] = "(trống)";
                    }
                }
            }
            return arr;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public List<BillDetail> getListPetBill(int bill_id) {

        String sql = "select bill_detail.bill_id,bill_detail.pet_id, pet.pet_name,bill_detail.quantity, pet.sell_price from bill_detail join pet on bill_detail.pet_id = pet.pet_id where bill_detail.bill_id = ?";
        try {
            List<BillDetail> list = new LinkedList<>();
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setInt(1, bill_id);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                list.add(new BillDetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(4) * rs.getInt(5)));
            }
            rs.close();
            s.close();
            System.out.println(list);
            System.out.println("after \n" + list);
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return new LinkedList<>();
        }

    }

    public int total(int bill_id) {
        Bill bill = getBillByID(bill_id);
        List<BillDetail> list = getListPetBill(bill_id);
        int total = 0;
        if (bill.isPayment() == true) {
            return total;
        } else {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i).getTotal();
            }
            total = sum - bill.getDeposit();
            return total;
        }
    }

    public boolean deleteBill(String bill_id) {


        try {
//            xoa bildetail
            String sql1 = "Delete from  bill_detail where bill_id=?";
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql1);
            s.setString(1, bill_id);
            s.executeUpdate();

            String sql2 = "Delete from  bill where bill_id=?";
            PreparedStatement s1 = DBConnection.CreateConnection().prepareStatement(sql2);
            s1.setString(1, bill_id);
            s1.executeUpdate();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }

    public String print(String[] arr) {
        String rs = "";
        for (int i = 0; i < arr.length; i++) {
            rs += arr[i] + ", ";
        }
        return rs;
    }

    public boolean addBill(int account_id, Bill Bill) throws SQLException {

        String sql = "insert into bill values (?,?,?,?,?,?,?,?,?)";
        long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);

        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setInt(1, Bill.getBill_id());
            s.setInt(2, account_id);
            s.setDate(3, date);
            s.setDate(4, null);
            s.setBoolean(5, Bill.isPayment());
            s.setInt(6, Bill.getTotal_price());
            s.setString(7, Bill.getBill_status());
            s.setString(8, Bill.getAddress());
            s.setInt(9, Bill.getDeposit());
//            s.setInt(2, Bill.get());

            s.execute();
            s.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addBillDetail(BillDetail billDetail) throws SQLException {

        String sql = "insert into bill_detail values (?,?,?,?)";
        try {
            PreparedStatement s = DBConnection.CreateConnection().prepareStatement(sql);
            s.setInt(1, billDetail.getBilldetail_id());
            s.setInt(2, billDetail.getBill_id());
            s.setInt(3, billDetail.getPet_id());
            s.setInt(4, billDetail.getQuantity());
            s.execute();
            s.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
