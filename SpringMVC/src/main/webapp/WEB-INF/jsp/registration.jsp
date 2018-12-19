<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="header.jsp"%>
<%@ page isELIgnored="false"%>

<c:set var="login" value="${param.login}"/>
<c:set var="password" value="${param.password}"/>
<c:set var="password1" value="${param.password1}"/>
<c:set var="name" value="${param.name}"/>
<c:set var="region" value="${param.region}"/>
<c:set var="gender" value="${param.radio}"/>
<c:set var="textarea" value="${param.textarea}"/>
<c:if test="${sessionScope.user ne null}">
<c:set var="login" value="${users.login}"/>
<c:set var="name" value="${users.name}"/>
<c:set var="password" value="${users.password}"/>
<c:set var="password1" value="${users.password}"/>
<c:set var="region" value="${users.region}"/>
<c:set var="gender" value="${users.gender}"/>
<c:set var="textarea" value="${users.comment}"/>
</c:if>

<table>
	<tr>
		<td>
			<form id="loginForm" action="./Registration.htm"  method='get'>

				<div class="field">
					<label>Enter your login:</label>
					<div class="input">
						<input type="text" name="login"  id="login" value="${login}"  />
					</div>
				</div>
				<div class="field">
					<a href="#" id="forgot">Forgot your password?</a> <label>Enter
						your password:</label>
					<div class="input">
						<input type="password" name="password" value="${password}"	id="pass" />
					</div>
				</div>


				<div class="field">
					<label>Enter copy your password:</label>
					<div class="input">
						<input type="password" name="password1"
							value="${password1}"
							id="pass" />
					</div>
				</div>


				<div class="field">
					<label>Enter your Name:</label>
					<div class="input">
						<input type="text"
							value="${name}"
							name="name" />
					</div>
				</div>
<c:choose><c:when test="${region ne null && region eq 'Mordor'}"><c:set var="r1" value="selected"/></c:when><c:when test="${region ne null && region eq 'Izingard'}"><c:set var="r2" value="selected"/></c:when><c:when test="${region == null || region eq 'Moskow'}"><c:set var="r3" value="selected"/></c:when></c:choose>

				<div class="field">
					<label>Select your Region</label> <select name="region">
						<option value="Mordor"
							${r1}>Mordor</option>
						<option value="Izingard"
							${r2}>Izingard</option>
						<option value="Moskow"
							${r3}>Moskow</option>
					</select>
				</div>
				
				

	<c:choose><c:when test="${gender == null || gender eq 'M'}"><c:set var="g1" value="checked"/></c:when><c:when test="${gender ne null && gender eq 'W'}"><c:set var="g2" value="checked"/></c:when></c:choose>
	
				<label>Select your Gender</label>
				<div>
					M<input type="radio" name="radio" value="M" ${g1}/>
					W<input type="radio" name="radio" value="W" ${g2} />
				</div>

				<div class="field">
					<label>Comment</label> <br>
					<textarea rows="10" cols="38" name="textarea" id="name" value="">
					${textarea}
	</textarea>
				</div>



				<div class="submit">
					<button type="submit" name="asd">Enter</button>
					<label id="remember"><input name="checkbox" type="checkbox"
						value=""
						<c:choose><c:when test="${checkbox ne null }"><h3>"checked"</h3></c:when><c:otherwise><h3></h3></c:otherwise></c:choose> />
						Remember me</label>
				</div>

			</form>
		</td>
		<td></td>
	</tr>
</table>
<%@include file="footer.jsp"%>
