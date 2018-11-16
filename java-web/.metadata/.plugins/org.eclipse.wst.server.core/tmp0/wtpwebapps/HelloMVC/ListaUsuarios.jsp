
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de usuarios</title>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="./cabezera.jsp"></jsp:include>

	<h1>Usuarios</h1>
	<ul>
		<c:forEach var="unUsuario" items="${losUsuarios}">
			<li><a href="./Usuario?id=${unUsuario.id}">
					<div>${unUsuario.id}</div>
					<div>${unUsuario.name}</div>
					<div>${unUsuario.email}</div>
			</a></li>

		</c:forEach>
		
		<li><a href="./listaUsuarios">registarse</a></li>

	</ul>


</body>

</html>