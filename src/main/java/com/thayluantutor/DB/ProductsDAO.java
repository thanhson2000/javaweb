package com.thayluantutor.DB;

import com.thayluantutor.models.Category;
import com.thayluantutor.models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductsDAO extends DB implements IDAO<Product>{
    public ProductsDAO(){
        connect();
    }

    @Override
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
                product.setPath(resultSet.getString("path"));

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

    @Override
    public Product get(int id){
        Product product = new Product();
        try{
            String sql = "SELECT * FROM products WHERE id="+id;
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            while(resultSet.next()){
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));
                product.setCategory(getCategoryById(resultSet.getInt("category_id")));
                product.setPath(resultSet.getString("path"));

            }
            return product;
        }catch ( SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Product add(Product product){
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement
                            ("INSERT INTO products(name,price,category_id,path) VALUES (?,?,?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setInt(3,product.getCategory().getId());
            preparedStatement.setString(4, product.getPath());

            preparedStatement.executeUpdate();

            return get(getLastId());
        }catch ( SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int getLastId(){
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

    @Override
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


    @Override
    public Product update(int id, Product product){
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE products SET name= ? , price =? , category_id = ? , path = ? WHERE id = ? ;");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setInt(3,product.getCategory().getId());
            preparedStatement.setString(4, product.getPath());
            preparedStatement.setInt(5,id);

            preparedStatement.executeUpdate();

            return get(id);
        }catch ( SQLException e){
            e.printStackTrace();
        }

        return null;
    }

}
