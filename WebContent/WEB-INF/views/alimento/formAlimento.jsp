
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Creacion de Alimento</title>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/alimento/save" var="urlForm" />
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

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de Alimento</title>
</head>
<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos del Alimento</span>
		</h3>

		<form:form action="${urlForm}" method="POST" modelAttribute="alimento">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="nombre">Nombre</label>
						<form:hidden path="id_alimento" />
						<form:input class="form-control" path="nombre" id="nombre"
							required="required" />
					




					<div class="col-sm-3">
						<div class="form-group">
							<label for="estado">Estado</label>
							<form:input class="from-control" path="estado" id="estado"
								required="required" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="cal">Calorias</label>
							<form:input class="from-control" path="cal" id="cal"
								required="required" />
						</div>
					</div>
</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="hidratos_de_carbono">Hidratos de Carbono</label>
							<form:input class="from-control" path="hidratos_de_carbono"
								id="hidratos_de_carbono" required="required" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="h2o">Agua</label>
							<form:input class="from-control" path="h2o" id="h2o"
								required="required" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="noespecifico">No Especifico</label>
							<form:input class="from-control" path="noespecifico"
								id="noespecifico" required="required" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="grasas">Grasas </label>
							<form:input class="from-control" path="grasas" id="grasas"
								required="required" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="proteinas">Proteinas </label>
							<form:input class="from-control" path="proteinas" id="proteinas"
								required="required" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="vitamina_a">Vitamina A</label>
							<form:input class="from-control" path="vitamina_a"
								id="vitamina_a" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="vitamina_b2">Vitamina B2</label>
							<form:input class="from-control" path="vitamina_b2"
								id="vitamina_b2" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="vitamina_b1">Vitamina B1</label>
							<form:input class="from-control" path="vitamina_b1"
								id="vitamina_b1" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="vitamina_c">Vitamina C</label>
							<form:input class="from-control" path="vitamina_c"
								id="vitamina_c" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="niah">niah</label>
							<form:input class="from-control" path="niah" id="niah" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="cobre">Cobre</label>
							<form:input class="from-control" path="cobre" id="cobre" />
						</div>
					</div>



					<div class="col-sm-3">
						<div class="form-group">
							<label for="potasio">Potasio</label>
							<form:input class="from-control" path="potasio" id="potasio" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="sodio">Sodio</label>
							<form:input class="from-control" path="sodio" id="sodio" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="azufre">Azufre</label>
							<form:input class="from-control" path="azufre" id="azufre" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="calcio">Calcio</label>
							<form:input class="from-control" path="calcio" id="calcio" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="fosforo">Fosforo</label>
							<form:input class="from-control" path="fosforo" id="fosforo" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="hierro">Hierro</label>
							<form:input class="from-control" path="hierro" id="hierro" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="magnesio">Magnesio</label>
							<form:input class="from-control" path="magnesio" id="magnesio" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="cloro">Cloro</label>
							<form:input class="from-control" path="cloro" id="cloro" />
						</div>
					</div>



					<div class="col-sm-3">
						<div class="form-group">
							<label for="met">met</label>
							<form:input class="from-control" path="met" id="met_c" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="lis">lis</label>
							<form:input class="from-control" path="lis" id="lis" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="leu">leu</label>
							<form:input class="from-control" path="leu" id="leu" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="illeu">illeu</label>
							<form:input class="from-control" path="illeu" id="illeu" />
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="tre">tre</label>
							<form:input class="from-control" path="tre" id="tre" />
						</div>
					</div>


					<div class="col-sm-3">
						<div class="form-group">
							<label for="tri">tri</label>
							<form:input class="from-control" path="tri" id="tri" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="fen">fen</label>
							<form:input class="from-control" path="fen" id="fen" />
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label for="val">val</label>
							<form:input class="from-control" path="val" id="val" />
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