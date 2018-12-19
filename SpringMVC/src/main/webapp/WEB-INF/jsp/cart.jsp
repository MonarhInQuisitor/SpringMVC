<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp" %>
<%@ page isELIgnored="false" %> 
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel='stylesheet' href='styles/styles.css' type='text/css' />
</head>


	<h2>Cart</h2>

	<c:forEach var="type" items="${cartcontroller.cart}">
		<h2>${type.key.name}</h2>
		<br>
		<i>${type.key.description}</i>
		<br>

		<img src="images/${type.key.id}.jpg" width='150px' height='150px' />

		<i><h4>Price is ${type.key.price}</h4></i>
		<input type='button' value='-' onclick="minus('${type.key.id}')" />
		<i>
			<h4>
				Count is <span id="${type.key.id}">${type.value}</span>
			</h4>
		</i>
		<input type='button' value='+' onclick="plus('${type.key.id}')" />
		<br>
<form id="" action='./Cart.htm' method='get'>
<div class="submit">
		<button type="submit" name="click" value='${type.key.id}' >DELETE</button>
	</div>
	</form>
		<hr>
	</c:forEach>
		<i><h3>Price is  ${cartcontroller.sum}</h3></i>
	<c:if test="${user ne null}">
	<c:if test="${end ne null}">
	<h1>${end}</h1>
	</c:if>
		<form id="" action='./Cart.htm' method='get'>
<div class="submit">
		<button type="submit" name="buy" value='' >Купить</button>
	</div>
	</form>
	</c:if>
	
	
	<script>
	
		function plus(id) {
			var myDiv = document.getElementById(id);
			myDiv.innerHTML = +myDiv.innerHTML + 1;
			$.ajax({
				type : 'GET',
				url : './Cart.htm',
				data : {
					id : id,
					ch : 1,
				},
				success : function(data) {
					alert("add product");
				}
			});
		}
		function minus(id) {
			var myDiv = document.getElementById(id);
			myDiv.innerHTML = +myDiv.innerHTML - 1;
			$.ajax({
				type : 'GET',
				url : './Cart.htm',
				data : {
					id : id,
					ch : 0,
				},
				success : function(data) {
					alert("delete product");
				}
			});
		}
	</script>
	
	<%@include file="footer.jsp"%>