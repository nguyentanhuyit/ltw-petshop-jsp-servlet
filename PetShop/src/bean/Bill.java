package bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Bill implements Serializable {
    int bill_id;
    String account_name;
    Date bill_date;
    Date delivery_date;
    boolean payment;
    int total_price;
    String bill_status;
    List<Pet> listPet;
    String address;
    int deposit;

    public Bill(int bill_id, String account_name, Date bill_date, Date delivery_date, boolean payment, int total_price, String bill_status, List<Pet> listPet,int deposit) {
        this.bill_id = bill_id;
        this.account_name = account_name;
        this.bill_date = bill_date;
        this.delivery_date = delivery_date;
        this.payment = payment;
        this.total_price = total_price;
        this.bill_status = bill_status;
        this.listPet = listPet;
        this.deposit = deposit;
    }
    public Bill(int bill_id, String account_name, Date bill_date, Date delivery_date, boolean payment, int total_price, String bill_status,String address, int deposit) {
        this.bill_id = bill_id;
        this.account_name = account_name;
        this.bill_date = bill_date;
        this.delivery_date = delivery_date;
        this.payment = payment;
        this.total_price = total_price;
        this.bill_status = bill_status;
        this.address = address;
        this.deposit = deposit;
    }
    public  Bill(){
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public Date getBill_date() {
        return bill_date;
    }

    public void setBill_date(Date bill_date) {
        this.bill_date = bill_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getBill_status() {
        return bill_status;
    }

    public void setBill_status(String bill_status) {
        this.bill_status = bill_status;
    }

    public List<Pet> getListPet() {
        return listPet;
    }

    public void setListPet(List<Pet> listPet) {
        this.listPet = listPet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bill_id=" + bill_id +
                ", account_name='" + account_name + '\'' +
                ", bill_date=" + bill_date +
                ", delivery_date=" + delivery_date +
                ", payment=" + payment +
                ", total_price=" + total_price +
                ", bill_status='" + bill_status + '\'' +
                ", listPet=" + listPet +
                ", address='" + address + '\'' +
                ", deposit=" + deposit +
                '}';
    }
}
