<%@ page import="vo.BookVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sun.source.tree.NewArrayTree" %><%--
  Created by IntelliJ IDEA.
  User: Jorsoe
  Date: 2019/12/27
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String bookId1 = "001";
    String bookName1 = "Java Web程序设计";
    String editor1 = "郭克华";
    String price1 = "50";
    String publisher1 = "清华大学出版社";
    BookVO bookVO1 = new BookVO(bookId1,bookName1,editor1,price1,publisher1);
    String bookId2 = "002";
    String bookName2 = "Java核心技术";
    String editor2 = "任珂";
    String price2 = "129";
    String publisher2 = "机械工业出版社";
    BookVO bookVO2 = new BookVO(bookId2,bookName2,editor2,price2,publisher2);
    ArrayList<BookVO> bookList = new ArrayList<BookVO>();
    bookList.add(bookVO1);
    bookList.add(bookVO2);
    session.setAttribute("list",bookList);
%>
<jsp:forward page="booklist.jsp"></jsp:forward>
