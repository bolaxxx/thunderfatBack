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
			<span class="label label-success">Datos del Alimento</span>
		</h3>

		<form:form action="${urlForm}" method="POST" modelAttribute="paciente">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="nombre">Nombre</label>
						<form:hidden path="id_paciente" />
						<form:input class="form-control" path="nombre" id="nombre"
							required="required" />

						<div class="col-sm-3">
							<div class="form-group">
								<label for="apellidos">Apellidos</label>
								<form:input class="from-control" path="apellidos" id="apellidos"
									required="required" />
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label for="fechanacimiento">Fecha Nacimiento</label>
								<form:input type="text" class="from-control"
									path="fechanacimiento" id="fechanacimiento" required="required" />
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="direccion">Direccion</label>
							<form:input class="from-control" path="direccion" id="direccion"
								required="required" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="localidad">Localidad</label>
							<form:input class="from-control" path="localidad" id="localidad"
								required="required" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="codigopostal">Codigo Postal</label>
							<form:input class="from-control" path="codigopostal"
								id="codigopostal" required="required" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="provincia">Provincia </label>
							<form:input class="from-control" path="provincia" id="provincia"
								required="required" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="dni">DNI </label>
							<form:input class="from-control" path="dni" id="dni"
								required="required" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="altura">Altura</label>
							<form:input class="from-control" path="altura" id="altura"
								required="required" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="telefono">Telefono</label>
							<form:input class="from-control" path="telefono" id="telofono"
								required="required" />
						</div>
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