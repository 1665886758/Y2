<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/7/24
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/static/js/jquery.js"></script>
    <title>Title</title>
</head>
<body>

   <button id="list">list集合信息</button>
   <button id="arr">数组信息</button>
   <button id="map">Map信息</button>
    <table>

    </table>

</body>
<script>
    $(function () {
        //集合
        $("#list").click(function () {
            $.ajax({
                url:'/user/m2',
                type:'post',
                success:function (data) {
                    var len=data.length;
                    for (var i=0;i<len;i++) {
                        $("table").html("<tr>" +
                            "<td>"+data[i].name+"</td>" +
                            "<td>"+data[i].address+"</td>" +
                            "</tr>");
                        // console.log("姓名:"+data[i].name+"地址:"+data[i].address);
                    }
                }
            });
        });

        //数组
        $("#arr").click(function () {
            $.ajax({
                url:'/user/m3',
                type:'post',
                success:function (data) {
                    var len=data.length;
                    for (var i=0;i<len;i++) {
                        console.log("姓名:"+data[i].name+"地址:"+data[i].address);
                    }
                }
            });
        });

        //map
        $('#map').click(function () {
            $.ajax({
                url:'/user/m5',
                type:'post',
                success:function (data) {

                    // map信息，约定好了键名
                    console.log(data.u1.name+data.u1.address);
                    console.log(data.u2.name+data.u2.address);

                }
            })
        })
    });

</script>
</html>
