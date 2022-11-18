<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<table border=1>
   <tr>
    <td>ProductId</td>
    <td>Name</td>
    <td>Category</td>
    <td>Description</td>
    <td>Manufacturer</td>
    <td>UnitPrice</td>
    </tr>
    
        <c:forEach items="${product}" var="product">
    <tr>
    <td><c:out value="${product.productId}"></c:out></td>
    <td><c:out value="${product.name}"></c:out></td>
    <td><c:out value="${product.category}"></c:out></td>
    <td><c:out value="${product.description}"></c:out></td>
    <td><c:out value="${product.manufacturer}"></c:out></td>
    <td><c:out value="${product.unitPrice}"></c:out></td>
    </tr>
    </c:forEach>
    </table>



</body>
</html>