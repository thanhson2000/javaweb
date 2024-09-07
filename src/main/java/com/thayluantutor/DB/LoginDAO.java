package com.thayluantutor.DB;

import com.thayluantutor.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends DB{
    public LoginDAO() {
        connect();
    }

    public User checkEmailPassword(String email, String password){
        try{
            String sql = "SELECT * FROM users WHERE email = '"+email+"' AND password = '"+password+"'";
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            User user = new User();

            if (resultSet.next()){
                System.out.printf("Id = %d ; full_name = %s ; email = %s ; password = %s",resultSet.getInt("id"),resultSet.getString("full_name"),resultSet.getString("email"),resultSet.getString("password"));
                user.setId(resultSet.getInt("id"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user ;
            }
        }catch ( SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
