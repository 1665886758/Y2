<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/7/25
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload/m1" method="post" enctype="multipart/form-data">
    文件： <input type="file" name="file"> <br>
    姓名： <input type="text" name="username"> <br>
    <input type="submit" value="上传">
</form>
</body>
</html>
