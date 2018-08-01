<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/7/27
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="/static/js/jquery.js"></script>
    <title>主菜单</title>
</head>
<style>
    #menus{width:110px;height: 200px;float: left;}
    #menus p{margin-left: 15px;line-height: 20px;}
    #menus a{font-size: 14px;}
    #display{width: 500px;height: 250px;float: left;border: 3px solid blue;}
</style>
<body>
<c:if test="${account==null}">
    <c:redirect url="index.jsp"></c:redirect>
</c:if>
<div style="margin-left: 380px">
    <p style=" margin-left: 15px;">卡号:&nbsp;${account.cardNo}&nbsp;&nbsp;&nbsp;<a href="#">退出登录</a></p>
    <input type="hidden" id="bid" value="${account.id}">
    <div id="menus">
        <p><a id="balance" href="javascript:;">查询余额</a></p>
        <p><a href="${ctx}/moneyOut.jsp" id="change">转账</a></p>
        <p><a href="/transactionRecord/bankListInfo" id="query">查询交易记录</a></p>
        <p><a href="#">修改密码</a></p>
    </div>
    <div id="display">
        <h1 style="padding-left:100px;padding-top: 70px">欢迎使用个人网上银行</h1>
        <%--&lt;%&ndash;转账DIV&ndash;%&gt;--%>
        <%--<div style="display:none" id="Trun">--%>
            <%--<h4 style="margin-left: 40px">当前操作：转账。请输入转入账号和金额后点"转账"按钮</h4>--%>
                <%--<p style="margin-left: 90px"> 转入账号:<input type="text" name="TrunCardNo"/></p>--%>
                <%--<p style="margin-left: 90px">转账金额:<input type="text" name="TrunBalance"/></p>--%>
                <%--<p style="margin-left: 200px"><input type="submit" value="转账"/></p>--%>
        <%--</div>--%>
        <%--<div>--%>
            <table>
                <c:forEach items="${list}" var="list">
                    <tr><td>${list.id}</td><td>${list.cardNo}</td><td>${list.transactionDate}</td><td>${list.transactionAmount}</td><td>${list.balance}</td><td>${list.transactionType}</td><td>${remark}</td></tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
<script>
    // 余额
    $("#balance").click(function () {
        var bid=$("#bid").val();
        var obj={"id":bid};
        $.ajax({
            url:'/account/balance',
            type:'post',
            //内容类型，不写是穿不过去的， addHead 方法，setContentType都是可以影响浏览器或者服务器行为的。
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify(obj),
            success:function (data) {

                $("#display").html("" +
                    "<h2 style='margin-left:50px;'>你的账户余额是:</h2><br/>" +
                    "<span style='margin-left:80px;'>人民币:</span>" +
                    "<span style='margin-left:150px;'></span>");
            }
        });
    });


</script>
</html>
