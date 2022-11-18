<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
            <form action="/category/${cat}" class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" name=cat type="search" placeholder="Search By Category" aria-label="Search">
      <button class="btn  my-2 my-sm-0 btn-warning" type="submit">Search</button>
    </form>
    </nav>
                <h1>Products</h1>
                <p>All the available products in our store</p>
               <p>
                                     <a href='<spring:url value="/add"></spring:url>' class="btn btn-success">Add New Product <span class="glyphicon-eye-open glyphicon"> </span></a>
                                </p>   
            </div>
        </div>
    </section>
    <section class="container">
        <div class="row">
        <c:if test="${product.size()==0}">
        <h1>No Products found</h1>
        </c:if>
            <div class="col-md-10">
                <c:forEach items="${product}" var="product">
                   <div class="col-sm-6 col-md-3">
                        <div class="thumbnail">
                            <div class="caption">
  <div><img src="<c:url value="/img/${product.productId}.jpg"></c:url>" style="width:100%"></div>
                               <h3>${product.name}</h3>
                                <p>${product.description}</p>
                                <p>$${product.unitPrice}</p>
                                <p>
                                     <a href='<spring:url value="/getId?id=${product.productId}"></spring:url>' class="btn btn-warning"> Details <span class="glyphicon-eye-open glyphicon"> </span></a>
                                </p>
                                <p>
                                     <a href='<spring:url value="/Delete?id=${product.productId}"></spring:url>' class="btn btn-warning"> Delete<span class="glyphicon-eye-open glyphicon"> </span></a>
                                </p>
                                  <p>
                                     <a href='<spring:url value="/Update?id=${product.productId}"></spring:url>' class="btn btn-warning"> Update<span class="glyphicon-eye-open glyphicon"> </span></a>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</body>
</html>