<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Bienvenido a ClimateWebApp!</title>
</head>
<body>
	<div class="container">

		<h2>Registro Usuario</h2>

		<div class="form">
			
				<form:form method="post" modelAttribute="user" action="login">
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
							<th><input type="submit" value="   Login   " /></th>
							<th><span style="color: red;">${error}</span></th>
						</tr>
					</table>



				</form:form>

				<br />
				<form:form method="post" modelAttribute="user" action="newUser">
					<input type="submit" value="   Nuevo Usuario   " />
				</form:form>
			
		</div>
	</div>
</body>
</html>