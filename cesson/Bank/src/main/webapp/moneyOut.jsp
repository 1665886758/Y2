<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ include file="common/header.jsp" %>--%>
<html>
<head>
    <title>个人网上银行--主界面</title>
    <script src="${ctx}/static/js/jquery.js" type="text/javascript"></script>
</head>
<body>
    <div>
        <form action="${ctx}/account/transfer/${account.cardNo}">
            转账账号：<input type="text" name="toCardNo"><br>
            转账金额：<input type="text" name="money"><br>
            <input type="submit" value="转账">
        </form>
    </div>
</body>
<script>
    $(function() {
        var msg = '${msg}';

        if(msg !== '' && msg !== null){
            alert(msg);
        }
        msg = null;
    });
</script>
</html>
