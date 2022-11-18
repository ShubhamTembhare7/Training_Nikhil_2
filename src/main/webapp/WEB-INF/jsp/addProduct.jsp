<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.io.*,java.util.*,java.sql.*"%>
<html>
<head>
<title>Bootstrap Example</title>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>ADD NEW PRODUCT</h2>
  <form:form modelAttribute="newproduct" enctype="multipart/form-data">
    <div class="form-group">
      <label for="productId"><spring:message code="spring.form.product.productId"></spring:message></label>
      <form:input type="text" class="form-control"  placeholder="Enter product Id" path="productId"/>
    </div>
    <div class="form-group">
      <label for="category"><spring:message code="spring.form.product.category"/></label>
      <form:input type="text" class="form-control"  placeholder="Enter Product category" path="category"/>
    </div>
     <div class="form-group">
      <label for="description"><spring:message code="spring.form.product.description"/></label>
      <form:input type="text" class="form-control"  placeholder="Enter Product Description" path="description"/>
    </div>
    <div class="form-group">
      <label for="manufacturer"><spring:message code="spring.form.product.manufacturer"/></label>
      <form:input type="text" class="form-control"  placeholder="Enter Product Manufacturer" path="manufacturer"/>
    </div>
    <div class="form-group">
      <label for="name"><spring:message code="spring.form.product.name"/></label>
      <form:input type="text" class="form-control"  placeholder="Enter Product Name" path="name"/>
      <form:errors path="name" cssClass="text-danger"></form:errors>
    </div>
     <div class="form-group">
      <label for="unitPrice"><spring:message code="spring.form.product.unitPrice"/></label>
      <form:input type="text" class="form-control"  placeholder="Enter Product Price" path="unitPrice"/>
    </div>
        <div class="form-group">
      <label for="file"><spring:message code="spring.form.product.productImage"/></label>
      <form:input type="file" class="form-control"  placeholder="Choose product file" path="file"/>
       <form:errors path="file" cssClass="text-danger"></form:errors>
    </div>
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>
<div>

<a href="?langauge=en">English</a>&nbsp; 
<a href="?langauge=hi">Hindi</a>
</div>
</body>
</html>