<%@ page import="java.util.List" %>
<%@ page import="com.foreknow.bean.Guestbook" %><%--
  Created by IntelliJ IDEA.
  User: 95174
  Date: 2020/12/28
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引用jstl标签库--%>
<%--凡是以.tld结尾的都是标签文件 c.tld是核心库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="pager" uri="http://blog.zjjlive.net/zjjlive/tags/pager" %>
<%--   String path = request.getContextPath() 获取工程的application context--%>
<%--   request.setAttribute("path",path) 将获取到的路径保存到request中--%>
<%
    String path = request.getContextPath();
    request.setAttribute("path",path);
%>
<html>
<head>
    <title>Title</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body >

<div class="container">

username:${sessionScope.admin.username}
    <%-- 如果将数据保存到request中，页面中就可以使用requestScope   --%>
    <%-- username:${requestScope.admin.username}--%>
</div>

<%-- table>tr*2>td*6    tab --%>
<table class="table table-hover" >
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>电话号码</td>
        <td>邮箱</td>
        <td>标题</td>
        <td>内容</td>
        <td>创建时间</td>
        <td>操作</td>
    </tr>
<%--  <%--%>
<%--    //可以写java代码--%>
<%--    List<Object> list = (List<Object>)request.getAttribute("list");--%>
<%--    for(int i=0;i<list.size();i++){--%>
<%--        Guestbook gb = (Guestbook) list.get(i);--%>

<%--  %>--%>
<%--${key}--%>
<%--遍历list里面的数据--%>
    <c:forEach var="gb" items="${list}">
    <tr>
        <td>${gb.id}</td>
        <td>${gb.name}</td>
        <td>${gb.phone}</td>
        <td>${gb.email}</td>
        <td>${gb.title}</td>
        <td>${gb.content}</td>
        <td>${gb.time}</td>
        <td>
            <a href="/test2/usermanager?id=${gb.id}&q=delete" class="btn btn-danger">删除</a>
            <a href="/test2/usermanager?id=${gb.id}&q=update" class="btn btn-danger">修改</a>
            <a href="AddMessage.html" class="btn btn-danger" >添加</a>
        </td>
    </tr>
    </c:forEach>
<%--     <%--%>
<%--       }--%>
<%--     %>--%>
</table>

<div>
    <pager:pager pageNo="${requestScope.pageNo}" recordCount="${requestScope.total}" pageSize="${initParam.pageSize}" url="${path}/usermanager?q=list"/>
</div>
</body>
</html>
