<%--
  Created by IntelliJ IDEA.
  User: Jorsoe
  Date: 2019/10/28
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录系统</title>
  </head>
  <body>
    <form action="LoginServlet" method="post">
        Account: <input name="account" type="text"><br>
        Password:<input name="passward" type="password"><br>
        <input type="submit" value="Login">
    </form>
  </body>
</html>
