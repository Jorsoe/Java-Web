import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException
    {
        String name = request.getParameter("account");
        String passward = request.getParameter("passward");
        String tempString;

        if(name.equals("renke")&&passward.equals("111111"))
        {
            tempString = "<div style='color:green'>success</div>";
        }
        else
        {
            tempString = "<div style='color:red'>fail</div>";
        }
        PrintWriter out = response.getWriter();
        out.print(tempString);
    }
}


