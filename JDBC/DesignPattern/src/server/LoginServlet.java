package server;

import dao.BookDAO;
import dao.Impl.BookDAOImpl;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        BookDAO bookDAO = new BookDAOImpl();
        try {
            boolean judge = bookDAO.login(username,password);
            if(judge){
                response.sendRedirect("success.html");
            }
            else{
                response.setCharacterEncoding("GBK");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Login.html");
                PrintWriter printWriter = response.getWriter();
                printWriter.println("please enter again!");
                requestDispatcher.include(request,response);
                printWriter.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
