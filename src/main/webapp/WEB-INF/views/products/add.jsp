<%--
  Created by IntelliJ IDEA.
  User: thanhsonphan
  Date: 25/08/2024
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" >
</head>
<body>
<h1>Add Product</h1>
<div class="container-sm">
<form method="POST">
    <div class="mb-3">
        <label for="productName" class="form-label">Name</label>
        <input type="text" class="form-control" id="productName" name="name">
    </div>
    <div class="mb-3">
        <label for="productPrice" class="form-label">Price</label>
        <input type="number" class="form-control" id="productPrice" name="price">
    </div>

    <div class="mb-3">
        <label for="productPath" class="form-label">Path</label>
        <input type="text" class="form-control" id="productPath" name="path">
    </div>

    <select class="form-select" aria-label="Default select example" name="categoryId">
        <option selected>Open this select menu</option>
        <c:forEach var="category" items="${categories}" >
            <option value="${category.getId()}">
                <c:out value="${category.getName()}"/>
            </option>
        </c:forEach>
    </select>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>
