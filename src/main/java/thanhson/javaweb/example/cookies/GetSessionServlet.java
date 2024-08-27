package thanhson.javaweb.example.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import thanhson.javaweb.example.cookies.model.User;

import java.io.IOException;

@WebServlet(name = "getSession", value = "/get-session")
public class GetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if( user != null) {
            resp.getWriter().println("Email : " + user.getEmail());
            resp.getWriter().println("Password : " + user.getPassword());
        }else {
            resp.getWriter().println("Not session ever");
        }
    }
}
