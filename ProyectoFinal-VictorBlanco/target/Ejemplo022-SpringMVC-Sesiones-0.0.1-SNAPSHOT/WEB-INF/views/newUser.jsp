<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a ClimateWebApp!</title>
</head>
<body>
	<h2>Nuevo Usuario</h2>

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<form:form method="post" modelAttribute="user" action="createUser">

		<table style="width: 50%">
			<tr>
				<td><b>E-mail Usuario</b></td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td><b>Contraseña</b></td>
				<td><form:input path="password" /></td>
			</tr>

			<tr>
				<td><b>Fecha Nacimiento</b></td>
				<td><form:input path="birthDate" /></td>

			</tr>

			<tr>
				<td><b>País</b></td>
				<td><form:select path="country">
						<option value="Spain">Spain</option>
						<option value="France">France</option>
						<option value="UK">UK</option>
						<option value="Germany">Germany</option>
					</form:select></td>
			</tr>
			<tr>
				<td><input type="submit" value="   Crear Usuario   " /></td>
				<td><span style="color: red;">${error}</span></td>
			</tr>
		</table>

	</form:form>

	<form:form method="post" modelAttribute="user" action="index">
		<input type="submit" value="   Volver   " />
	</form:form>
	<br/>
	<br/>
</body>
</html>