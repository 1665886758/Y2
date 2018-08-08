<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/8/4
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${ctx}/static/js/jquery.js" type="text/javascript"></script>
    <title>Title</title>
</head>
<body>
<p>卡号:${lista.cardNo}</p>
<p>余额:${lista.balance}</p>
<a href="${ctx}/moneyOut.jsp">转帐</a>
</body>
<script>
    $(function () {
        var msg='${msg}';
        if(msg!=null && msg!=''){
            alert('${msg}');
            msg=null;
        }
    })
</script>
</html>
