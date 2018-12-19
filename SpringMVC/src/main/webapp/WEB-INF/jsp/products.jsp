<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="header.jsp"%>
<%@ page isELIgnored="false"%>

<html>
<body>
	<h1>PRODUCTS</h1>
	<li><a href="./Products.htm?prod=1" name="prod" value=1 />Наушники
		Беспроводные</a></li>
	<li><a href="./Products.htm?prod=2" name="prod" value=2 />Наушники
		Проводные</a></li>
	<li><a href="./Products.htm?prod=3" name="prod" value=3 />Наушники
		проводные-беспроводные</a></li>
	<c:if test="${sessia eq 'admin'}">
		<table>
			<tr>
				<td>
					<form id="loginForm" action="./Products/add.htm" method='get'>

						
						<div class="field">
							<label>Enter product Name:</label>
							<div class="input">
								<input type="text" value="" name="name" />
							</div>
						</div>
						<div class="field">
							<label>Enter product Price:</label>
							<div class="input">
								<input type="text" value="" name="price" />
							</div>
						</div>


						<div class="field">
							<label>Select Category</label> <select name="category">
								<option value="1" selected>Беспроводные</option>
								<option value="2" >Проводные</option>
								<option value="3" >проводные-беспроводные</option>
							</select>
						</div>



						
						<div class="field">
							<label>Description</label> <br>
							<textarea rows="10" cols="38" name="description" id="name" value="">
					
	</textarea>
						</div>



						<div class="submit">
							<button type="submit" name="asd">Enter</button>
						</div>

					</form>
				</td>
				<td></td>
			</tr>
		</table>
	</c:if>


</body>
</html>


<%@include file="footer.jsp"%>
