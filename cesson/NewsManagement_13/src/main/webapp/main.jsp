<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/8/2
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <script type="text/javascript" src="${ctx}/static/js/jquery.js"></script>
    <title>Title</title>
</head>
<style>
    table{
        font-size: 14px;
    }
</style>
<body>
<p>新闻标题:<input type="text" id="title" /><input type="button" id="submit" value="查询"/></p>
<table>
    <tr style="background:#ccc;">
        <td>新闻编号</td>
        <td>新闻标题</td>
        <td>新闻摘要</td>
        <td>作者</td>
        <td>创建时间</td>
        <td>操作</td>

    </tr>
       <c:forEach items="${list}" var="obj" varStatus="idx">
           <tr <c:if test="${idx.count%2==0}">style="background: greenyellow;" </c:if>>
            <td>${obj.id}</td>
            <td>${obj.title}</td>
            <td>${obj.summary}</td>
            <td>${obj.author}</td>
            <td><fmt:formatDate value="${obj.createdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td><a href="/comment/getInfo/${obj.id}">查看评论</a><a href="${ctx}/comment/getId/${obj.id}" id="add">评论</a><a  href="javascript:;" class="del" id="${obj.id}">删除</a></td>
        </tr>
        </c:forEach>
</table>
</body>
<script>
    $(function () {
        $("#submit").click(function () {
            var title=$("#title").val();
            if(title==''){
                title=null;
            }
            window.location="${ctx}/menu/list/"+title;
        });


        $(".del").click(function () {
              if(confirm("确定删除吗？")){
                  var a=$(this);
                  $.ajax({
                      url:'${ctx}/menu/delById/'+this.id,
                      type:'post',
                      success:function (data) {
                          if(data.flag=="true"){
                            alert("删除成功");
                            a.parent().parent().remove();
                          }else{
                              alert("删除失败");
                          }
                      }
                  });
              }
        });
    });
</script>
</html>
