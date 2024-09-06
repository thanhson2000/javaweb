package com.thayluantutor.controllers.shopping_cart;

import com.thayluantutor.models.CartItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "cartQuantitySubtract",urlPatterns = "/shopping/quantity_subtract")
public class QuantitySubtractServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id")!=null){
            int id = Integer.parseInt(req.getParameter("id"));
            if(req.getSession().getAttribute(AddServlet.CART_NAME)!=null){
                ArrayList<CartItem> items = (ArrayList<CartItem>) req.getSession().getAttribute(AddServlet.CART_NAME);
                for (CartItem item : items) {
                    if(item.getProduct().getId() == id && item.getQuantity() >= 1){
                        item.setQuantity(item.getQuantity() - 1);
                        items.set(items.indexOf(item), item );
                        req.getSession().setAttribute(AddServlet.CART_NAME, items);
                        resp.sendRedirect(req.getContextPath()+"/shopping/cart");
                        return;
                    }
                }
            }
        }
        resp.sendRedirect(req.getContextPath()+"/shopping/cart");
    }
}
