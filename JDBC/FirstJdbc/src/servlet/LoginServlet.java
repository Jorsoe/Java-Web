package servlet;

import jdbc.Utils;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = Utils.getConnection();
            stmt = con.prepareStatement("SELECT * FROM user WHERE username = ?");
            stmt.setString(1,username);

            rs = stmt.executeQuery();
            rs.next();

            String passwaordTemp = rs.getString(3);
            if(passwaordTemp.equals(password))
            {
                response.sendRedirect("success.html");
            } else {
                    response.setCharacterEncoding("GBK");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
                    PrintWriter pw = response.getWriter();
                    pw.println("<p>Error:username & password!</p>");
                    rd.include(request,response);
                   }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            Utils.close(rs,stmt,con);
        }
    }
}