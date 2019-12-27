package servlet;

import jdbc.Utils;

import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Utils.getConnection();
            stmt = con.prepareStatement("INSERT into guestbook.user(username, password, email) values(?,?,?)");

            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.setString(3,email);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            Utils.close(stmt,con);
        }
    }
}