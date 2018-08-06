<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Listado de Alimentos</title>
	<spring:url value="/resources" var="urlPublic" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>

	<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	
	</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container theme-showcase" role="main">

		<h3>Listado de Alimentos</h3>
      
        <c:if test="${msg !=null }">        
        		<div class='alert alert-success' role='alert'>${msg}</div>
        </c:if> 
      
        <spring:url value="/alimento/edit" var="urlEdit" />
        <spring:url value="/alimento/delete" var="urlDelete" />
        <spring:url value="/alimento/create" var="urlCreate" />
        <a href="${urlCreate}" class="btn btn-success" role="button" title="Nuevo alimento" >Nuevo</a><br><br>        
      
        <div class="table-responsive">	
	        <table class="table table-hover table-striped table-bordered">
				<tr>
					<th>id_alimento</th>
					<th>nombre</th>
					<th>estado</th>
					<th>cal</th>
					<th>hidratos_de_carbono</th>
					<th>h2o</th>
					<th>ne</th>
					<th>grasas</th>
					<th>proteinas</th>
					<th>vitamina_a</th>
					<th>vitamina_b2</th>
					<th>vitamina_b1</th>
					<th>vitamina_c</th>
					<th>niah</th>
					<th>cobre</th>
					<th>potasio</th>
					<th>sodio</th>
					<th>azufre</th>
					<th>calcio</th>
					<th>fosforo</th>
					<th>hierro</th>
					<th>magnesio</th>
					<th>cloro</th>
					<th>met</th>
					<th>lis</th>
					<th>leu</th>
					<th>illeu</th>
					<th>tre</th>
					<th>tri</th>
					<th>fen</th>
					<th>val</th>
				</tr>

				<c:forEach var="alimento" items="${alimentos}">
					<tr>
					




		
						<td>${alimento.id_alimento}</td>
						<td>${alimento.nombre}</td>
						<td>${alimento.estado}</td>
						<td>${alimento.cal}</td>
						<td>${alimento.hidratos_de_carbono}</td>
						<td>${alimento.h2o}</td>
						<td>${alimento.noespecifico}</td>
						<td>${alimento.grasas}</td>
						<td>${alimento.proteinas}</td>
						<td>${alimento.vitamina_a}</td>
						<td>${alimento.vitamina_b2}</td>
						<td>${alimento.vitamina_b1}</td>
						<td>${alimento.vitamina_c}</td>
						<td>${alimento.niah}</td>
						<td>${alimento.cobre}</td>
						<td>${alimento.potasio}</td>
						<td>${alimento.sodio}</td>
						<td>${alimento.azufre}</td>
						<td>${alimento.calcio}</td>
						<td>${alimento.fosforo}</td>
						<td>${alimento.hierro}</td>
						<td>${alimento.magnesio}</td>
						<td>${alimento.cloro}</td>
						<td>${alimento.met}</td>
						<td>${alimento.lis}</td>
						<td>${alimento.leu}</td>
						<td>${alimento.illeu}</td>
						<td>${alimento.tre}</td>
						<td>${alimento.tri}</td>
						<td>${alimento.fen}</td>
						<td>${alimento.val}</td>
						
						
												
						<td>
						   <a href="${urlEdit}/${alimento.id_alimento}" class="btn btn-success btn-sm" role="button" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="${urlDelete}/${alimento.id_alimento}" onclick='return confirm("¿Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
					   </td>
					</tr>
				</c:forEach>
	
			</table>
		</div>

      <hr class="featurette-divider">

      <jsp:include page="../includes/footer.jsp"></jsp:include>		

	</div> <!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>