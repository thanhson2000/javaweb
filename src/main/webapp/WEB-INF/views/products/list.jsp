<%--
  Created by IntelliJ IDEA.
  User: thanhsonphan
  Date: 24/08/2024
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
</head>
<body>
<h1>Products List</h1>
<div>
    <button >
        <a href="<%=request.getContextPath()%>/products_add">Add Product</a>
    </button>
</div>
<div class="container-sm">
<table class="table" >
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Category</th>
        <th scope="col">Path</th>
        <th scope="col">Thao Tac</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product" >
        <tr>
            <td>
                <c:out value="${product.getId()}"/>
            </td>
            <td>
                <c:out value="${product.getName()}"/>
            </td>
            <td>
                <fmt:formatNumber value="${product.getPrice()}" type="number" maxFractionDigits="2" />
            </td>
            <td>
                <span>
                    [<c:out value="${product.getCategory().getId()}"/>]
                    <c:out value="${product.getCategory().getName()}"/>
                </span>
            </td>
            <td>
                <c:out value="${product.getPath()}"/>
            </td>
            <td>
                <a href="<%=request.getContextPath()%>/products_update?id=<c:out value="${product.getId()}"/> " class="btn btn-primary">Edit</a>
                <a onclick="return confirm('Are you sure remove [ <c:out value="${product.getId()}"/> ] <c:out value="${product.getName()}"/> ?')"
                        href="<%=request.getContextPath()%>/products_delete?id=<c:out value="${product.getId()}"/>" class="btn btn-danger">Delete</a>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
