package com.thayluantutor.controllers.categories;

import com.thayluantutor.DB.CategoriesDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "delete", urlPatterns = "/categories_delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id")!=null){
            int id = Integer.parseInt(req.getParameter("id"));
            CategoriesDAO dao = new CategoriesDAO();
            dao.remove(id);
            resp.sendRedirect(req.getContextPath()+"/categoriesList");
        }else{
            resp.sendRedirect(req.getContextPath()+"/categoriesList");
        }
    }
}
