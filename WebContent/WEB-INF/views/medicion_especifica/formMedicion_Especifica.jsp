<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/medicion_especifica/save" var="urlForm" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Formulario Medicion Especifica</title>
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos de la Medicion
				Especifica</span>
		</h3>

		<form:form action="${urlForm}" method="POST"
			modelAttribute="medicion_especifica">


			<div class="form-group row ">
				<label for="fecha" class="col-2 col-form-label">Fecha</label>
				<div class="col-10">
					<form:hidden path="id_medicionespecifica" />
					<form:hidden path="paciente.id_usuario"
						value="${paciente.id_usuario}" />
					<form:input class="form-control" path="fecha" id="fecha"
						required="required" autocomplete="false" type="date" />
				</div>
			</div>
			<div class="form-group row">
				<label for="peso" class="col-2 col-form-label">Peso</label>
				<div class="col-10">
					<form:input class="form-control" path="peso" id="peso"
						required="required" type="text" />
				</div>
			</div>
			<div class="form-group row">
				<label for="porcentajegrasa" class="col-2 col-form-label">%Grasas</label>
				<div class="col-10">
					<form:input class="form-control" path="porcentajegrasa"
						id="porcentajegrasa" required="required" type="text" />
				</div>
			</div>

			<div class="form-group row">
				<label for="metabolismo" class="col-2 col-form-label">Metabolismo</label>
				<div class="col-10">
					<form:input class="form-control" path="metabolismo"
						id="metabolismo" required="required" type="text" />
				</div>
			</div>
			<div class="form-group row">
				<label for="edad_met" class="col-2 col-form-label">Edad
					Metabolica</label>
				<div class="col-10">
					<form:input class="form-control" path="edad_met" id="edad_met"
						required="required" type="text" />
				</div>
			</div>
			<div class="form-group row">
				<label for="musculo" class="col-2 col-form-label">Musculo</label>
				<div class="col-10">
					<form:input class="form-control" path="musculo" id="musculo"
						required="required" type="text" />
				</div>
			</div>



			<div class="form-group row">
				<label for="grasas" class="col-2 col-form-label">Grasa</label>
				<div class="col-10">
					<form:input class="form-control" path="grasas" id="grasas"
						required="required" type="text" />
				</div>
			</div>

			<div class="form-group row">
				<label for="grasavisceral" class="col-2 col-form-label">Grasa
					Visceral</label>
				<div class="col-10">
					<form:input class="form-control" path="grasavisceral"
						id="grasavisceral" required="required" type="text" />
				</div>
			</div>
			<div class="form-group row">
				<label for="masa_osea" class="col-2 col-form-label">Masa
					Osea</label>
				<div class="col-10">
					<form:input class="form-control" path="masa_osea" id="masa_osea"
						required="required" type="text" />
				</div>
			</div>
			<div class="form-group row">
				<label for="porcentajeagua" class="col-2 col-form-label">%Agua</label>
				<div class="col-10">
					<form:input class="form-control" path="porcentajeagua"
						id="porcentajeagua" required="required" type="text" />
				</div>
			</div>
			<div class="row"></div>
			<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>


		<hr class="featurette-divider">

		<jsp:include page="../includes/footer.jsp"></jsp:include>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>



</body>
</html>