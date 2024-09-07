package com.thayluantutor.controllers.users;

import com.thayluantutor.DB.LoginDAO;
import com.thayluantutor.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "userLogin", urlPatterns = "/user/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("email") == null && req.getParameter("password") == null) {
            req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
        }

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        LoginDAO dao = new LoginDAO();
        User user = dao.checkEmailPassword(email, password);

        if (user == null) {
            req.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(req, resp);
        }
        //req.setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/shopping/list");

    }
}
