package com.thayluantutor.models;

import lombok.Data;

@Data
public class CartItem {
    private Product product;
    private int quantity = 1 ;
}
