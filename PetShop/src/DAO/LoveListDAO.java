package DAO;

import bean.Account;
import bean.LoveList;
import bean.Pet;
import bean.Photo;
import connection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoveListDAO {
    public static List<Pet> getLoveList(int user_id){
        List<Pet> list = new ArrayList<>();
        String sql = "select * from love_list ll inner join pet p on ll.pet_id = p.pet_id inner join photo pt on p.pet_id = pt.pet_id" +
                "  where ll.account_id =?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
           preparedStatement.setInt(1, user_id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                int pet_id = resultSet.getInt("pet_id");
                String pet_name = resultSet.getString("pet_name");
                int size_id = resultSet.getInt("size_id");
                String gender = resultSet.getString("gender");
                double weight = resultSet.getDouble("weight");
                String color = resultSet.getString("color");
                int age = resultSet.getInt("age");
                int category_id = resultSet.getInt("category_id");
                int sell_price = resultSet.getInt("sell_price");
                int net_price = resultSet.getInt("net_price");
                int quantity = resultSet.getInt("quantity");
                String pet_status = resultSet.getString("pet_status");
                String description = resultSet.getString("description");

                int photo_id = resultSet.getInt("photo_id");
                String photo_main = resultSet.getString("photo_main");
                String photo_main_1 = resultSet.getString("photo_main_1");
                String photo_main_2 = resultSet.getString("photo_main_2");
                String photo_main_3 = resultSet.getString("photo_main_3");
                String photo_main_4 = resultSet.getString("photo_main_4");

                Photo photo = new Photo();
                photo.setPhoto_id(photo_id);
                photo.setPhoto_main(photo_main);
                photo.setPhoto_main_1(photo_main_1);
                photo.setPhoto_main_2(photo_main_2);
                photo.setPhoto_main_3(photo_main_3);
                photo.setPhoto_main_4(photo_main_4);

                Pet pet = new Pet();
                pet.setId(pet_id);
                pet.setPetName(pet_name);
                pet.setSize_id(size_id);
                pet.setGender(gender);
                pet.setWeight(weight);
                pet.setColor(color);
                pet.setAge(age);
                pet.setCategory_id(category_id);
                pet.setSellPrice(sell_price);
                pet.setNetPrice(net_price);
                pet.setQuantity(quantity);
                pet.setPhoto(photo);
                pet.setPetStatus(pet_status);
                pet.setDescription(description);
                list.add(pet);
            }
            preparedStatement.close();
            DBConnection.CreateConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getLoveList(22));
    }
}
