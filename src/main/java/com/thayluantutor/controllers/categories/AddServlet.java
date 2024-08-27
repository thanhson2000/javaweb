package com.thayluantutor.controllers.categories;

import com.thayluantutor.DB.CategoriesDAO;
import com.thayluantutor.models.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "add",urlPatterns = "/categories_add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CategoriesDAO dao = new CategoriesDAO();
//        ArrayList<Category> categories = dao.list();
//        req.setAttribute("categories",categories);
        req.getRequestDispatcher("WEB-INF/views/categories/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("name")!= null && req.getParameter("name").trim().length()>0) {
            Category category = new Category();
            category.setName(req.getParameter("name"));

            CategoriesDAO dao = new CategoriesDAO();
            dao.add(category);
            resp.sendRedirect(req.getContextPath() + "/categoriesList");
        }else{
            resp.sendRedirect(req.getContextPath() + "/categoriesList");
        }
    }
}
