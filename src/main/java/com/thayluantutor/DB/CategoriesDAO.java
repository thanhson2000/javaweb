package com.thayluantutor.DB;

import com.thayluantutor.models.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriesDAO extends DB{
    public CategoriesDAO() {
        connect();
    }

    // get list of all categories
    public ArrayList<Category> list(){
        ArrayList<Category> categoriesList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM categories";
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            while (resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                categoriesList.add(category);
            }
            return categoriesList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // add category in categories DBa
    public Category add(Category category){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categories(name) VALUES (?)");
            preparedStatement.setString(1,category.getName());
            preparedStatement.executeUpdate();
            return get(getLastId());
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private int getLastId(){
        try{
            String sql ="SELECT MAX(id) FROM categories";
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    // get category by id
    public Category get(int id){
        try{
            String sql = "SELECT * FROM categories WHERE id = "+id;
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            Category category = new Category();
            while(resultSet.next()){
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
            }
            return category;

        }catch ( SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // update category according id
    public Category update(int id, Category category){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categories SET name = ? WHERE id = ?");
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            return get(id);
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    // remove category according id
    public boolean remove(int id){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categories WHERE id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            return true;
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
