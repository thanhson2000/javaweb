package com.thayluantutor.controllers.shopping_cart;

import com.thayluantutor.DB.ProductsDAO;
import com.thayluantutor.models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "cartList", urlPatterns = "/shopping/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductsDAO dao = new ProductsDAO();
        ArrayList<Product> products = dao.list();
        req.setAttribute("products",products);

        req.getRequestDispatcher("/WEB-INF/views/shopping_cart/list.jsp").forward(req,resp);
    }
}
