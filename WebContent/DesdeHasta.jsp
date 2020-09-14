<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%
	String sDesde = request.getParameter("desde");
String sHasta = request.getParameter("hasta");

int desde = Integer.parseInt(sDesde);
int hasta = Integer.parseInt(sHasta);
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Desde - Hasta</title>
</head>

<body>

	<%
		for (int i = desde; i < hasta; i++) {
	%>
	<%=i%><br>
	<%
		}
	%>


</body>

</html>