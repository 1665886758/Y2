<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/7/25
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/static/js/jquery.js"></script>
    <title>JSON 数据传递到后台的问题</title>
</head>
<body>
<button id="bt1">ajax下提交json数据</button>
<button id="bt2">ajax下提交一组json数据</button>
</body>
<script>
    $("#bt1").click(function () {
        var obj={"name":"泡面","price":5};
        $.ajax({
            url:'/product/add4',
            type:'post',
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify(obj),
            success:function (data) {
                alert(data.msg);
            }
        });
    });

    $("#bt2").click(function () {
        var obj={"name":"泡面","price":5};
        var obj2={"name":"旺旺碎冰冰","price":15};
        var arr = [obj,obj2];
        $.ajax({
            url:'/product/add5',
            type:'post',
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify(arr),
            success:function (data) {
                alert(data.msg);
            }
        });
    });
</script>
</html>
