package com.thayluantutor.DB;

import com.thayluantutor.models.Category;
import com.thayluantutor.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends DB{
    public UserDAO () {
        connect();
    }
    public ArrayList<User> list(){
        ArrayList<User> userList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM users";
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

                userList.add(user);
            }

            return userList;
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public User get(int id){
        try{
            User user = new User();
            String sql = "SELECT * FROM users WHERE id ="+id;
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            while(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }

            return user;
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public User add(User user){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(full_name,email,password) VALUES (?,?,?)");
            preparedStatement.setString(1,user.getFull_name());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());

            preparedStatement.executeUpdate();

            return get(getLastId());
        }catch ( SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    private int getLastId(){
        try{
            String sql ="SELECT MAX(id) FROM users";
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public User update(int id, User user){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET full_name = ?, email = ? , password = ? WHERE id = ?");
            preparedStatement.setString(1, user.getFull_name());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setInt(4,user.getId());
            preparedStatement.executeUpdate();
            return get(id);
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean remove(int id){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            return true;
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
