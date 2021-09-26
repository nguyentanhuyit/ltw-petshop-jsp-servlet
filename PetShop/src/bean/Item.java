package bean;

import java.text.NumberFormat;
import java.util.Locale;

public class Item {
    int item_id;
    Pet pet;
    int item_quantity;
    double price;

    public Item() {
    }

    public Item(int item_id, Pet pet, int item_quantity, double price) {
        this.item_id = item_id;
        this.pet = pet;
        this.item_quantity = item_quantity;
        this.price = price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", pet=" + pet +
                ", item_quantity=" + item_quantity +
                ", price=" + price +
                '}';
    }

    public String currencyFormat(double price) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        String format = vn.format(price);
        return format;
    }
    public void quantityUp() {
        this.item_quantity++;
//        if (quantity > 5) {
//            this.quantity++;
//
//        }
    }
}
