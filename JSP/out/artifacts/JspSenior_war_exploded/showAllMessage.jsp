<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.RecordVO" %>
<%@ page import="dao.BookDAO" %>
<%@ page import="dao.Impl.BookDAOImpl" %>
<%@ page import="vo.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table border="1"width="50%">
<%
    BookDAO bookDAO = new BookDAOImpl();
    ArrayList<RecordVO> list = bookDAO.showAllMessage();
    UserVO userVO = (UserVO)session.getAttribute("JudgeLogin");
    if (userVO == null)
    {
        response.sendRedirect("login.html");
    }
%>
    <a href="message.jsp">继续添加留言-></a> <a href="register.html">去注册-></a> <a href="login.html">去登录-》</a>
    <tr>
        <th>name</th>
        <th>title</th>
        <th>content</th>
    </tr>
<%
    for(int x = 0 ; x < list.size() ; x ++) {
%>
<tr>
    <td><% out.println(list.get(x).getName()); %></td>
    <td><% out.println(list.get(x).getTitle()); %></td>
    <td><% out.println(list.get(x).getContent()); %></td>
</tr>
<%
    }
%>
</table>
