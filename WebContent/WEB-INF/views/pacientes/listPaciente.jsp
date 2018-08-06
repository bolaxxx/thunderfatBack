
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
<title>Lista de Pacientes </title>
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
<title>Lista de Paciente</title>
</head>
<body>
<jsp:include page="../includes/menu.jsp"></jsp:include>


<div class="container theme-showcase" role="main">

		<h3>Listado de Pacientes</h3>
      
        <c:if test="${msg !=null }">        
        		<div class='alert alert-success' role='alert'>${msg}</div>
        </c:if> 
      
        <spring:url value="/paciente/edit" var="urlEdit" />
        <spring:url value="/paciente/delete" var="urlDelete" />
        <spring:url value="/paciente/create" var="urlCreate" />
        <a href="${urlCreate}" class="btn btn-success" role="button" title="Nuevo paciente" >Nuevo</a><br><br>        
      
        <div class="table-responsive">	
	        <table class="table table-hover table-striped table-bordered">
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Fecha Nacimiento</th> 
					<th>Direccion</th> 
					<th>Localidad</th> 
					<th>Codigo Postal</th> 
					<th>Provincia</th> 
					<th>DNI</th>
					<th>Altura</th> 
					<th>Telefono</th> 
					
					
					
									
					
		</tr>
		
				<c:forEach var="paciente" items="${paciente}">
					<tr>
					




		
						<td>${paciente.id_paciente}</td>
						<td>${paciente.nombre}</td>
						<td>${paciente.apellidos}</td>
						<td>${paciente.fechanacimiento}</td>
						<td>${paciente.direccion}</td>
						<td>${paciente.localidad}</td>
						<td>${paciente.codigopostal}</td>
						<td>${paciente.provincia}</td>
						<td>${paciente.dni}</td>
						<td>${paciente.altura}</td>
						<td>${paciente.telefono}</td>
						
						<td>
						   <a href="${urlEdit}/${paciente.id_paciente}" class="btn btn-success btn-sm" role="button" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="${urlDelete}/${paciente.id_paciente}" onclick='return confirm("¿Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
					   </td>
					</tr>
				</c:forEach>
	
			</table>
		</div>

</body>
</html>