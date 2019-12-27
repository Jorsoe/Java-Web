<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.BookVO" %><%--
  Created by IntelliJ IDEA.
  User: Jorsoe
  Date: 2019/12/26
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ArrayList<BookVO> list = (ArrayList<BookVO>) session.getAttribute("list");
%>
<table border="1"width="50%">
  <tr>
    <th>BookID</th>
    <th>BookName</th>
    <th>Editor</th>
    <th>Price</th>
    <th>Publisher</th>
  </tr>
  <%
    for(int x = 0 ; x < list.size() ; x ++) {
  %>
  <tr>
    <td><% out.println(list.get(x).getBookId()); %></td>
    <td><a href="bookdetails.jsp"><% out.println(list.get(x).getBookName()); %></a></td>
    <td><% out.println(list.get(x).getEditor()); %></td>
    <td><% out.println(list.get(x).getPrice()); %></td>
    <td><% out.println(list.get(x).getPublisher()); %></td>
  </tr>
  <%
    }
  %>
</table>
