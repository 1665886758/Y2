<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/29
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<script type="text/javascript" src="/static/js/add.js"></script>--%>
<html>
<head>
    <script type="text/javascript" src="/static/js/jquery.js"></script>
    <title>新增</title>
</head>
<body>
<c:if test="${categories==null}">
    <c:redirect url="/"></c:redirect>
</c:if>
<table border="1" cellspacing="0" style="margin-left: 470px">
        <tr>
            <td style="text-align: center" colspan="2">
                <h1 style="text-align: center;padding-top: 7px">增加电子文档</h1>
            </td>
        </tr>
        <tr>
            <td>文档编号</td>
            <td>
            <select name="categoryId" id="categoryId">
                <option value="-1" selected>请选择</option>
                <c:forEach items="${categories}" var="obj">
                    <c:if test="${entry.categoryId==obj.id}" ><option value="${obj.id}" selected>${obj.name}</option></c:if>
                    <option value="${obj.id}">${obj.name}</option>
                </c:forEach>

            </select>
            </td>
        </tr>
        <tr>
            <td>文档名称(*)</td>
            <td><input type="text" name="title" id="title" <c:if test="${entry!=null}">value="${entry.title}"</c:if> /></td>
        </tr>
        <tr>
            <td>文档摘要</td>
            <td><textarea name="summary" id="summary"><c:if test="${entry!=null}">${entry.summary}</c:if></textarea></td>
        </tr>
        <tr>
            <td>上传人</td>
            <td><input type="text" name="uploaduser" id="uploaduser" <c:if test="${entry!=null}">value="${entry.uploaduser}"</c:if>/></td>
        </tr>
        <tr>
            <td>上传时间(*)</td>
            <td><input type="text" name="createdate" id="createdate" <c:if test="${entry!=null}">value="${entry.createdate}"</c:if>/>(yyyy-MM-dd)</td>
        </tr>
        <tr style="text-align: center">
            <td colspan="2">
                <c:if test="${entry==null}">
                    <input id="submit" type="button" value="提交"/>
                </c:if>
                <c:if test="${entry!=null}">
                    <input id="id" type="hidden" value="${entry.id}"/>
                    <input id="submitUpdate" type="button" value="提交"/>
                </c:if>
                &nbsp;<input type="button" value="返回" onclick="javascript:history.go(-1);"/>
            </td>
        </tr>
</table>
<script type="text/javascript">
    $(function () {
        $("#submit").click(function () {
            var categoryId=$("#categoryId").val();
            var title=$("#title").val();
            var summary=$("#summary").val();
            var uploaduser=$("#uploaduser").val();
            var createdate=$("#createdate").val();

            var obj ={
                "categoryId":categoryId,
                "title":title,
                "summary":summary,
                "uploaduser":uploaduser,
                "createdate":createdate
                // "createdate":createdate
                }
            $.ajax({
                url:'/entry/insertFiles',
                type:'post',
                //内容类型，不写是穿不过去的， addHead 方法，setContentType都是可以影响浏览器或者服务器行为的。
                contentType: 'application/json;charset=UTF-8',
                data:JSON.stringify(obj),
                success:function(data) {
                    if(data.flag=="true"){
                        location.href="/"; //新增成功跳转页面
                    }else{
                        alert("新增失败！");
                    }
                }
            });
        });

        $("#submitUpdate").click(function () {
            var categoryId=$("#categoryId").val();
            var title=$("#title").val();
            var summary=$("#summary").val();
            var uploaduser=$("#uploaduser").val();
            var createdate=$("#createdate").val();
            var id=$("#id").val();
            var obj ={
                "categoryId":categoryId,
                "title":title,
                "summary":summary,
                "uploaduser":uploaduser,
                "createdate":createdate,
                "id":id
            }
            alert(JSON.stringify(obj));
            $.ajax({
                url:'/entry/updateFiles',
                type:'post',
                //内容类型，不写是穿不过去的， addHead 方法，setContentType都是可以影响浏览器或者服务器行为的。
                contentType: 'application/json;charset=UTF-8',
                data:JSON.stringify(obj),
                success:function(data) {
                    if(data.flag=="true"){
                        alert("修改成功！");
                        location.href="/"; //新增成功跳转页面
                    }else{
                        alert("修改失败！");
                    }
                }
            });
        });
    })
</script>
</body>
</html>
