<%@ include file="header.jsp" %>


<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<h2>Hello World!</h2>
<input type='button' value='Buy product#1' onclick="a(1)">
<br>
<input type='button' value='Buy product#2' onclick="a(2)">

<script>
function a(id){
	$.ajax({
	  type: 'POST',
	  url: './CartServlet',
	  data: 'p='+id,
	  success: function(data){
		alert(data);
	  }
	});
}
</script>

	<%@include file="footer.jsp" %>	
