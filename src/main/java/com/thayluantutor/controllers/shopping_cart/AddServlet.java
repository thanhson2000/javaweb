package com.thayluantutor.controllers.shopping_cart;

import com.thayluantutor.DB.ProductsDAO;
import com.thayluantutor.models.CartItem;
import com.thayluantutor.models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "cartAdd", urlPatterns = "/shopping/add")
public class AddServlet extends HttpServlet {
    public static String CART_NAME = "items";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<CartItem> items = new ArrayList<>();
        int id = Integer.parseInt(req.getParameter("id"));
        if (req.getParameter("id") != null) {
            // session 已存在，给items赋值
            if(req.getSession().getAttribute(CART_NAME)!=null){
                items = (ArrayList<CartItem>) req.getSession().getAttribute(CART_NAME);
            }

            // 检查对应ID的商品是否已在购物车里， 如果有就+1
            for (CartItem item : items) {
                if(item.getProduct().getId() == id){
                    item.setQuantity(item.getQuantity() + 1);
                    req.getSession().setAttribute(CART_NAME,items);
                    resp.sendRedirect(req.getContextPath() + "/shopping/cart");
                    // 执行到这里 return 结束这个方法，不再执行下面的代码了
                    return;
                }
            }

            ProductsDAO dao = new ProductsDAO();
            Product product = dao.get(id);
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            items.add(cartItem);
            req.getSession().setAttribute(CART_NAME,items);
            resp.sendRedirect(req.getContextPath() + "/shopping/cart");
        } else {
            resp.sendRedirect(req.getContextPath() + "/shopping/list");
        }
    }


}
