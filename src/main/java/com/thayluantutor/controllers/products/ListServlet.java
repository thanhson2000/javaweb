package com.thayluantutor.controllers.products;

import com.thayluantutor.DB.ProductsDAO;
import com.thayluantutor.models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "productList",urlPatterns = "/products_list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductsDAO dao = new ProductsDAO();
        ArrayList<Product> products = dao.list();
        req.setAttribute("products",products);
        req.getRequestDispatcher("WEB-INF/views/products/list.jsp").forward(req,resp);
    }
}
