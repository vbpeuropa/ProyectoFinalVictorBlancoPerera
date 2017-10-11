<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ClimateApp</title>
</head>
<body>
<%-- Importamos la librería form de Spring MVC --%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<%-- Crear formulario enlazado al objeto del modelo
		 formPublicacion mediante el atributo commandName
		 de la etiqueta form --%>
		 
	<form:form method="post" modelAttribute="city"
		action="getCity">
	
		<h1>Introduce la ciudad a Consultar</h1>
		<form:input path="cityName" size="50" maxlength="50" />
		
		<br/><br/>
		
		<input type="submit" value="   Crear Publicación  ">
	
	</form:form>
</body>
</html>