package server;

import com.sun.net.httpserver.HttpContext;
import dao.BookDAO;
import dao.Impl.BookDAOImpl;
import vo.UserVO;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(true);
        ServletContext application = this.getServletContext();
        BookDAO bookDAO = new BookDAOImpl();
        int count;  // 记录访问
        try {
            int state = bookDAO.login(username,password);
            if (state == 1)
            {
                UserVO userVO = new UserVO();
                userVO.setUsername(username);
                if(session.isNew()){
                    count = 0;
                    application.setAttribute("COUNT",count);
                }

                session.setAttribute("JudgeLogin",userVO);
                response.sendRedirect("showAllMessage.jsp");
            }
            else
            {
                response.setCharacterEncoding("UTF-8");
                RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/Login.html");
                PrintWriter pw = response.getWriter();
                pw.println("<div style='color:red'>Error : Username or Password!</div>");
                rd.include(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
