<%--
  Created by IntelliJ IDEA.
  User: thanhsonphan
  Date: 01/09/2024
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-3">
                <div class="card" style="width: 18rem;">
                    <img src="${product.getPath()}" class="card-img-top" alt="${product.getName()}" style="height: 180px">
                    <div class="card-body">
                        <h5 class="card-title">
                            <c:out value="${product.getName()}"/>
                        </h5>
                        <p class="card-text">
                            Price:<fmt:formatNumber value="${product.getPrice()}" type="number" maxFractionDigits="2"/>VND
                        </p>
                        <a href="<%=request.getContextPath()%>/shopping/add?id=${product.getId()}" class="btn btn-primary">Add To Cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
