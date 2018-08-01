<%--
  Created by IntelliJ IDEA.
  User: bjsxy
  Date: 2018/7/28
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="/static/js/jquery.js"></script>
    <title>Title</title>
</head>
<style>
    #menus{margin-left: 200px;}
    table{width: 950px;height: 120px;}
    #add{margin-left: 100px;background: #ccc;font-size: 13px;padding: 5px;}
</style>
<body>
<c:if test="${categories==null}">
    <c:redirect url="/"></c:redirect>
</c:if>
    <div id="menus">
        <p style="margin-left: 200px;">文档分类:
        <select id="categoryId">
            <option value="0">请选择</option>
            <c:forEach items="${categories}" var="obj">
                                            <%--设置默认选中--%>
                <option value="${obj.id}" <c:if test="${obj.id==categoryId}">selected</c:if> >${obj.name}</option>
            </c:forEach>
        </select>
        <input type="button" id="sub" value="查询" />
            <a id="add" href="/category/selected">新增电子文档</a>
        </p>
        <table border="1" cellspacing="0">
            <tr><td colspan="6"><h1  style="margin-left: 380px">电子文档表</h1></td></tr>
            <c:forEach items="${page.list}" var="page">
                <tr>
                    <td>${page.id}</td>
                    <td>${page.title}</td>
                    <td>${page.summary}</td>
                    <td>${page.uploaduser}</td>
                    <td>${page.createdate}</td>
                    <td><a href="/entry/getFile/${page.id}">修改</a>&nbsp;&nbsp;<a href="javascript:;" class="del" id="${page.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table><c:if test=""></c:if>
        <p style="margin-left: 350px"><a href="/entry/filesInfo/1/<c:choose><c:when test="${categoryId!=null}">${categoryId}</c:when><c:otherwise>0</c:otherwise></c:choose> ">首页</a>
            <a href="/entry/filesInfo/${page.prePage}/<c:choose><c:when test="${categoryId!=null}">${categoryId}</c:when><c:otherwise>0</c:otherwise></c:choose>">上一页</a>
            <a href="/entry/filesInfo/${page.nextPage}/<c:choose><c:when test="${categoryId!=null}">${categoryId}</c:when><c:otherwise>0</c:otherwise></c:choose>">下一页</a>
            <a href="/entry/filesInfo/${page.lastPage}/<c:choose><c:when test="${categoryId!=null}">${categoryId}</c:when><c:otherwise>0</c:otherwise></c:choose>">尾页</a>
            第${page.pageNum}页 共${page.pages}页
        </p>
    </div>
</body>
<script>
    /**
     * 点击删除
     */
    $(".del").click(function () {
        var a=$(this);
        if(confirm("确定删除此文件信息吗？")) {
            $.ajax({
                url: '/entry/delFiles/'+this.id,
                type: 'post',
                // //内容类型，不写是穿不过去的， addHead 方法，setContentType都是可以影响浏览器或者服务器行为的。
                // contentType: 'application/json;charset=UTF-8',
                // data:"id"+this.id,
                success: function (data) {
                    alert(data.msg);
                    a.parent().parent().remove();
                }
            });
        }
    });

    /**
     * categoryId
     */
    $("#sub").click(function () {
        var categoryId=$("#categoryId").val();
        location.href="/entry/filesInfo/1/"+categoryId;
    });
</script>
</html>
