package bean;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    private int account_id;
    private String user_name;
    private String pass;
    private String account_name;
    private String gender;
    private String email;
    private String birthday;
    private String phone_num;
    private Date reg_day; //ngay dang ky
    private String image; //hinh anh
    private int role_id;
    private Address address;

    public Account(int account_id, String user_name, String pass, String account_name, String gender, String email, String birthday, String phone_num, Date reg_day, String image, int role_id) {
        this.account_id = account_id;
        this.user_name = user_name;
        this.pass = pass;
        this.account_name = account_name;
        this.gender = gender;
        this.email = email;
        this.birthday = birthday;
        this.phone_num = phone_num;
        this.reg_day = reg_day;
        this.image = image;
        this.role_id = role_id;
    }

    public Account(int account_id, String user_name, String account_name, String email, String birthday, String phone_num, Address address, String image, int role_id) {
        this.account_id = account_id;
        this.user_name = user_name;
        this.account_name = account_name;
        this.email = email;
        this.birthday = birthday;
        this.phone_num = phone_num;
        this.address = address;
        this.image = image;
        this.role_id = role_id;
    }


    public Account() {
    }

    public int getAccount_id() {
        return account_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPass() {
        return pass;
    }

    public String getAccount_name() {
        return account_name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public Date getReg_day() {
        return reg_day;
    }

    public String getImage() {
        return image;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public void setReg_day(Date reg_day) {
        this.reg_day = reg_day;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", user_name='" + user_name + '\'' +
                ", pass='" + pass + '\'' +
                ", account_name='" + account_name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", phone_num='" + phone_num + '\'' +
                ", reg_day=" + reg_day +
                ", image='" + image + '\'' +
                ", role_id=" + role_id +
                '}';
    }
}
