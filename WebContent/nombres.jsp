<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	ArrayList<String> nombres = (ArrayList<String>) request.getAttribute("nombres");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="posAddNombre" >
		<label>Nombre:</label>
		<input type="text" name="nombre" >
		<input type="submit" value="Add">
	</form>

	<br>

	<ul>
		<%
			int i = 0;
		if (nombres == null) {
		%>
		<li>Lista null</li>
		<%
			} else if (nombres.isEmpty()) {
		%>
		<li>Lista vacia</li>
		<%
			} else {
			for (String nombre : nombres) {
		%>
		<li><%=nombre%>[<a href="posDelNombre?pos=<%= i++ %>">Borrar</a>]</li>
		<%
			}
		}
		%>
	</ul>

</body>

</html>