package thanhson.javaweb.example.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import thanhson.javaweb.example.cookies.model.User;

import java.io.IOException;

@WebServlet(name = "createSession", value = "/create-session")
public class CreateSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User son = new User();
        son.setEmail("son@gmai.com");
        son.setPassword("123456");
        session.setAttribute("user",son);
        resp.getWriter().println("Create Session Successfully");
    }
}
