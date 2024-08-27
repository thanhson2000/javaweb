<%--
  Created by IntelliJ IDEA.
  User: thanhsonphan
  Date: 24/08/2024
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Add Category</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<h1>Add Category</h1>
<form method="POST">
  <div class="mb-3">
    <label for="inputCategoryName" class="form-label">Category Name</label>
    <input type="text" class="form-control" id="inputCategoryName" name="name">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
