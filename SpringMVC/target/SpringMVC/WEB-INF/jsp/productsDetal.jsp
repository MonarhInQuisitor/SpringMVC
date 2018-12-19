<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp" %>
<%@ page isELIgnored="false" %> 
					<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
 <h2>${product.name}</h2><br>
   <i>${product.description}</i><br>
   <img src="images/${product.id}.jpg" width='300px' height='300px' /><br>
   <b>${product.price}</b>
<input type='button' value='Buy ${product.name}' onclick="a(${product.id})">

            <script>
            function a(id){
            	$.ajax({
            	  type: 'GET',
            	  url: './Cart.htm',
            	  data: 'p='+id, 
            	  success: function(){
            		alert("куплено");
            	  }
            	});
            }
</script>
	<%@include file="footer.jsp" %>	