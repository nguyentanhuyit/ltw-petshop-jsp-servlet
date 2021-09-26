package bean;

import java.io.Serializable;

public class BillDetail implements Serializable {
    int billdetail_id;
    int bill_id;
    int pet_id;
    String pet_name;
    int quantity;
    int amount;
    int total;
    int deposit;

    public BillDetail() {
    }

    public BillDetail(int bill_id, int pet_id, String pet_name, int quantity, int amount, int total) {
        this.bill_id = bill_id;
        this.pet_id = pet_id;
        this.pet_name = pet_name;
        this.quantity = quantity;
        this.amount = amount;
        this.total = total;
    }

    public BillDetail(int bill_id, int pet_id, String pet_name, int quantity, int amount, int total, int deposit) {
        this.bill_id = bill_id;
        this.pet_id = pet_id;
        this.pet_name = pet_name;
        this.quantity = quantity;
        this.amount = amount;
        this.total = total;
        this.deposit = deposit;
    }

    public BillDetail(int billdetail_id, int bill_id, int pet_id, int quantity) {
        this.billdetail_id = billdetail_id;
        this.bill_id = bill_id;
        this.pet_id = pet_id;
        this.quantity = quantity;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getPet_name() {
        return pet_name;
    }

    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getBilldetail_id() {
        return billdetail_id;
    }

    public void setBilldetail_id(int billdetail_id) {
        this.billdetail_id = billdetail_id;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "bill_id='" + bill_id + '\'' +
                ", pet_id=" + pet_id +
                ", pet_name='" + pet_name + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", total=" + total +
                ", deposit=" + deposit +
                '}';
    }
}
