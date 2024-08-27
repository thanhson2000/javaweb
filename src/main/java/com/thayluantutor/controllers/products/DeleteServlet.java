package com.thayluantutor.controllers.products;

import com.thayluantutor.DB.ProductsDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deleteProduct", urlPatterns = "/products_delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id")!= null) {
            ProductsDao dao = new ProductsDao();
            dao.remove(Integer.parseInt(req.getParameter("id")));
        }
            resp.sendRedirect(req.getContextPath()+"/product_list");
    }
}
