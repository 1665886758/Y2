<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/8/4
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="${ctx}/static/js/jquery.js"></script>
    <title>Title</title>
    <style>
        div{background:mediumspringgreen;width:400px;height: 250px;margin-left: 450px;padding-top: 50px;margin-top: 50px;}
        h2{text-align: center;}
        p{margin-left: 100px;}
        #submitBtn{margin-left: 155px;}
    </style>
<body>
<div>
    <form action="${ctx}/account/login" method="post">
        <h2>个人网上银行</h2>
        <p>卡号：<input type="text" name="cardNo" value="${cardNo}"/><br></p>
        <p>密码：<input type="password" name="password" value="${password}"/><br></p>
        <input type="button" id="submitBtn" value="登录网上银行"/>
    </form>
</div>
</body>
<script>
    $(function () {
        var msg='${msg}';
        if(msg!=null && msg!=''){
            alert('${msg}');
        }
        msg=null;

        $("#submitBtn").click(function (){
            var cardNo=$("input[name=cardNo]").val();
            var password=$("input[name=password]").val();
            if(cardNo.length!=16){
                alert("请正确填写您的16位卡号");
                return false;
            }
            if(password.length!=6){
                alert("请正确填写你的6位密码");
                return false;
            }
            $('form').submit();
        })
    })

    <%--$(function () {--%>
        <%--$("#submitBtn").click(function () {--%>
            <%--var cardNo=$("input[name=cardNo]").val();--%>
            <%--var password=$("input[name=password]").val();--%>

            <%--var obj={--%>
                <%--"cardNo":cardNo,--%>
                <%--"password":password--%>
            <%--};--%>

            <%--$.ajax({--%>
                <%--url:'${ctx}/account/login',--%>
                <%--type:'post',--%>
                <%--contentType:'application/json;charset=UTF-8',--%>
                <%--data:JSON.stringify(obj),--%>
                <%--// contentType:'application/json;charset=URF-8',--%>
                <%--// data:JSON stringify(),--%>
                <%--success:function (data) {--%>

                <%--}--%>
            <%--});--%>
        <%--});--%>
    <%--})--%>
</script>
</html>
