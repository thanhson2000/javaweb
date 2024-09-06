package com.thayluantutor.controllers.users;

import com.thayluantutor.DB.UserDAO;
import com.thayluantutor.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "userUpdate",urlPatterns = "/users_update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id")!=null){
            int id = Integer.parseInt(req.getParameter("id"));
            UserDAO dao = new UserDAO();
            User user = dao.get(id);
            req.setAttribute("user",user);
            req.getRequestDispatcher("/WEB-INF/views/users/update.jsp").forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/users_list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        User user = new User();

        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setFull_name(req.getParameter("full_name"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));

        dao.update(Integer.parseInt(req.getParameter("id")),user);

        resp.sendRedirect(req.getContextPath()+"/users_list");
    }
}
