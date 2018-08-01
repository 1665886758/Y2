<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/7/27
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/static/js/jquery.js"></script>
<html>
<head>
    <title>登录</title>
</head>
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
           <p>卡号：<input type="text" name="cardNo" value="${account.cardNo}"><br></p>
           <p>密码：<input type="password" name="password" value="${account.password}"><br></p>
           <input type="button" id="submitBtn" value="登录网上银行" >
       </form>
   </div>
</body>
<script>
    $(function() {

        var errMsg = '${errMsg}';

        // console.log(typeof  errMsg);

        if(errMsg !== '' && errMsg !== null){
            alert(errMsg);
            <%--window.location = '${ctx}';--%>
        }
        errMsg = null;


        $('#submitBtn').click(function () {
            var cardNo = $('input[name=cardNo]').val();
            if(cardNo.length != 16){
                alert('请输入16位的卡号');
                return;
            }
            var password = $('input[name=password]').val();
            if(password.length != 6) {
                alert('请输入6位数的密码');
                return;
            }
            $('form').submit();
        })
    });
</script>
</html>
