<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <c:forEach items="${product}"  var="product">
        <c:out value="${product.productId}"></c:out>
        <c:out value="${product.name}"></c:out>
        <c:out value="${product.category}"></c:out>
        <c:out value="${product.description}"></c:out>
        <c:out value="${product.manufacturer}"></c:out>
        <c:out value="${product.unitPrice}"></c:out>
    </c:forEach>
</body>