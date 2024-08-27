package com.thayluantutor.controllers.users;

import com.thayluantutor.DB.ProductsDao;
import com.thayluantutor.DB.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deleteUser",urlPatterns = "/users_delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id")!= null) {
            UserDAO dao = new UserDAO();
            dao.remove(Integer.parseInt(req.getParameter("id")));
        }
        resp.sendRedirect(req.getContextPath()+"/users_list");
    }
}
