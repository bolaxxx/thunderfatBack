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
<spring:url value="/cita/save" var="urlForm" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css">
<title>Formulario Cita</title>
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos de la Nueva Cita</span>
		</h3>

		<form:form action="${urlForm}" method="POST" modelAttribute="cita">
			<div class="form-group row ">
				<label for="fecha_ini" class="col-2 col-form-label">Fecha y
					Hora de Inicio</label>
				<div class="col-10">

					<form:input class="form-control" path="fecha_ini" id="fecha_ini"
						required="required" autocomplete="false" type="datetime-local" />
				
					<form:hidden path="id_cita" />

					<form:hidden path="nutricionista.id_usuario"
						value="${nutricionista.id_usuario}" />
				</div>
			</div>







			<div class="form-group row ">
				<label for="fecha_fin" class="col-2 col-form-label">Fecha y
					Hora Fin </label>
				<div class="col-10">
					<form:input class="form-control" path="fecha_fin" id="fecha_fin"
						required="required" autocomplete="false" type="datetime-local" />
				</div>
			</div>
			<div class="form-group row">
				<label for="paciente" class="col-2 col-form label">Paciente</label>
				<div class="col-10">

					<form:select path="paciente.id_usuario"
						class="custom-select custom-select-lg mb-3">
						<option value="">Paciente</option>
						<c:forEach var="paciente" items="${pacientes}">
							<form:option value="${paciente.id_usuario}">
								<c:out
									value="${paciente.nombre} ${paciente.apellidos} ${paciente.dni}" />
							</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="row"></div>
			<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>

		<hr class="featurette-divider">

		<jsp:include page="../includes/footer.jsp"></jsp:include>

	</div>






		


</body>
</html>