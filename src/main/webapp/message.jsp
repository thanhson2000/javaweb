<%--
  Created by IntelliJ IDEA.
  User: thanhsonphan
  Date: 29/08/2024
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="message"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Message</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/?lang=vi_VN">Vietnamese</a>
<a href="${pageContext.request.contextPath}/?lang=zh_TW">繁體中文</a>
<a href="${pageContext.request.contextPath}/?lang=zh_CN">简体中文</a>

<fmt:message key="hello"/>
<fmt:message key="welcome_to"/>
</body>
</html>
