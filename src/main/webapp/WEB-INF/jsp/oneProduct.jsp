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
                <h1>Products</h1>
            </div>
        </div>
    </section>
    <section class="container">
        <div class="row">
        <div class="col-md-3">
         <div><img src="<c:url value="/img/${product.productId}.jpg"></c:url>" style="width:100%"></div>
        </div>
            
            <div class="col-md-5">
                <h3>${product.name}</h3>
                <p>${product.description}</p>
                <p>
                    <strong>Item Code : </strong>${product.productId}
                </p>
                <p>
                    <strong>manufacturer</strong> : ${product.manufacturer}
                </p>
                <p>
                    <strong>category</strong> : ${product.category}
                </p>







             <h4>${product.unitPrice}USD</h4>
                <p>
                      <a href="<spring:url value="/hello"></spring:url>"
                        class="btn btn-info btn-large">
                    <span
                        class="glyphicon-shopping-cart glyphicon"> </span> Order Now
                    </a>
                </p>
                <p>
                    <a href="<spring:url value="/hello"></spring:url>"
                        class="btn btn-info btn-large"> <span
                        class="glyphicon glyphicon-repeat glyphicon"> </span> Back to
                        Products
                    </a>
                </p>
            </div>
        </div>
    </section>
</body>
</html>