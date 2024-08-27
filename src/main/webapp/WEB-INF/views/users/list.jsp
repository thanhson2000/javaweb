<%--
  Created by IntelliJ IDEA.
  User: thanhsonphan
  Date: 27/08/2024
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" >

</head>
<body>
<h1>Users List</h1>
<div>
    <button >
        <a href="<%=request.getContextPath()%>/users_add">Add User</a>
    </button>
</div>
<div class="container-sm">
    <table class="table" >
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">FullName</th>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user" >
            <tr>
                <td>
                    <c:out value="${user.getId()}"/>
                </td>
                <td>
                    <c:out value="${user.getFull_name()}"/>
                </td>
                <td>
                    <c:out value="${user.getEmail()}"/>
                </td>
                <td>
                    <c:out value="${user.getPassword()}"/>
                </td>
                <td>
                    <a href="<%=request.getContextPath()%>/users_update?id=<c:out value="${user.getId()}"/> " class="btn btn-primary">Edit</a>
                    <a onclick="return confirm('Are you sure remove [ <c:out value="${user.getId()}"/> ] <c:out value="${user.getFull_name()}"/> ?')"
                       href="<%=request.getContextPath()%>/users_delete?id=<c:out value="${user.getId()}"/>" class="btn btn-danger">Delete</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
