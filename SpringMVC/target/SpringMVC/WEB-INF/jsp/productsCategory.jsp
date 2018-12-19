<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp" %>
<%@ page isELIgnored="false" %> 
					
<html>
<body>
<h1>${category}</h1>
<c:forEach items="${products}" var="product">
   <h2>${product.name}</h2><br>
   <i>${product.description}</i><br>
  <a href="./Products.htm?id=${product.id}" /><img src="images/${product.id}.jpg" width='100px' height='100px' /></a> <br>
   <b>${product.price}</b>
   <br><hr><br>
</c:forEach>
</body>
</html>

            
	<%@include file="footer.jsp" %>	