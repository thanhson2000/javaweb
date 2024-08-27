package thanhson.javaweb.example.demoproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet(name="login", value="/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafullstack", "root", "27112222");
            String sql = "SELECT COUNT(id) FROM users WHERE email = '"+email+"' AND password = '"+password+"'";
            ResultSet resultSet = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
            if(resultSet.next()){
                int count = resultSet.getInt(1);
                if(count>0) {
                    resp.getWriter().write("Login successfull");
                }else{
                    resp.getWriter().write("Login failed");
                }
            }else {
                resp.getWriter().write("Login failed");
            }
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

}
