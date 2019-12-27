import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("gb2312");
        response.setContentType("text/html");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String[] interest = request.getParameterValues("interest");
        String question = request.getParameter("question");
        String content = request.getParameter("content");
        PrintWriter printWriter = response.getWriter();
        printWriter.print("NAME:"+firstName+" "+lastName+"<br>");
        printWriter.print("ADDRESS:"+address+"<br>");
        printWriter.print("E-MAIL:"+email+"<br>");
        printWriter.print("INTEREST:");
        if (interest.length>0)
        {
            for (int i=0;i<interest.length;i++)
            {
                printWriter.print(interest[i]);
                if (i < interest.length-1)
                {
                    printWriter.print("/");
                }
            }
        }
        printWriter.print("<br>");
        printWriter.print("QUESTION:"+question+"<br>");
        printWriter.print("ANSWER:"+content+"<br>");
        printWriter.print("<!DOCTYPE html>");
        printWriter.print("<html lang=\"en\">");
        printWriter.print("<body>");
        printWriter.println("<form action=\"judge\" method=\"post\">");
        printWriter.print("<button  name=\"button\" value=\"submit\">submit</button>");
        printWriter.print("<button  name=\"button\" value=\"restart\">resatart</button>");
        printWriter.println("</body>");
        printWriter.print("</html>");
    }
}
