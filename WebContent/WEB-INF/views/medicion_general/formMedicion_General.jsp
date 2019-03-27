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
<spring:url value="/medicion_general/save" var="urlForm" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link href="${urlPublic}/css/formMedicionGeneral" rel="stylesheet">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>Formulario Medicion General</title>
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos de la Medicion General</span>
		</h3>

		<form:form action="${urlForm}" method="POST"
			modelAttribute="medicion_general">


			<div class="form-group row ">
				<label for="fecha" class="col-2 col-form-label">Fecha</label>
				<div class="col-10">
					<form:hidden path="id_medicion_general" />
					<form:hidden path="paciente.id_usuario"
						value="${paciente.id_usuario}" />
					<form:input class="form-control" path="fecha" id="fecha"
						required="required" autocomplete="nope" type="date" />
				</div>
			</div>

			<div class="form-group row">
				<label for="brazo" class="col-2 col-form-label">Circunferencia
					Brazo(cm)</label>
				<div class="col-10">
					<form:input class="form-control" path="brazo" id="brazo"
						required="required" type="text" />
				</div>
			</div>

			<div class="form-group row">
				<label for="cadera" class="col-2 col-form-label">Cadera(cm)</label>
				<div class="col-10">
					<form:input class="form-control" path="cadera" id="cadera"
						required="required" type="text" />
				</div>
			</div>

			<div class="form-group row">
				<label for="cintura" class="col-2 col-form-label">Cintura(cm)</label>
				<div class="col-10">
					<form:input class="form-control" path="cintura" id="cintura"
						required="required" type="text" />
				</div>
			</div>
			<div class="form-group row">
				<label for="icc" class="col-2 col-form-label">I.C.C</label>
				<div class="col-10">
					<form:input class="form-control" path="icc" id="icc" type="text" />
				</div>
			</div>

			<div class="form-group row">
				<label for="peso_actual" class="col-2 col-form-label">Peso
					Actual(Kg)</label>
				<div class="col-10">
					<form:input class="form-control" path="peso_actual"
						id="peso_actual" required="required" type="text" />
				</div>
			</div>
			<div class="form-group row">
				<label for="peso_ideal" class="col-2 col-form-label">Peso
					Ideal(Kg)</label>
				<div class="col-10">
					<form:input class="form-control" path="peso_ideal" id="peso_ideal"
						required="required" type="text" />
				</div>
			</div>
			<div class="form-group row">
				<label for="IMC" class="col-2 col-form-label">IMC</label>
				<div class="col-10">
					<form:input class="form-control" path="IMC" id="IMC" type="text" />
				</div>
			</div>
			<div class="form-group row">
				<label for="porcentajegrasas" class="col-2 col-form-label">%Grasas</label>
				<div class="col-10">
					<form:input class="form-control" path="porcentajegrasas"
						id="porcentajegrasas" type="text" />
				</div>
			</div>
			<div class="form-group row">
				<label for="tension_max" class="col-2 col-form-label">Tension
					Maxima</label>
				<div class="col-10">
					<form:input class="form-control" path="tension_max"
						id="tension_max" type="text" />
				</div>
			</div>
			<div class="form-group row">
				<label for="tension_min" class="col-2 col-form-label">Tension
					Minima</label>
				<div class="col-10">
					<form:input class="form-control" path="tension_min"
						id="tension_min" type="text" />
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
		
	
	<script type="text/javascript">
	function redondearDosDecimales (numero){
		return Math.round(numero * 100) / 100;
	}
	
	
		$('#brazo, #cintura').change(function() {
			console.log('llego al script 1');
			var cadera = $('#cadera').val();
			var cintura = $('#cintura').val();
			var icc = cintura / cadera;
			$('#icc').val(redondearDosDecimales(icc));
		});
		
		
		
	</script>
	<script type="text/javascript">
	function redondearDosDecimales (numero){
		return Math.round(numero * 100) / 100;
	}
		$('#peso_actual').change(function() {
			console.log('llego al script 2');
			var peso = $('#peso_actual').val();
			var altura = ${medicion_general.paciente.altura};
			var sexo ="${medicion_general.paciente.sexo}";
			var IMC = peso / Math.pow(altura, 2);
			$('#IMC').val(redondearDosDecimales(IMC));
			var ideal;
			if(sexo='hombre'){
				ideal=23*Math.pow(altura,2)	;
				$('#peso_ideal').val(redondearDosDecimales(ideal));
			}else{
				ideal=22*Math.pow(altura,2);
				$('#peso_ideal').val(redondearDosDecimales(ideal));
			}
				
			
			
		});
	</script>
	
</body>
</html>