package com.thayluantutor.DB;

import com.thayluantutor.models.CartItem;
import com.thayluantutor.models.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersDAO extends DB{
    public OrdersDAO(){
        connect();
    }

    public Order get(int id){
        try{
            String sql = "SELECT * FROM orders WHERE id ="+id;
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            Order order = new Order();
            while(resultSet.next()){
                order.setId(resultSet.getInt("id"));
                order.setTotal(resultSet.getDouble("total"));
                order.setTax(resultSet.getFloat("tax"));
                order.setSub_total(resultSet.getDouble("sub_total"));
                order.setShip_fee(resultSet.getInt("ship_fee"));
                order.setNote(resultSet.getString("note"));
            }
            return order;
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private int getLastId(){
        try{
            String sql = "SELECT MAX(id) FROM orders";
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            if (resultSet.next()){
                return resultSet.getInt(1);
            }
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
    public Order saveOrders(Order order){
        try{
            PreparedStatement preStatement = connection.prepareStatement("INSERT INTO orders(total,tax,sub_total,ship_fee,note) VALUES (?,?,?,?,?)");
            preStatement.setDouble(1,order.getTotal());
            preStatement.setFloat(2,order.getTax());
            preStatement.setDouble(3,order.getSub_total());
            preStatement.setInt(4,order.getShip_fee());
            preStatement.setString(5,order.getNote());

            preStatement.executeUpdate();
            return get(getLastId());
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void saveProductOrder(Order order, ArrayList<CartItem> items){

        try{
            PreparedStatement preStatement =
                    connection
                            .prepareStatement("INSERT INTO product_orders(product_id,order_id,name,price,quantity) VALUES (?,?,?,?,?)");

            for (CartItem item : items) {
                preStatement.setInt(1,item.getProduct().getId());
                preStatement.setInt(2,order.getId());
                preStatement.setString(3,item.getProduct().getName());
                preStatement.setFloat(4,item.getProduct().getPrice());
                preStatement.setInt(5,item.getQuantity());

                preStatement.executeUpdate();
            }

        }catch ( SQLException e){
            e.printStackTrace();
        }

    }
}
