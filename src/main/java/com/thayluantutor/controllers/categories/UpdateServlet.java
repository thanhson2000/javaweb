package com.thayluantutor.controllers.categories;

import com.thayluantutor.DB.CategoriesDAO;
import com.thayluantutor.models.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "update", urlPatterns = "/categories_edit")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = new Category();
        category.setName(req.getParameter("name"));
        category.setId(id);

        CategoriesDAO dao = new CategoriesDAO();
        dao.update(id,category);
        resp.sendRedirect(req.getContextPath()+"/categoriesList");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id")!=null) {
            int id = Integer.parseInt(req.getParameter("id"));
            CategoriesDAO dao = new CategoriesDAO();
            Category categories = dao.get(id);
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/WEB-INF/views/categories/update.jsp").forward(req, resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/categoriesList");
        }
    }
}
