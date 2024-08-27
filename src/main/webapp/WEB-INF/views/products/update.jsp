<%--
  Created by IntelliJ IDEA.
  User: thanhsonphan
  Date: 24/08/2024
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Update Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<h1>Update Product</h1>
<div class="container-sm">
    <form method="POST">
        <div class="mb-3">
            <label for="productId" class="form-label">Id</label>
            <input type="number" class="form-control" id="productId" value="${product.getId()}" name="id">
        </div>
        <div class="mb-3">
            <label for="productName" class="form-label">Name</label>
            <input type="text" class="form-control" id="productName" value="${product.getName()}" name="name">
        </div>
        <div class="mb-3">
            <label for="productPrice" class="form-label">Price</label>
            <input type="number" class="form-control" id="productPrice"  name="price">
        </div>
        <div class="mb-3">
            <select name="categoryId">
                <option>---Select---</option>
                <c:forEach items="${categories}" var="category">
                    <option value="${category.getId()}">
                        <c:out value="${category.getName()}"/>
                    </option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
