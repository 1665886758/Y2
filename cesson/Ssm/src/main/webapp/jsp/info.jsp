<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/7/26
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>产品信息表</h2>
<table>
    <thead>
    <tr>
        <th>产品编号</th>
        <th>产品名称</th>
        <th>产品价格</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="obj">
        <tr>
            <td>${obj.id}</td>
            <td>${obj.name}</td>
            <td>${obj.price}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">
            <a href="/product/proInfo/${page.firstPage}/5">首页</a>
            <a href="/product/proInfo/${page.prePage}/5">上一页</a>
            <a href="/product/proInfo/${page.nextPage}/5">下一页</a>
            <a href="/product/proInfo/${page.lastPage}/5">尾页</a>
            第${page.pageNum}页 共${page.pages}页
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
