<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<header>
    <nav>
        <c:url var="crudUrl" value="/user/crud/index"/>

        <a href="${crudUrl}">
            ⚙️ Quản lý User
        </a>

    </nav>
</header>

</body>
</html>