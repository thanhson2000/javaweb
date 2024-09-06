package com.thayluantutor.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Order {
    private int id ;
   // private ArrayList<CartItem> items;
    private double total; // 加税后的总价
    private float tax;  // 税
    private double sub_total ; // 未加税的总价
    private int ship_fee;
    private String note;
}
