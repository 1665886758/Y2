<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/8/4
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人网上银行--主界面</title>
    <script src="${ctx}/static/js/jquery.js" type="text/javascript"></script>
</head>
<body>
<div>
    <form action="${ctx}/account/conversion/${lista.cardNo}" method="post">
        转账账号：<input type="text" name="toCardNo"><br>
        转账金额：<input type="text" name="money"><br>
        <input type="button" id="sub" value="转账">
    </form>
</div>
</body>
<script>
    $(function () {
        var msg='${msg}';
        if(msg!=null && msg!=''){
            alert('${msg}');
            msg=null;
        }

        $("#sub").click(function () {
            var toCardNo=$("input[name='toCardNo']").val();
            var money=$("input[name='money']").val();
            if(toCardNo.length!=16){
                alert("请输入16位卡号");
                return false;
            }
            if(money==null || money==''){
                alert("转帐金额不能为空");
                return false;
            }
            $("form").submit();
        });
    })
</script>
</html>
