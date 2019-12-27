package server;

import dao.BookDAO;
import dao.Impl.BookDAOImpl;
import vo.RecordVO;
import vo.UserVO;

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

@WebServlet("/messageServlet")
public class messageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        RecordVO recordVO = new RecordVO(name,title,content);
        BookDAO bookDAO = new BookDAOImpl();
        try {
            int state = bookDAO.addMessage(recordVO);
            if (state == 1)
            {
                response.sendRedirect("addSuccess.html");
            }
            else
            {
                response.encodeRedirectURL("UTF-8");
                RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/message.jsp");
                PrintWriter pw = response.getWriter();
                pw.println("<div style='color:red'>请重新留言！</div>");
                rd.include(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
