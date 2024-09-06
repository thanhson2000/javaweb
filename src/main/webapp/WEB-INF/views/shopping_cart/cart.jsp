<%--
  Created by IntelliJ IDEA.
  User: thanhsonphan
  Date: 01/09/2024
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN"/>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>购物车</h1>
    <a href="<c:url value="/shopping/list"/>" class="btn btn-secondary">Forward to List</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.getProduct().getName()}</td>
                <td><fmt:formatNumber value="${item.getProduct().getPrice()}" type="currency"
                                      maxFractionDigits="2"/></td>
                <td>${item.getQuantity()}</td>
                <td>
                    <fmt:formatNumber value="${item.getProduct().getPrice() * item.getQuantity()}" type="currency"
                                      maxFractionDigits="2"/>
                </td>
                <td>
                    <a class="btn btn-danger" href="<c:url value="/shopping/remove?id=${item.getProduct().getId()}"/>"
                       role="button" onclick="return confirm('Are you sure to delete ${item.getProduct().getName()}')">Delete</a>
                    <a class="btn btn-outline-success"
                       href="<c:url value="/shopping/quantity_plus?id=${item.getProduct().getId()}"/>" role="button">Plus</a>
                    <a class="btn btn-outline-warning"
                       href="<c:url value="/shopping/quantity_subtract?id=${item.getProduct().getId()}"/>"
                       role="button">Subtract</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <h5>
        Sub_total = <fmt:formatNumber value="${sub_total}" maxFractionDigits="2" type="currency"/>
    </h5>
    <h5>
        Tax = <fmt:formatNumber value="${tax * 100}"/> %
    </h5>
    <h5>
        Total = <fmt:formatNumber value="${total}" maxFractionDigits="2" type="currency" />
    </h5>

    <div>
        <form method="POST" action="<c:url value="/shopping/checkout"/>">
            <input type="number" name="sub_total" value="${sub_total}" hidden="hidden" />
            <input type="number" name="tax" value="${tax}" hidden="hidden" />
            <input type="number" name="total"  value="${total}"  hidden="hidden" />

            <div class="input-group mb-3">
                <span class="input-group-text">Ship_fee</span>
                <input type="number" class="form-control" name="ship_fee">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Note area</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="note"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Checkout</button>
        </form>
    </div>
</div>
</body>
</html>
