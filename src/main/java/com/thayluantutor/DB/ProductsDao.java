package com.thayluantutor.DB;

import com.thayluantutor.models.Category;
import com.thayluantutor.models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductsDao extends DB{
    public ProductsDao(){
        connect();
    }

    public ArrayList<Product> list(){
        ArrayList<Product> productsList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM products";
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                product.setCategory(getCategoryById(resultSet.getInt("category_id")));

                productsList.add(product);
            }
            return productsList;
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private Category getCategoryById(int id ){
        CategoriesDAO dao = new CategoriesDAO();
        return dao.get(id);
    }

    public Product getById(int id){
        Product product = new Product();
        try{
            String sql = "SELECT * FROM products WHERE id="+id;
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            while(resultSet.next()){
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                product.setCategory(getCategoryById(resultSet.getInt("category_id")));

            }
            return product;
        }catch ( SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Product add(Product product){
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement
                            ("INSERT INTO products(name,price,category_id) VALUES (?,?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setInt(3,product.getCategory().getId());

            preparedStatement.executeUpdate();

            return getById(getLastId());
        }catch ( SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    private int getLastId(){
        try{
            String sql = "SELECT MAX(id) FROM products";
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            while(resultSet.next()){
                return resultSet.getInt(1);
            }
        }catch ( SQLException e){
            e.printStackTrace();
        }

        return -1;
    }

    public boolean remove(int id){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            return true;
        }catch ( SQLException e){
            e.printStackTrace();
        }

        return false;
    }


    public Product update(int id, Product product){
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE products SET name= ? , price =? , category_id = ? WHERE id = ? ;");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setInt(3,product.getCategory().getId());
            preparedStatement.setInt(4,id);

            preparedStatement.executeUpdate();

            return getById(id);
        }catch ( SQLException e){
            e.printStackTrace();
        }

        return null;
    }

}
