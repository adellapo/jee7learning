<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	// variables
ServletContext ctx;
Connection con;

// obtengo el ServletContext
ctx = request.getServletContext();

// del contexto obtengo el atributo Connection
con = (Connection) ctx.getAttribute("con");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo Conexion</title>
</head>
<body>

	<h3>Demo pasando conexion por Contexto</h3>
	<hr>
	<br>
	<p>Obtiene la conexion que ya fue realizada con un Listener de
		contexto y pasada a este como atributo del mismo.</p>
	<p>Por eso lo primero que hacemos es obtener el context y luego,
		obtener la conexion a partir del atributo de conexion que le habiamos
		pasado</p>

	<ul>
		<%
			if (con != null || !con.isClosed()) {
				String sql = "SELECT * FROM inscripcion;";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
		%>
		<li><%=rs.getInt("id_inscripcion")%>: <%=rs.getString("nombre")%> </li>
		<%
				}	
			} else {
		%>
		<li>Sin inscripciones</li>
		<%
			}
		%>
	</ul>
	
</body>
</html>