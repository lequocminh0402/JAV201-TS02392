<%--
  Created by IntelliJ IDEA.
  User: minhl
  Date: 1/8/2026
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>User Crud</title>
    <style>
        form { border: 1px solid blue; padding: 10px; width: 400px; }
        input { margin: 5px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid lightgray; padding: 5px; text-align: left; }
        th { background-color: lightblue; }
    </style>
</head>
<body>
<i>${message}</i>
<c:url var="url" value="/user/crud"/>
<form method="post">
    <label>ID: <input type="text" name="id" value="${user.id}"></label><br>
    <label>Password: <input type="password" name="password" value="${user.password}"></label><br>
    <label>Fullname: <input type="text" name="fullname" value="${user.fullname}"></label><br>
    <label>Email Address: <input type="text" name="email" value="${user.email}"></label><br>
    <label>Role:
        <input type="radio" name="admin" value="true" ${user.admin ? 'checked' : ''}>Admin
        <input type="radio" name="admin" value="false" ${!user.admin ? 'checked' : ''}>User
    </label><br>
    <button formaction="${url}/create">Create</button>
    <button formaction="${url}/update">Update</button>
    <button formaction="${url}/delete">Delete</button>
    <button formaction="${url}/reset">Reset</button>
</form>
<hr>
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Password</th>
            <th>Fullname</th>
            <th>Email</th>
            <th>Role</th>
            <th>Edit</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="u" items="${users}">
    <tr>
        <td>${u.id}</td>
        <td>${u.password}</td>
        <td>${u.fullname}</td>
        <td>${u.email}</td>
        <td>${u.admin ? 'Admin' : 'User'}</td>
        <td><a href="${url}/edit/${u.id}">Edit</a></td>
    </tr>
    </tbody>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
