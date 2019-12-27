<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <meta charset="UTF-8">
    <title>WriteMessage</title>
</head>
<body>
<form action="messageServlet" method="post">
    <h1>留言本</h1><br>
    <c:if test="${ !empty sessionScope.JudgeLogin}">
        <p>已登录</p>
    </c:if>
    <c:if test="${ empty sessionScope.JudgeLogin}">
        <p>未登录</p>
    </c:if>
    姓名：
    <input name="name" type="text"><br>
    主题：
    <input name="title" type="text"><br>
    留言
    <textarea name="content" id="content" cols="60" rows="5"></textarea><br>
    <input type="submit" name="submit" value="提交留言" >
</form>
<a href="showAllMessage.jsp">查看所有留言</a> <a href="register.html">去注册-></a> <a href="login.html">去登录-></a>
</body>
</html>