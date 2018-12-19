<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="header.jsp" %>         
<%@ page isELIgnored="false" %> 
<c:set var="user" value="${user}" />
<c:choose>
<c:when test="${user ne null}">
<form id="loginForm" action='./Login.htm' method='get'>
<div class="submit">
		<button type="submit" name="click" >LOGOUT</button>
	</div>
	</form>
</c:when>
<c:otherwise>
<form id="loginForm"  action='./Login.htm' method='get'>

	<div class="field">
		<label>Enter your login:</label>
		<div class="input"><input type="text" name="login" value="" id="login" /></div>
	</div>

	<div class="field">
		<a href="#" id="forgot">Forgot your password?</a>
		<label>Enter your password:</label>
		<div class="input"><input type="password" name="password" value="" id="pass" /></div>
	</div>

	<div class="submit">
		<button type="submit" name="asd" >Enter</button>
		<label id="remember"><input name="" type="checkbox" value="" /> Remember me</label>
	</div>

</form>
</c:otherwise>
</c:choose>	   
<%@include file="footer.jsp" %>		 