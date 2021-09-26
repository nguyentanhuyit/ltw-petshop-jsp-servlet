package DAO;

import bean.Pet;
import bean.Photo;
import bean.Sale;
import connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PetDAO {

    public static List<Pet> getInfoPet() {
        List<Pet> listPet = new ArrayList<>();
        String sql = "select * from pet inner join photo where pet.pet_id = photo.pet_id";

        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
                String descriptipn = resultSet.getString("description");
                int sell_quantity = resultSet.getInt("sell_quantity");

                String photo_main = resultSet.getString("photo_main");
                String photo_main_1 = resultSet.getString("photo_main_1");
                String photo_main_2 = resultSet.getString("photo_main_2");
                String photo_main_3 = resultSet.getString("photo_main_3");
                String photo_main_4 = resultSet.getString("photo_main_4");

                Photo photo = new Photo();
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
                pet.setDescription(descriptipn);
                pet.setSell_quantity(sell_quantity);
                listPet.add(pet);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPet;
    }

    public static List<Pet> searchPet(String keyword) {
        List<Pet> listPet = new ArrayList<>();
        String sql = "select * from (((pet inner join photo on pet.pet_id = photo.pet_id)" +
                " inner join category on pet.category_id = category.category_id) " +
                "inner join species on category.species_id = species.species_id)" +
                "where pet.pet_name like '"+keyword+"%' or pet.gender like '"+keyword+"%' " +
                "or pet.color like '"+keyword+"%' or category.category_name like '"+keyword+"%' or species.species_name like '"+keyword+"%'";
        Connection connection = DBConnection.CreateConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
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
                String descriptipn = resultSet.getString("description");
                int sell_quantity = resultSet.getInt("sell_quantity");

                String photo_main = resultSet.getString("photo_main");
                String photo_main_1 = resultSet.getString("photo_main_1");
                String photo_main_2 = resultSet.getString("photo_main_2");
                String photo_main_3 = resultSet.getString("photo_main_3");
                String photo_main_4 = resultSet.getString("photo_main_4");

                Photo photo = new Photo();
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
                pet.setDescription(descriptipn);
                pet.setSell_quantity(sell_quantity);
                listPet.add(pet);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return listPet;
    }

    public static Pet getPetInfoDetail(int id){
        String sql = "select * from pet inner join photo on pet.pet_id = photo.pet_id where pet.pet_id=?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
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
                String descriptipn = resultSet.getString("description");
                int sell_quantity = resultSet.getInt("sell_quantity");

                String photo_main = resultSet.getString("photo_main");
                String photo_main_1 = resultSet.getString("photo_main_1");
                String photo_main_2 = resultSet.getString("photo_main_2");
                String photo_main_3 = resultSet.getString("photo_main_3");
                String photo_main_4 = resultSet.getString("photo_main_4");

                Photo photo = new Photo();
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
                pet.setDescription(descriptipn);
                pet.setSell_quantity(sell_quantity);
                return pet;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Pet> getListLatestProduct(int num){
        List<Pet> list = new ArrayList<>();
        String sql = "select * from pet inner join photo on pet.pet_id = photo.pet_id order by pet.pet_id desc limit ?";
//        String sql = "select top ('"+num+"') * from pet inner join photo on pet.photo_id = photo.photo_id order by pet.pet_id desc";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, num);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
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
                String descriptipn = resultSet.getString("description");
                int sell_quantity = resultSet.getInt("sell_quantity");

                String photo_main = resultSet.getString("photo_main");
                String photo_main_1 = resultSet.getString("photo_main_1");
                String photo_main_2 = resultSet.getString("photo_main_2");
                String photo_main_3 = resultSet.getString("photo_main_3");
                String photo_main_4 = resultSet.getString("photo_main_4");

                Photo photo = new Photo();
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
                pet.setDescription(descriptipn);
                pet.setSell_quantity(sell_quantity);
                list.add(pet);
            }
            resultSet.close();
            preparedStatement.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPet(int id){
        String sql = "select pet_name from pet where pet_id = ?";
//        String sql = "select top ('"+num+"') * from pet inner join photo on pet.photo_id = photo.photo_id order by pet.pet_id desc";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String pet_name = resultSet.getString("pet_name");
                return pet_name;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Pet> listPetSpecies(String species){
        List<Pet> list = new ArrayList<>();
        String sql = "select pet.*, photo.* from (((pet inner join photo on pet.pet_id = photo.pet_id)" +
                " inner join category on pet.category_id = category.category_id)" +
                "inner join species on category.species_id = species.species_id)" +
                "where species_name = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, species);
            ResultSet resultSet = preparedStatement.executeQuery();
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
                String descriptipn = resultSet.getString("description");
                int sell_quantity = resultSet.getInt("sell_quantity");

                String photo_main = resultSet.getString("photo_main");
                String photo_main_1 = resultSet.getString("photo_main_1");
                String photo_main_2 = resultSet.getString("photo_main_2");
                String photo_main_3 = resultSet.getString("photo_main_3");
                String photo_main_4 = resultSet.getString("photo_main_4");

                Photo photo = new Photo();
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
                pet.setDescription(descriptipn);
                pet.setSell_quantity(sell_quantity);
                list.add(pet);
            }
            preparedStatement.close();
            resultSet.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static List<Pet> listLatestSale(int num){
        List<Pet> list = new ArrayList<>();
        String sql = "select pet.*, photo.* from ((sale inner join pet on sale.pet_id = pet.pet_id)" +
                "inner join photo on pet.pet_id = photo.pet_id) order by sale.pet_id desc limit ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, num);
            ResultSet resultSet = preparedStatement.executeQuery();
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
                String descriptipn = resultSet.getString("description");
                int sell_quantity = resultSet.getInt("sell_quantity");

                String photo_main = resultSet.getString("photo_main");
                String photo_main_1 = resultSet.getString("photo_main_1");
                String photo_main_2 = resultSet.getString("photo_main_2");
                String photo_main_3 = resultSet.getString("photo_main_3");
                String photo_main_4 = resultSet.getString("photo_main_4");

                Photo photo = new Photo();
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
                pet.setDescription(descriptipn);
                pet.setSell_quantity(sell_quantity);
                list.add(pet);
            }
            preparedStatement.close();
            resultSet.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Pet> listBestSell(int num){
        List<Pet> list = new ArrayList<>();
        String sql = "select pet.*, photo.* from (((pet inner join photo on pet.pet_id = photo.pet_id)" +
                "inner join bill_detail on pet.pet_id = bill_detail.pet_id)" +
                "inner join bill on bill_detail.bill_id = bill.bill_id)" +
                "order by bill.bill_id desc limit ?";

        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, num);
            ResultSet resultSet = preparedStatement.executeQuery();
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
                String descriptipn = resultSet.getString("description");
                int sell_quantity = resultSet.getInt("sell_quantity");

                String photo_main = resultSet.getString("photo_main");
                String photo_main_1 = resultSet.getString("photo_main_1");
                String photo_main_2 = resultSet.getString("photo_main_2");
                String photo_main_3 = resultSet.getString("photo_main_3");
                String photo_main_4 = resultSet.getString("photo_main_4");

                Photo photo = new Photo();
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
                pet.setDescription(descriptipn);
                pet.setSell_quantity(sell_quantity);
                list.add(pet);
            }
            preparedStatement.close();
            resultSet.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Pet> listPetSale(){
        List<Pet> list = new ArrayList<>();
        String sql = "select pet.*, photo.* from ((sale inner join pet on sale.pet_id = pet.pet_id)" +
                "inner join photo on pet.pet_id = photo.pet_id)";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
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
                String descriptipn = resultSet.getString("description");
                int sell_quantity = resultSet.getInt("sell_quantity");

                String photo_main = resultSet.getString("photo_main");
                String photo_main_1 = resultSet.getString("photo_main_1");
                String photo_main_2 = resultSet.getString("photo_main_2");
                String photo_main_3 = resultSet.getString("photo_main_3");
                String photo_main_4 = resultSet.getString("photo_main_4");

                Photo photo = new Photo();
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
                pet.setDescription(descriptipn);
                pet.setSell_quantity(sell_quantity);
                list.add(pet);
            }
            preparedStatement.close();
            resultSet.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Pet> getListRelative(int num, String key){
        List<Pet> list = new ArrayList<>();
        String sql = "select pet.*, photo.* from ((pet inner join category on pet.category_id = category.category_id)" +
                "inner join photo on pet.pet_id = photo.pet_id) where category.category_name like ?" +
                "order by pet.pet_id desc limit ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, "%"+key+"%");
            preparedStatement.setInt(2, num);
            ResultSet resultSet = preparedStatement.executeQuery();
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
                String descriptipn = resultSet.getString("description");
                int sell_quantity = resultSet.getInt("sell_quantity");

                String photo_main = resultSet.getString("photo_main");
                String photo_main_1 = resultSet.getString("photo_main_1");
                String photo_main_2 = resultSet.getString("photo_main_2");
                String photo_main_3 = resultSet.getString("photo_main_3");
                String photo_main_4 = resultSet.getString("photo_main_4");

                Photo photo = new Photo();
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
                pet.setDescription(descriptipn);
                pet.setSell_quantity(sell_quantity);
                list.add(pet);
            }
            preparedStatement.close();
            resultSet.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Pet> getListBySize(String size){
        List<Pet> list = new ArrayList<>();
        String sql = "select pet.*, photo.* from ((pet inner join photo on pet.pet_id = photo.pet_id)" +
                "inner join size on pet.size_id = size.size_id)" +
                "where size.size_name =?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, size);
            ResultSet resultSet = preparedStatement.executeQuery();
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
                String descriptipn = resultSet.getString("description");
                int sell_quantity = resultSet.getInt("sell_quantity");

                String photo_main = resultSet.getString("photo_main");
                String photo_main_1 = resultSet.getString("photo_main_1");
                String photo_main_2 = resultSet.getString("photo_main_2");
                String photo_main_3 = resultSet.getString("photo_main_3");
                String photo_main_4 = resultSet.getString("photo_main_4");

                Photo photo = new Photo();
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
                pet.setDescription(descriptipn);
                pet.setSell_quantity(sell_quantity);

                list.add(pet);
            }
            resultSet.close();
            preparedStatement.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Pet> getListPetNameNotSale(){
        List<Pet> listPet_name = new ArrayList<>();
        String sql = "select * from pet where pet_id not in (select pet_id from sale)";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
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
                String descriptipn = resultSet.getString("description");
                int sell_quantity = resultSet.getInt("sell_quantity");

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
                pet.setPetStatus(pet_status);
                pet.setDescription(descriptipn);
                pet.setSell_quantity(sell_quantity);
                listPet_name.add(pet);
            }
            resultSet.close();
            preparedStatement.close();
            return listPet_name;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deletePet(int pet_id){
        String sql = "delete from pet where pet_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, pet_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

//        List<Pet> listBestSale = PetDAO.listBestSell(6);
//        List<Pet> listBestSale1 = new ArrayList<>();
//        List<Pet> listBestSale2 = new ArrayList<>();
//        for (int i =0; i<listBestSale.size()/2;i++){
//            listBestSale1.add(listBestSale.get(i));
//        }
//        for (int i =listBestSale.size()/2; i<listBestSale.size();i++){
//            listBestSale2.add(listBestSale.get(i));
//        }
//        System.out.println(listBestSale1);
//        System.out.println(listBestSale2);

//        System.out.println(getListPetNameNotSale());
//        String a = "5 alaska 12";
//        String[] arr = a.split(" ");
//        System.out.println(arr[0]);
//        System.out.println(getListRelative(4, "alaska"));
        System.out.println(getInfoPet());
    }


}
