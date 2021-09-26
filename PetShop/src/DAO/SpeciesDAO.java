package DAO;

import bean.Category;
import bean.Species;
import connection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpeciesDAO {
    public static List<Species> getListSpecies(){
        List<Species> list = new ArrayList<>();
        String sql = "select * from species";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
           ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int species_id = resultSet.getInt("species_id");
                String species_name = resultSet.getString("species_name");

                Species species = new Species();
                species.setSpecies_id(species_id);
                species.setSpecies_name(species_name);
                list.add(species);
            }
            preparedStatement.close();
            DBConnection.CreateConnection().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Species> getListSpeciesAdmin(){
        List<Species> list = new ArrayList<>();
        String sql = "select * from species inner join category on species.species_id = category.species_id";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int species_id = resultSet.getInt("species_id");
                String species_name = resultSet.getString("species_name");

                Species species = new Species();
                species.setSpecies_id(species_id);
                species.setSpecies_name(species_name);
                list.add(species);
            }
            preparedStatement.close();
            DBConnection.CreateConnection().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getSpeciesID(String name){
        String sql = "select * from species where species_name =?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int species_id = resultSet.getInt("species_id");
                String species_name = resultSet.getString("species_name");
                return species_id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getSearchSpeciesName(int category_id){
        String sql = "select species_name from (category inner join species on category.species_id = species.species_id)" +
                "where category.category_id = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(sql);
            preparedStatement.setInt(1, category_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String species_name = resultSet.getString("species_name");
                return species_name;
            }
            DBConnection.CreateConnection().close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        System.out.println(getSpeciesID("chó"));
        System.out.println(getSearchSpeciesName(1));
    }
}
