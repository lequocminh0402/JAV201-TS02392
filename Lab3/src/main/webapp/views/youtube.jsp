<%--
  Created by IntelliJ IDEA.
  User: minhl
  Date: 1/16/2026
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>YouTube</title>
</head>
<body>
<header>
    <jsp:include page="index.jsp"></jsp:include>
</header>
<main>
    <h2>Video yêu thích của ${user.fullname}</h2>

    <table border="1" cellpadding="8">
        <tr>
            <th>Tiêu đề video</th>
            <th>Ngày thích</th>
        </tr>

        <c:forEach var="favorite" items="${user.fullname}">
            <tr>
                <td>${favorite.video.title}</td>
                <td>${favorite.likeDate}</td>
            </tr>
        </c:forEach>
    </table>
</main>
</body>
</html>
