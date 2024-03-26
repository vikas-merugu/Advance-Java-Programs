<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

<html>
<head>

<title>Insert title here</title>
</head>
<body>

<div class="text-center form-group">
<label class="font-italic font-weight-bold"
for="proId">Product Id:</label>

<input type="text" class="text-center form-control-sm" id="proId" name="proId" value="${EditResult.proId}" required>
</div>

<div class="text-center form-group">
<label class="font-italic font-weight-bold"
for="proName">Product Name:</label>

<input type="text" class="text-center form-control-sm" id="proName" name="proName" value="${EditResult.proName}" required>
</div>

<div class="text-center form-group">
<label class="font-italic font-weight-bold"
for="proPrice">Product Price:</label>

<input type="number" class="text-center form-control-sm" id="proPrice" name="proPrice" value="${EditResult.proPrice }" required>
</div>

<div class="text-center form-group">
<label class="font-italic font-weight-bold"
for="proBrand">Product Brand:</label>

<input type="text" class="text-center form-control-sm" id="proBrand" name="proBrand" value="${EditResult.proBrand}" required>
</div>

<div class="text-center form-group">
<label class="font-italic font-weight-bold"
for="proMadein">Product Made In:</label>

<input type="text" class="text-center form-control-sm" id="proMadeIn" name="proMadeIn" value="${EditResult.proMadeIn}" required>
</div>

<div class="text-center form-group">
<label class="font-italic font-weight-bold"
for="proMfg">Product Mfg:</label>

<input type="date" class="text-center form-control-sm" id="proMfg" name="proMfg" value="${EditResult.proMfg}" required>
</div>

<div class="text-center form-group">
<label class="font-italic font-weight-bold"
for="proExp">Product Exp:</label>

<input type="date" class="text-center form-control-sm" id="proExp" name="proExp" value="${EditResult.proExp}" required>
</div>

<div class="text-center form-group">
<label class="font-italic font-weight-bold"

for="proImage">Current Product Image:</label>
<img id="currentImage" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.proImage)}" alt="Current Product Image" style="max-width: 100px; max-height: 100px;">

<input type="hidden" id="existingImage" name="existingImage" value="${existingProduct.proImage}"/>
</div>

<div class="text-center">

<input type="submit" class="btn btn-success" value="save product"/>
<a href="productList.jsp" class="btn btn-primary">List of Products</a>

</div>


</body>
</html>