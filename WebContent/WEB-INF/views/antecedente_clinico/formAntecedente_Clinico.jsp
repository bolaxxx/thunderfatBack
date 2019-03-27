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
<spring:url value="/antecedente_clinico/save" var="urlForm" />
<title>Ficha Antecedente Clinico del usuario
	${antecedente.paciente.nombre} ${antecedente.paciente.apellidos}</title>

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos del Antecedente Clinico</span>
		</h3>

		<form:form action="${urlForm}" method="POST"
			modelAttribute="antecedentes_clinicos">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="antecedente_clinico">Antecedente Clinico </label>
						<form:hidden path="id_antecedentes_clinicos" />
						<form:hidden path="paciente.id_usuario"
							value="${antecedentes_clinicos.paciente.id_usuario}" />
						<form:input class="form-control" path="antecedente_clinico"
							id="antecedente_clinico" required="required" />

					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="fecha">Fecha </label>
						<form:input type="date" class="form-control" path="fecha"
							id="fecha" required="required" />
					</div>
				</div>
				</div>
				<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="observacion ">Observacion </label>
						<form:textarea class="form-control" path="observacion"
							id="observacion" />
					</div>
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