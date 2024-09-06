package com.thayluantutor.controllers.shopping_cart;

import com.thayluantutor.DB.OrdersDAO;
import com.thayluantutor.models.CartItem;
import com.thayluantutor.models.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "cartCheckout",urlPatterns = "/shopping/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute(AddServlet.CART_NAME)==null){
            resp.sendRedirect(req.getContextPath()+"/shopping/list");
            return;
        }
        ArrayList<CartItem> items = (ArrayList<CartItem>) req.getSession().getAttribute(AddServlet.CART_NAME);

        OrdersDAO dao = new OrdersDAO();
        Order order = new Order();
        order.setTotal(Double.parseDouble(req.getParameter("total")));
        order.setTax(Float.parseFloat(req.getParameter("tax")));
        order.setSub_total(Double.parseDouble(req.getParameter("sub_total")));
        order.setShip_fee(Integer.parseInt(req.getParameter("ship_fee")));
        order.setNote(req.getParameter("note"));


        Order saveOrder = dao.saveOrders(order);
        dao.saveProductOrder(saveOrder,items);

        items.clear();
        resp.sendRedirect(req.getContextPath()+"/shopping/cart");
    }
}
