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
<spring:url value="/medicion_segmental/save" var="urlForm" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link href="${urlPublic}/css/formMedicionGeneral" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>Formulario Medicion Segmental</title>
</head>
<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos de la Medicion Segmental del Paciente ${paciente.nombre} ${paciente.apellidos}</span>
		</h3>

		<form:form action="${urlForm}" method="POST"
			modelAttribute="medicion_segmental">


			<div class="form-group row ">
				<label for="fecha" class="col-2 col-form-label">Fecha</label>
				<div class="col-10">
					<form:hidden path="id_medicion_segmental" />
					<form:hidden path="paciente.id_usuario"
						value="${paciente.id_usuario}" />
					<form:input class="form-control" path="fecha" id="fecha"
						required="required" autocomplete="nope" type="date"  />
				</div>
			</div>

			<div class="form-group row">
				<label for="bdporcentajegrasas" class="col-2 col-form-label">
					Bd%Grasas</label>
				<div class="col-10">
					<form:input class="form-control" path="bdporcentajegrasas"
						id="bdporcentajegrasas" required="required" type="number" min="0.1" step="0.1"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="bd_musculo" class="col-2 col-form-label">
					Bd musculo</label>
				<div class="col-10">
					<form:input class="form-control" path="bd_musculo"
						id="bd_musculo" required="required" type="number" min="0.1" step="0.1" />
				</div>
			</div>
			<div class="form-group row">
				<label for="bimusculo" class="col-2 col-form-label">
					Bi Musculo</label>
				<div class="col-10">
					<form:input class="form-control" path="bimusculo" id="bimusculo"
						required="required" type="number" min="0.1" step="0.1" />
				</div>
			</div>
			<div class="form-group row">
				<label for="piporcentajegrasas" class="col-2 col-form-label">
					Pi%grasas</label>
				<div class="col-10">
					<form:input class="form-control" path="piporcentajegrasas"
						id="piporcentajegrasas" required="required" type="number" min="0.1" step="0.1"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="pdmusculo" class="col-2 col-form-label">
					Pd Musculo</label>
				<div class="col-10">
					<form:input class="form-control" path="pdmusculo" id="pdmusculo"
						required="required" type="number" min="0.1" step="0.1" />
				</div>
			</div>
			<div class="form-group row">
				<label for="pdporcentajegrasas" class="col-2 col-form-label">
					Pd%Grasas</label>
				<div class="col-10">
					<form:input class="form-control" path="pdporcentajegrasas"
						id="pdporcentajegrasas" required="required" type="number" min="0.1" step="0.1" />
				</div>
			</div>
			<div class="form-group row">
				<label for="tporcentajegrasa" class="col-2 col-form-label">
					T%grasa</label>
				<div class="col-10">
					<form:input class="form-control" path="tporcentajegrasa"
						id="tporcentajegrasa" required="required" type="number" min="0.1" step="0.1" />
				</div>
			</div>
			<div class="form-group row">
				<label for="tmusculo" class="col-2 col-form-label">T Musculo</label>
				<div class="col-10">
					<form:input class="form-control" path="tmusculo" id="tmusculo"
						required="required" type="number" min="0.1" step="0.1"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="pimusculo" class="col-2 col-form-label">Pi Musculo</label>
				<div class="col-10">
					<form:input class="form-control" path="pimusculo" id="pimusculo"
						required="required" type="number" min="0.1" step="0.1"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="biporcentajegrasas" class="col-2 col-form-label">Bi%Grasas</label>
				<div class="col-10">
					<form:input class="form-control" path="biporcentajegrasas"
						id="biporcentajegrasas" required="required" type="number" min="0.1" step="0.1"/>
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