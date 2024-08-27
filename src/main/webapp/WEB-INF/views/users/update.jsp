<%--
  Created by IntelliJ IDEA.
  User: thanhsonphan
  Date: 27/08/2024
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Update User</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body>
<h1>Update User</h1>
<div class="container-sm">
    <form method="POST">
        <div class="mb-3">
            <label for="userId" class="form-label">Id</label>
            <input type="number" class="form-control" id="userId" value="${user.getId()}" name="id">
        </div>
        <div class="mb-3">
            <label for="userFullName" class="form-label">Name</label>
            <input type="text" class="form-control" id="userFullName" value="${user.getFull_name()}" name="full_name">
        </div>
        <div class="mb-3">
            <label for="userEmail" class="form-label">Email</label>
            <input type="email" class="form-control" id="userEmail"  name="email" value="${user.getEmail()}">
        </div>
        <div class="mb-3">
            <label for="userPassword" class="form-label">Password</label>
            <input type="password" class="form-control" id="userPassword"  name="password" >
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
