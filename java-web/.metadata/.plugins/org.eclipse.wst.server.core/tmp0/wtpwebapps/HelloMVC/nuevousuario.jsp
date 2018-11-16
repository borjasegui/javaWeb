<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Nuevo Usuario</h1>

	<form action="" method="POST">
		<div class="error">${mensajeerror}</div>

		<div>
			<input type="text" placeholder="nombre Usuario" name="nombre"
				id="nombre" value="${newusuario.name}" required />
		</div>
		<div>
			<input type="text" placeholder="email" name="email" id="email"
				value="${newusuario.email}" required />
		</div>
		<div>
			<input type="text" placeholder="password" name="password"
				id="password" value="" required />
		</div>
		<div>
			<input type="text" placeholder="confirmacion password"
				name="confirmacion" id="confirmacionpassword" required />
		</div>

		<div>
			<label for="habitacion">Habitacion</label> <select name="habitacion"
				id="habitacion">
				<c:forEach var="unaHab" items="${lasHabitaciones}">
				<option value="${unaHab.hid}"> ${unaHab.calle} </option>
				
				 </c:forEach>
				
			</select>
		</div>


		<div>
			<button>Enviar</button>
		</div>
	</form>

</body>
</html>