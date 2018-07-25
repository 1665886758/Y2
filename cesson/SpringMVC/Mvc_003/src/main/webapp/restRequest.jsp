<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/7/25
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支持非get post请求案例</title>
</head>
<body>
<form action="/rest/delete/3" method="post">
    <input type="hidden" name="aaa"/>
    <input type="submit" value="delete"/>
</form>
</body>
</html>
