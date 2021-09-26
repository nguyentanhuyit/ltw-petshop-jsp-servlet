package bean;

import DAO.DiscountCodeEntity;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.*;

public class Cart implements Serializable {

    Map<Integer, Pet> data = new HashMap<>() ;

    public Cart() {

    }

    public void setData(Map<Integer, Pet> data) {
        this.data = data;
    }

    public Pet get(String pet_id) {
        return data.get(pet_id);
    }

    public void put(Pet p) {
        if (p==null) return;
        if (data.containsKey(p.getId())) {
            data.get(p.getId()).add();
            return;
        } else {
            data.put(p.getId(), p);
        }
    }

    public void update(int pet_id, int quantity){
        if (quantity<0) return;
        if (data.containsKey(pet_id)) data.get(pet_id).setQuantitys(quantity);
    }

    public void remove(int pet_id){
        data.remove(pet_id);
    }

    public long total() {
        long   total = 0;
        for (Pet pet : data.values()) {
            total += pet.getSellPrice()*pet.getQuantity();
        }
        return total;
    }

    public long totalAfterDiscount(double rate) {
        DiscountCode discountCode = new DiscountCode();
        rate = discountCode.getRate();
        long total = (long) (total() - total() * rate);
            return total;
    }


    public static Cart getCart(HttpSession session){
        return session.getAttribute("cart") == null ? new Cart(): (Cart) session.getAttribute("cart");
    }

    public Collection<Pet> getDt(){ return  data.values();}

    public void commit(HttpSession session){
        session.setAttribute("cart", this); 
    }


    public static  String currencyFormat(double price) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        String format = vn.format(price);
        return format;
    }


}
