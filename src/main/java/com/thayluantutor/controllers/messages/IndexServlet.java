package com.thayluantutor.controllers.messages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "messageLanguage",urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lang = req.getParameter("lang");
        if(lang == null){
            lang="vi_VN";
        }

        req.getSession().setAttribute("lang",lang);
        resp.sendRedirect(req.getContextPath()+"/message.jsp");
    }
}
