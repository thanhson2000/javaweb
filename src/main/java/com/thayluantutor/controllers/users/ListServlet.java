package com.thayluantutor.controllers.users;

import com.thayluantutor.DB.UserDAO;
import com.thayluantutor.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "usersList",urlPatterns = "/users_list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        ArrayList<User> users = dao.list();
        req.setAttribute("users",users);
        req.getRequestDispatcher("/WEB-INF/views/users/list.jsp").forward(req,resp);
    }
}
