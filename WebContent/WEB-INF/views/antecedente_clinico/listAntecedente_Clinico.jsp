<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="${_csrf.token}" name="_csrf" />
<meta content="${_csrf.headerName}" name="_csrf_header" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Listado de Antecedentes del Paciente {</title>
<spring:url value="/resources" var="urlPublic" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3>Listado de Antecedentes del paciente ${nombre}</h3>

		<c:if test="${msg !=null }">
			<div class='alert alert-success' role='alert'>${msg}</div>
		</c:if>

		<spring:url value="/antecedente_clinico/edit" var="urlEdit" />
		<spring:url value="/antecedente_clinico/delete" var="urlDelete" />
		<spring:url value="/antecedente_clinico/create" var="urlCreate" />
		<a onclick="nuevoAntecedente()" class="btn btn-success" role="button"
			title="Nuevo Antecedente Clinico ">Nuevo</a><br>
		<br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<thead>
				<tr>
					
					<th>Fecha</th>
					<th>Antecedente clinico</th>
					<th>Acciones</th>
				</tr>
				</thead>
				<tbody id="myTable">
				<c:forEach var="antecedente" items="${antecedentes_clinicos}">
					<tr id="${antecedente.id_antecedentes_clinicos}">
						
						<td>${antecedente.fecha}</td>
						<td>${antecedente.antecedente_clinico}</td>
						
						<td><button onclick="a1_onclick('${antecedente.id_antecedentes_clinicos}')"
								class="btn btn-success btn-sm btn-block" role="button"
								title="Detalle"><span style="font-size: smaller">Detalles</span></button></td>

					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>

		
<div class="modal" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="blog-title">
							<span class="label label-success">Datos del Antecedente Clinico </span>
						</h3>
						<br>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<br />

					</div>
					<div class="modal-body">
						<form id="antecedenteClinicoFormulario"
							name="antecedenteClinicoFormulario">
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group">
										<label for="antecedente_tratamiento">Antecedente
											 Clinico </label> <input hidden id="id_antecedente_clinico" />
										<input hidden id="paciente.id_usuario" /> <input
											class="form-control" path="antecedente" id="antecedente"
											required="required" />

									</div>
								</div>
								<div class="col-sm-3">
									<div class="form-group">
										<label for="fecha">Fecha </label> <input type="date"
											class="form-control" path="fecha" id="fecha"
											required="required" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group">
										<label for="observacion ">Observacion </label>
										<textarea class="form-control" path="observacion"
											id="observacion"></textarea>
									</div>
								</div>
							</div>


						</form>
					</div>
					<div class="modal-footer">

						<div class="btn-group">
							<button type ="button" id="botonGuardar"class="btn btn-success btn-sm btn-block" onclick="guardarAntecedente()" title="Guardar">Guardar</button>
							<button type="button" id="botonEditar" class="btn btn-primary"
								title="Editar cita" onclick="habilitarEdicion()">Editar</button>
							<button id="botonEliminar" class="btn btn-danger"
								title="Eliminar cita" onclick="eliminar()">Eliminar</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<!-- 			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
		<script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
		<script src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
		<script src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		console.log("primer script ");
		paciente = ${paciente};
		 $('.table-bordered').DataTable();
		

	});</script>
	<script type="text/javascript">
			function nuevoAntecedente() {

				document.getElementById("antecedenteClinicoFormulario").reset()
					$("#antecedenteClinicoFormulario input").removeAttr('disabled');
				$('#antecedenteClinicoFormulario textarea').removeAttr('disabled');
				$("#botonEditar").hide();
				$("#botonEliminar").hide();
				$('#botonGuardar').show();
				$("#myModal").modal('toggle');
				$('#myModal').modal('show');
				$("#myModal").trigger('focus');
				$('.modal').modal('show');
			};
			
			function eliminar(){
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
			
				var id=$("#id_antecedente_clinico").val();
				urle = '/thunderfat/antecedente_clinico/deleteAjax/' + id	+ '/';
		$.ajax({
			type : "GET",

			url : urle,
			//data : JSON.stringify(data),
			dataType : 'json',
			timeout : 100000,
			beforeSend : function(request) {
				//'Csrf-Token' is the expected header name, not $csrfTokenName
				request.setRequestHeader(header, token);
			},
			success : function(data) {
				console.log("SUCCESS: ", data);
				console.log(data);
				$('#'+id).remove();
				$('#myModal').modal('hide');
			},
			error : function(e) {
				console.log("ERROR: ", e);

			},
			done : function(e) {
				console.log("DONE");
			}
		});
				
			};
			function habilitarEdicion(){
				$('#antecedenteClinicoFormulario input').removeAttr('disabled');
				$('#antecedenteClinicoFormulario textarea').removeAttr('disabled');
				$("#botonEditar").hide();
				$('#botonGuardar').show();
// 				.prop("disabled", true);
// 				.removeAttr('disabled')
			};
			
			function guardarAntecedente() {
				console.log("llego a la funcion guardarAntecedente");
				var data = {};
				data['id_antecedente'] = $("#id_antecedente_clinico").val();

				data['id_paciente'] = ${paciente};

				data['antecedente'] = $("#antecedente").val();
				data['fecha'] = $("#fecha").val();
				data['observacion'] = $("#observacion").val();

				console.log(data);
				insertarEnBd(data);
			};
			function insertarEnBd(data) {
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
				$.ajax({
							type : "POST",
							contentType : "application/json",
							url : "/thunderfat/antecedente_clinico/saveAjax",
							data : JSON.stringify(data),
							dataType : 'json',
							timeout : 6000,
							beforeSend : function(request) {
								//'Csrf-Token' is the expected header name, not $csrfTokenName
								request.setRequestHeader(header, token);
							},
							success : function(data) {
								var table = $('#myTable')[0];
								console.log(table);
								if ($('#' + data.id_antecedente).length > 0) {
									alert("Has the row!");
									var linea = $('#' + data.id_antecedente);
									var celdas = linea.find('td');
									console.log(celdas);
									celdas[0].innerHTML = '' + data.fecha;
									celdas[1].innerHTML = '' + data.antecedente;
									;
									
								} else {
									
									
									 var t= $('.table-bordered').DataTable();
									  
									    t.row.add( [
									    	data.fecha,
									    	data.antecedente,
									    	'<button onclick="a1_onclick('+ data.id_antecedente+ ')"class="btn btn-success btn-sm btn-block" role="button" title="Detalle"> <span style="font-size: smaller">Detalles</span></button>'
									        ] ).node().id = data.id_antecedente;
									    t.draw( false );	
								
								
									console.log("pintada la nueva linea");
								}

								console.log(data.dni);
								console.log(jQuery.parseJSON(JSON
										.stringify(data))
										+ "esto es lo que devuelve");
								console.log(data.id_usuario);
								$('.close').click();
								console.log("paciente guardada");
								$('#myModal').modal('hide');
								//...
							}

						});
			};
			
			function a1_onclick(id) {
				console.log(id);
				urle = '/thunderfat/antecedente_clinico/detalles/' + id
						+ '/';
				$.ajax({
					type : "GET",

					url : urle,
					//data : JSON.stringify(data),
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);
						//display(data);
						pintarModal(data);
					},
					error : function(e) {
						console.log("ERROR: ", e);

					},
					done : function(e) {
						console.log("DONE");
					}
				});

			};
			function fechaParser(year, month, day) {
				MyDateString = year + '-' + ('0' + month).slice(-2) + '-'
						+ ('0' + day).slice(-2);
				return MyDateString;
			};
			function pintarModal(data) {
				if ($("#botonEditar").attr('href') !== undefined) {

					borrarContenidoModel();

				}
				var linkborrado = '/thunderfat/paciente/delete/' + data.id_usuario;
				//var linkeditar = '/thunderfat/paciente/edit/' + data.id_usuario;
				//var mensajeEditar = 'return confirm("�Estas seguro de editar el paciente  '
					//	+ data.nombre + ' ' + data.apellidos + '?")';
				var mensajeEliminar = 'return confirm("�Estas seguro de eliminar el paciente '
						+ data.nombre + ' ' + data.apellidos + '?")';
				
				//$("#botonEditar").attr('href', linkeditar);
				//$("#botonEditar").attr('onClick', mensajeEditar);
				
				// 			$('.modal-body')
				// 					.prepend(
				// 							'<div id="detalle" class="container-fluid"> <dl class="dl-horizontal"><dt>Nombre</dt><dd>'
				// 									+ data.nombre
				// 									+ '</dd><dt>Apellidos</dt><dd>'
				// 									+ data.apellidos
				// 									+ '</dd><dt>Fecha Nacimiento</dt><dd>'
				// 									+ data.fechanacimiento.dayOfMonth
				// 									+ '/'
				// 									+ data.fechanacimiento.monthValue
				// 									+ '/'
				// 									+ data.fechanacimiento.year
				// 									+ '</dd><dt>Direccion</dt><dd>'
				// 									+ data.direccion
				// 									+ '</dd><dt>Codigo Postal</dt><dd>'
				// 									+ data.codigopostal
				// 									+ '</dd><dt>Localidad</dt><dd>'
				// 									+ data.localidad
				// 									+ '</dd><dt>Provincia</dt><dd>'
				// 									+ data.provincia
				// 									+ '</dd><dt>DNI</dt><dd>'
				// 									+ data.dni
				// 									+ '</dd><dt>Telefono</dt><dd>'
				// 									+ data.telefono
				// 									+ '</dd><dt>Altura</dt><dd>'
				// 									+ data.altura
				// 									+ '</dd><dt>Sexo</dt><dd>'
				// 									+ data.sexo
				// 									+ '</dd></dl></div></div>');
				$("#id_antecedente_clinico").val(data.id_antecedentes_clinicos);
				$("#paciente.id_usuario").val(data.paciente.id_usuario);
				$("#antecedente").val(data.antecedente_clinico);
				$("#observacion").val(data.observacion);
				
				fecha = fechaParser(data.fecha.year,
						data.fecha.monthValue,
						data.fecha.dayOfMonth);
				console.log(fecha);
				$("#fecha").val(fecha);

				$("#antecedenteClinicoFormulario input").prop("disabled", true);
				$("#antecedenteClinicoFormulario textarea").prop("disabled", true);
				$("#botonEditar").show();
				$("#botonEliminar").show();
				$("#botonGuardar").hide();
				//onclick='return confirm("�Estas seguro?")'
				//$('#myModal').modal('show');
				$("#myModal").modal('toggle');
				$('#myModal').modal('show');
				$("#myModal").trigger('focus');
				$('.modal').modal('show');

			};
			
			
		
		
		</script>
		<hr class="featurette-divider">

		<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>