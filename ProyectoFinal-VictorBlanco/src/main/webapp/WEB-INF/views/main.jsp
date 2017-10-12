<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ClimateApp</title>
<link rel="stylesheet" href="resources/styles/bootstrap.min.css" />
<link rel="stylesheet" href="resources/styles/bootstrap-theme.min.css" />
<link rel="shortcut icon" type="image/png" href="${img}" />
</head>
<body>
	<h3>Tu Tiempo actual en ${city}</h3>
	<h4>País: ${country}</h4>
	<h4>Temperatura: ${temp}</h4>
	<img src="${img}">


	<%-- Importamos la librería core de JSTL --%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%-- Iterar sobre la lista de publicaciones que viene en el
	atributo publicaciones del modelo asociado a la vista
	objeto Model del parametro del me´todo de negocio del
	controlador --%>
	<br>
	<form:form method="post" modelAttribute="city" action="newcity">
		<input type="submit" value="   Buscar otra Ciudad  " />
	</form:form>


	<h2>Lista de registros anteriores</h2>
	<ul>
		<c:forEach items="${ListadoReg}" var="Register">
			<li>
				<div>
					<c:out value="${Register.country}" />
				</div> 
				<span> <c:out value="${Register.city}" />
			</span>
			<div>
				<c:out value="${Register.temp}" />
				</div> 
				<span><img src="${Register.img}">
			</span>
			</li>
		</c:forEach>
	</ul>
</body>
</html>