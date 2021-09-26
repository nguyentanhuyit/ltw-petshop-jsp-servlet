package DAO;

import bean.Category;
import connection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    public static Category getCategoryInPetDetail(int pet_id){
        String sql =  "select * from pet inner join category on pet.category_id = category.category_id where pet.pet_id = ? ";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, pet_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int category_id = resultSet.getInt("category_id");
                String category_name = resultSet.getString("category_name");
                int species_id = resultSet.getInt("species_id");

                Category category = new Category();
                category.setCategory_id(category_id);
                category.setCategory_name(category_name);
                category.setSpecies_id(species_id);
                preparedStatement.close();
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Category> getListCategory(String species_name){
        List<Category> list = new ArrayList<>();
        String sql = "select * from category inner join species on category.species_id = species.species_id " +
                "where species.species_name=?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, species_name);
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                int category_id = resultSet.getInt("category_id");
                String category_name = resultSet.getString("category_name");
                int species_id = resultSet.getInt("species_id");
                String photo = resultSet.getString("photo");
                Category category = new Category();
                category.setCategory_id(category_id);
                category.setCategory_name(category_name);
                category.setSpecies_id(species_id);
                category.setPhoto(photo);
                list.add(category);

            }
            preparedStatement.close();
            DBConnection.CreateConnection().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Category> getListCategory(){
        List<Category> list = new ArrayList<>();
        String sql = "select * from category";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                int category_id = resultSet.getInt("category_id");
                String category_name = resultSet.getString("category_name");
                int species_id = resultSet.getInt("species_id");
                String photo = resultSet.getString("photo");
                Category category = new Category();
                category.setCategory_id(category_id);
                category.setCategory_name(category_name);
                category.setSpecies_id(species_id);
                category.setPhoto(photo);
                list.add(category);

            }
            preparedStatement.close();
            DBConnection.CreateConnection().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertCategory(Category category){
        String sql = "insert into category values (?, ?, ? ,?)";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, category.getCategory_id());
            preparedStatement.setString(2, category.getCategory_name());
            preparedStatement.setInt(3, category.getSpecies_id());
            preparedStatement.setString(4, category.getPhoto());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            DBConnection.CreateConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Category> searchCategory(String key){
        List<Category> list = new ArrayList<>();
        String sql = "select * from (category inner join species on category.species_id = species.species_id)" +
                "where category.category_id = '"+key+"' or species.species_name = '%"+key+"%' " +
                "or category.category_name like '"+key+"%'";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int category_id = resultSet.getInt("category_id");
                String category_name = resultSet.getString("category_name");
                int species_id = resultSet.getInt("species_id");
                String photo = resultSet.getString("photo");

                Category category = new Category();
                category.setCategory_id(category_id);
                category.setCategory_name(category_name);
                category.setSpecies_id(species_id);
                category.setPhoto(photo);
                list.add(category);
            }
            DBConnection.CreateConnection().close();
            resultSet.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateCategory(Category category){
        String sql = "update category set category_name = ? , photo = ? where category_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, category.getCategory_name());
            preparedStatement.setString(2, category.getPhoto());
            preparedStatement.setInt(3, category.getCategory_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Category getCategory(int category_id){
        String sql = "select * from category where category_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, category_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt("category_id");
                String category_name = resultSet.getString("category_name");
                int species_id = resultSet.getInt("species_id");
                String photo = resultSet.getString("photo");

                Category category = new Category();
                category.setCategory_id(id);
                category.setCategory_name(category_name);
                category.setSpecies_id(species_id);
                category.setPhoto(photo);
                return category;
            }
            DBConnection.CreateConnection().close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }

    public static boolean deleteCategory(int category_id){
        String sql = "delete from category where category_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, category_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(getCategoryInPetDetail(1));
//        System.out.println(getListCategory(""));
//        Category category = new Category();
//        category.setPhoto("hhhh");
//        category.setCategory_name("ddd");
//        category.setSpecies_id(1);
//        insertCategory(category);
//        System.out.println(getCategory(1));
        Category category = new Category();
        category.setPhoto("user/img/categories/alaska.jpg");
        category.setCategory_name("alaska");
        category.setCategory_id(1);
        updateCategory(category);
    }
}
