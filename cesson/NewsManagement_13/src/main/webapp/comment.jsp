
<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/8/2
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellspacing="0" style="font-size: 14px;width: 700px;margin-left: 300px;text-align: center;">
    <tr><td colspan="4"><h1>评论列表</h1></td></tr>
        <tr style="background: deepskyblue">
            <td>评论编号</td>
            <td>评论内容</td>
            <td>评论人</td>
            <td>评论时间</td>
        </tr>
        <c:forEach items="${list}" var="obj">
            <tr>
            <td>${obj.id}</td>
            <td>${obj.content}</td>
            <td>${obj.author}</td>
            <td><fmt:formatDate value="${obj.createdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
        </c:forEach>
</table>
</body>

</html>
