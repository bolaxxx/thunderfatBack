<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
	integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
	integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
	crossorigin="anonymous"></script>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/paciente/save" var="urlForm" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario paciente</title>

</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos del Paciente</span>
		</h3>

		<form:form action="${urlForm}" method="POST" modelAttribute="paciente">
			<div class="form-row">
				<div class="form-group col-md-6">

					<label for="nombre">Nombre</label>
					<form:hidden path="id_usuario" />
					<form:hidden path="nutricionista.id_usuario"
						value="${nutricionista}" />
					<form:input class="form-control" path="nombre" id="nombre"
						required="required" placeholder="Nombre" />
				</div>
				<div class="form-group col-md-6">

					<label for="apellidos">Apellidos</label>
					<form:input class="form-control" path="apellidos" id="apellidos"
						required="required" placeholder="Apellidos"/>
				</div>
			</div>

			<div class="form-group">
				<label for="direccion">Direccion</label>
				<form:input class="form-control" path="direccion" id="direccion"
					required="required" placeholder="Direccion" />
			</div>

			<div class="form-row">

				<div class="form-group col-md-6">
					<label for="localidad">Localidad</label>
					<form:input class="form-control" path="localidad" id="localidad"
						required="required" placeholder="Localidad"/>
				</div>


				<div class="form-group col-md-4">
					<label for="provincia">Provincia </label>
					<form:input class="form-control" path="provincia" id="provincia"
						required="required" placeholder="Provincia" />
				</div>

				<div class="form-group col-md-2">
					<label for="codigopostal">Codigo Postal</label>
					<form:input class="form-control" path="codigopostal"
						id="codigopostal" required="required" placeholder="Codigo Postal"/>
				</div>
			</div>



			<div class="form-row">

				<div class="form-group col-md-4">
					<label for="fechanacimiento">Fecha Nacimiento</label>
					<form:input type="date" class="form-control" path="fechanacimiento"
						id="fechanacimiento" required="required" />
				</div>
				<div class="form-group col-md-4">
					<label for="dni">DNI </label>
					<form:input class="form-control" path="dni" id="dni"
						required="required" placeholder="DNI" />
				</div>
				<div class="form-group col-md-4">
					<label for="email">Email</label>
					<form:input path="email" id="email" class="form-control"
						required="required" placeholder="Email"/>
				</div>

			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="altura">Altura</label>
					<form:input class="form-control" path="altura" id="altura"
						required="required" type="number" min="0.01"  step="0.01" placeholder="Altura en Metros"/>
				</div>
				<div class="form-group col-md-6">
					<label for="telefono">Telefono</label>
					<form:input class="form-control" path="telefono" id="telofono"
						required="required" placeholder="Telefono de contacto"/>
				</div>
				</div>
				<div class="form-row">
				<div class="form-group col-md-4">
					<label for="sexo">Sexo</label>

					<div class="form-check form-check">
						<form:radiobutton path="sexo" value="hombre" class="form-check-input"/>
						<label class="form-check-label" for="sexo">Hombre</label>
					</div>
					<div class="form-check form-check">
						<form:radiobutton path="sexo" value="mujer" class="form-check-input" />
						<label class="form-check-label" for="sexo">Mujer</label>
						
						<!-- 			<label for="sexo">Sexo</label> -->
						<!-- 			<div class="row"> -->
						<%-- 				<a>Hombre <form:radiobutton path="sexo" value="hombre" /></a><br> --%>
						<%-- 				<a>Mujer<form:radiobutton path="sexo" value="mujer" /></a> --%>
						<!-- 			</div> -->
					</div>
				</div>


	</div>
				<div class="row"></div>
				<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>

		<hr class="featurette-divider">

		<jsp:include page="../includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>



</body>
</html>