package com.thayluantutor.controllers.shopping_cart;

import com.thayluantutor.models.CartItem;
import com.thayluantutor.models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "cart", urlPatterns = "/shopping/cart")
public class CartServlet extends HttpServlet {
    private static float VAT_TAX = 0.1F;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<CartItem> items = new ArrayList<>();
        if (req.getSession().getAttribute(AddServlet.CART_NAME) != null) {
            // 通过session获取购物车cart里的所有货品
            items = (ArrayList<CartItem>) req.getSession().getAttribute(AddServlet.CART_NAME);
        }
        // 计算总价subtotal、加税后总价total
        double sub_total = 0;
        for (CartItem item : items) {
            sub_total += (item.getProduct().getPrice() * item.getQuantity());
        }

        double vat =sub_total * VAT_TAX;
        double total = sub_total + vat;

        req.getSession().setAttribute("total", total);
        req.getSession().setAttribute("sub_total", sub_total);
        req.getSession().setAttribute("tax",VAT_TAX);
        req.getSession().setAttribute(AddServlet.CART_NAME, items);
        req.getRequestDispatcher("/WEB-INF/views/shopping_cart/cart.jsp").forward(req, resp);
    }
}
