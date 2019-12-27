import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/judge")
public class judge extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String judge = request.getParameter("button");
        if(judge.equals("submit"))
        {
            response.sendRedirect("registerSuccess.html");
        }
        else
        {
            response.sendRedirect("Register.html");
        }
    }
}
