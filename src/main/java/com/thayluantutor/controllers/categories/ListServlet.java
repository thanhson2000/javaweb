package com.thayluantutor.controllers.categories;

import com.thayluantutor.DB.CategoriesDAO;
import com.thayluantutor.models.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "categoryList", urlPatterns = "/categoriesList")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriesDAO dao = new CategoriesDAO();
        ArrayList<Category> categoriesList = dao.list();
        req.setAttribute("categories",categoriesList);
        req.getRequestDispatcher("/WEB-INF/views/categories/list.jsp").forward(req,resp);
    }
}
