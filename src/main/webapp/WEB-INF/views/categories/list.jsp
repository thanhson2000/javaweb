<%--
  Created by IntelliJ IDEA.
  User: thanhsonphan
  Date: 20/08/2024
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.thayluantutor.models.Category" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>List</title>
    <link rel = "stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Categories List</h1>
    <div class="class-declaration-page">
        <a href="<%=request.getContextPath()%>/categories_add" class="btn btn-primary">Add Category</a>
    </div>
    <table>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
        </tr>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>
                    <c:out value="${category.getId()}"/>
                </td>
                <td>
                    <c:out value="${category.getName()}" />
                </td>
                <td>
                    <a href="<%=request.getContextPath()%>/categories_edit?id=<c:out value="${category.getId()}"/>" class="btn btn-primary">Edit</a>
                    <a onclick="return confirm('Are you sure you want to delete?')"
                            href="<%=request.getContextPath()%>/categories_delete?id=<c:out value="${category.getId()}"/>" class="btn btn-primary">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
