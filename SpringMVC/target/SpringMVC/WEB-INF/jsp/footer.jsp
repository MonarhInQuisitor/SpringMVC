
<%@ page contentType="text/html; charset=UTF-8"%>
</div>

<div id="sidebar">
	<table border=1>
		<tr>
			<td width="252" align="left"><font color=white> <c:choose>
						<c:when test="${ user == null }">
Pls login, Guest!
</c:when>
						<c:otherwise>
Hello, ${user} 
</c:otherwise>
					</c:choose> <br /> В вашей корзине <c:choose>
						<c:when test="${ count == null }">
0
</c:when>
						<c:otherwise>
${count} 
</c:otherwise>
					</c:choose> товаров.
			</font></td>
		</tr>
	</table>
	<h2>Боковое меню</h2>
	<ul>
		<li><a href="./Products.htm?prod=1">Наушники Беспроводные</a></li>
		<li><a href="./Products.htm?prod=2">Наушники Проводные</a></li>
		<li><a href="./Products.htm?prod=3">Наушники
				проводные-беспроводные</a></li>
		<li><a href="./Registration.htm">Регистрация</a></li>
		<li><a href="./Login.htm">Вход</a></li>
		<li><a href="./Cart.htm">Корзина</a></li>
	</ul>
</div>
</div>
</div>
</div>
</div>
<div id="footer">
	<p>Copyright (c) by Цап Дмитро</p>
</div>
<!-- end #footer -->
</body>
</html>