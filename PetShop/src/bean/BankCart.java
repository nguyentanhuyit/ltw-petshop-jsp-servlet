package bean;

public class BankCart {
    String owner_name;
    String bank_id;
    String bank_code;
    long money;

    public BankCart(String owner_name, String bank_id, String bank_code, long money) {
        this.owner_name = owner_name;
        this.bank_id = bank_id;
        this.bank_code = bank_code;
        this.money = money;
    }

    public BankCart() {
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "BankCart{" +
                "owner_name='" + owner_name + '\'' +
                ", bank_id='" + bank_id + '\'' +
                ", bank_code='" + bank_code + '\'' +
                ", money=" + money +
                '}';
    }
}
