package bean;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Pet implements Serializable {
    private int id;
    private String petName;
    private int size_id;
    private String gender;
    private double weight;
    private String color;
    private int age;
    private int category_id;
    private int sellPrice;
    private int netPrice;
    private int quantity;
    private Photo photo;
    private String petStatus;
    private String description;
    private int sell_quantity;
    public Pet(){

    }


    public Pet(int id, String petName, int size_id, String gender, double weight, String color, int age, int category_id, int sellPrice, int netPrice, int quantity, Photo photo, String petStatus, String description, int sell_quantity){
        this.id=id;
        this.petName = petName;
        this.size_id=size_id;
        this.gender = gender;
        this.weight= weight;
        this.color =  color;
        this.age=age;
        this.category_id= category_id;
        this.sellPrice=sellPrice;
        this.netPrice= netPrice;
        this.quantity=quantity;
        this.photo = photo;
        this.petStatus=petStatus;
        this.description=description;
        this.sell_quantity = sell_quantity;
    }

    public int getId() {
        return id;
    }

    public String getPetName() {
        return petName;
    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public int getCategory_id() {
        return category_id;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public int getNetPrice() {
        return netPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPetStatus() {
        return petStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    public void setPetStatus(String petStatus) {
        this.petStatus = petStatus;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public int getSell_quantity() {
        return sell_quantity;
    }

    public void setSell_quantity(int sell_quantity) {
        this.sell_quantity = sell_quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String formatPrice(){
        return String.format("%,.0f",sellPrice);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", petName='" + petName + '\'' +
                ", size_id=" + size_id +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", category_id=" + category_id +
                ", sellPrice=" + sellPrice +
                ", netPrice=" + netPrice +
                ", quantity=" + quantity +
                ", photo=" + photo +
                ", petStatus='" + petStatus + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void add() {
        this.quantity++;
    }
    public void quantityUp() {
        this.quantity++;

    }
    public void quantityDown() {
//        this.quantity--;
//        if (quantity < 1) {
//            quantity = 2;
//            this.quantity--;
//
//        }
        setQuantitys(this.quantity - 1);

    }
    public void quantityUP() {
        setQuantitys(this.quantity +1);
    }
    public int setQuantitys(int quantity) {
        if (quantity < 1) {
            quantity = 1;
        }
        this.quantity = quantity;
        return quantity;
    }
    public static String currencyFormat(double price) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        String format = vn.format(price)+"đ";
        return format;
    }

    public static void main(String[] args) {
        System.out.println(currencyFormat(200000));
    }
}
