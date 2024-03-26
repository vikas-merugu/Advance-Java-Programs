<%@ page import="com.sathya.servlets.ProductDao" 
import="java.util.Base64"%>
<%@ page language="java" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>



<title>Product List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>

<body>
<h1 class="text-center text-danger">List Of Products</h1>

<div class="btn btn-success"><a href="add-product.html">save product</a>

</div>


<div>
<input type="search" value="search"/>
</div>

<div>
<c:if test="${saveResult==1 }">
<h1 class="text-success text-center">Data Inserted Successfully</h1>
</c:if>
</div>
<div >
<c:if test="${deleteResult==1}">
<h1 class="text-danger text-center">Data Deleted Successfully</h1>
</c:if>
</div>
<div >
<c:if test="${deleteResult==0}">
<h1 class="text-danger text-center">Data Deletion Fail</h1>
</c:if>
</div>



<table class="table table-bordered table-striped">
<thead class="thead-dark">
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Brand</th>
<th>Made In</th>
<th>Manufacture Date</th>
<th>Expire Date</th>
<th>Image</th>
<th>Action</th>
</tr>
</thead>

<tbody>

<c:forEach var="product" items="<%=ProductDao.findAll()%>">
<tr>
<td>${product.proId}</td>
<td>${product.proName}</td>
<td>${product.proPrice}</td>
<td>${product.proBrand}</td>
<td>${product.proMadeIn}</td>
<td>${product.proMfg }</td>
<td>${product.proExp }</td>
<td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="product Image" style="max-width: 100px; max-height: 100px;">
<td><a class="btn btn-primary" href="./DeleteProductServlet?proId=${product.proId}">Delete</a>

</td>
<td><a class="btn btn-primary" href="./EditProductServlet?proId=${product.proId}">Edit</a>

</td>
</tr>
</c:forEach>
</tbody>




</table>
</body>
</html>