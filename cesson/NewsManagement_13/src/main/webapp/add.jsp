<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/8/2
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="${ctx}/static/js/jquery.js"></script>
    <title>Title</title>
</head>
<body>
    <%--获取新闻Id--%>
<input type="hidden" id="id" value="${id}"/>
    <p><h1>评论列表</h1></p>
    <p>评论信息<input type="text" id="content"/></p>
    <p>评论人<input type="text" id="author"/></p>
<p><input type="button" id="sub" value="提交"/><input type="button" id="back" value="返回"/></p>
</body>
<script>
    $(function (){
       $("#sub").click(function () {
           var id=$("#id").val();
           var content=$("#content").val();
           var author=$("#author").val();
           var detail={
               "id":id
           }
           var obj={
                "detail":detail,
                "content":content,
                "author":author
           };
            if(content!=null && content!=''){
           $.ajax({
               url:'/comment/insert',
               type:'post',
               contentType:'application/json;charset=UTF-8',
               data:JSON.stringify(obj),
               success:function (data) {
                   if(data.flag=="true"){
                       alert("评论成功！");
                       window.location="/menu/list/null";
                   }else{
                       alert("评论失败");
                   }
               }
           });
            }else{
                alert("评论不能为空");
            }
       });
    });

    $("#back").click(function () {
        window.location="${ctx}/menu/list/null";
    });
</script>
</html>
