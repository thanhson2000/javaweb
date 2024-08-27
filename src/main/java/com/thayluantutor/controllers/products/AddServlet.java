package com.thayluantutor.controllers.products;

import com.thayluantutor.DB.CategoriesDAO;
import com.thayluantutor.DB.ProductsDao;
import com.thayluantutor.models.Category;
import com.thayluantutor.models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "addProduct", urlPatterns = "/products_add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriesDAO dao = new CategoriesDAO();
        ArrayList<Category> categories = dao.list();
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/WEB-INF/views/products/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriesDAO cDao = new CategoriesDAO();
        Product product = new Product();
        product.setName(req.getParameter("name"));
        product.setPrice(Float.parseFloat(req.getParameter("price")));
        product.setCategory(cDao.get(Integer.parseInt(req.getParameter("categoryId"))));

        ProductsDao pDao = new ProductsDao();
        pDao.add(product);

        resp.sendRedirect(req.getContextPath()+"/products_list");
    }
}
