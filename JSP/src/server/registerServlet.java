package server;

import dao.BookDAO;
import dao.Impl.BookDAOImpl;
import vo.UserVO;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        UserVO userVO = new UserVO(username,password,email);
        BookDAO bookDAO = new BookDAOImpl();
        try {
            int state = bookDAO.register(userVO);
            if (state == 1)
            {
                response.sendRedirect("login.html");
            }
            else
            {
                response.sendRedirect("register.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
