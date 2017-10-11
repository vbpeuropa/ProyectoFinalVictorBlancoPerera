<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a ClimateWebApp!</title>
</head>
<body>
	<h2>Registro Usuario</h2>
	
	<%@ taglib uri="http://www.springframework.org/tags/form"
		prefix="form" %>
	
	
	
	<form:form method="post" modelAttribute="user"
		action="login">
	
		<b>E-mail</b>
		<form:input path="email"/>
		
		<br/><br/>
		
		<b>Contraseña</b>
		<form:input path="password"/>
		
		<br/><br/>
		<b>Fecha Nacimiento</b>
		<form:input path="birthDate"/>
		
		<br/><br/>
		<b>País</b>
		<form:select path="country">
 			 <option value="Spain">Spain</option>
 			 <option value="France">France</option>
  			<option value="UK">UK</option>
  			<option value="Germany">Germany</option>
		</form:select>
		<br/><br/>
		
		<input type="submit" value="   Login   " />

	</form:form>
	
		<br/><br/>
	<span style="color: red;">${error}</span>
	
	
	<form:form method="post" modelAttribute="user"
	action="newUser">
		<input type="submit" value="   Nuevo Usuario   " />	
	</form:form>


</body>
</html>