<%--
  Created by IntelliJ IDEA.
  User: minhl
  Date: 1/16/2026
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <jsp:include page="index.jsp"></jsp:include>
</header>
<main>
<h2>Danh sách video yêu thích</h2>

<table  border="1" cellpadding="8">
    <tr>
        <th>Video Title</th>
        <th>Người thích</th>
        <th>Ngày thích</th>
    </tr>

    <c:forEach var="f" items="${favorite}">
        <tr>
            <td>${f.video.title}</td>
            <td>${f.video.fullname}</td>
            <td>${f.video.likeDate}</td>
        </tr>
    </c:forEach>
</table>
</main>
</body>
</html>
