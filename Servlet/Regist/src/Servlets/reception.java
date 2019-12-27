package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "reception")
public class reception extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GBK");
        request.setCharacterEncoding("GBK");
        String name=request.getParameter("account");
        String password=request.getParameter("password");
        String names=request.getParameter("name");
        String[] like=request.getParameterValues("fav");
        String description=request.getParameter("info");
        PrintWriter out=response.getWriter();
        out.println("用户名："+name);
        out.println("名字："+names);
        out.println("密码："+password);
        out.println("自我描述："+description);
        for (String x : like) {
            out.println(x);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
