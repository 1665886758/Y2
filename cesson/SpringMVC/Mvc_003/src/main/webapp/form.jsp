<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/7/25
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/static/js/jquery.js"></script>
    <title>传统form表单提交数据的问题</title>
</head>
<body>
<form action="/product/add" method="post">
    产品名称: <input type="text" name="name"><br>
    产品价格： <input type="text" name="price"><br>
    生产日期： <input type="text" name="createDate"><br>
    <input type="submit" value="传统提交">
</form>
<br/>
<form action="/product/add2" method="post">
    产品名称: <input type="text" name="name"><br>
    产品价格： <input type="text" name="price"><br>
    生产日期： <input type="text" name="createDate"><br>
    <input type="submit" value="基于springmvcform单个值分开提交">
</form>
<br/>
<form action="/product/add3" method="post">
    产品名称: <input type="text" name="name"><br>
    产品价格： <input type="text" name="price"><br>
    <%--生产日期： <input type="text" name="createDate"><br>--%>
    <input type="submit" value="基于springmvcform以javabean提交">
</form>

<form action="/product/add3" method="post">
    产品名称: <input type="text" name="name"><br>
    产品价格： <input type="text" name="price"><br>
    <%--生产日期： <input type="text" name="createDate"><br>--%>
    <input type="submit" value="基于springmvcform以javabean提交">
</form>
</body>
</html>
