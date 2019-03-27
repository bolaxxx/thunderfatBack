
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
<meta content="${_csrf.token}" name="_csrf" />
<meta content="${_csrf.headerName}" name="_csrf_header" />
<title>Lista de Pacientes</title>
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


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		<spring:url value="/medicion_general/index" var="urlGeneral" />
		<spring:url value="/medicion_especifica/index" var="urlEspecifica" />
		<spring:url value="/medicion_segmental/index" var="urlSegmental" />
		<spring:url value="/antecedente_clinico/index" var="urlClinico" />
		<spring:url value="/antecedente_tratamiento/index"
			var="urlTratamiento" />
		<%-- 			href="${urlCreate}/${nutricionista}" --%>
		<button type="button" class="btn btn-success" role="button"
			title="Nuevo paciente" onclick="nuevoPaciente()">Nuevo</button>
		<br> <br>

	
		<br>
		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<!-- 					<th>ID</th> -->
						<th>Nombre</th>
						<th>Apellidos</th>
						<th>Fecha Nacimiento</th>
						<th>Direccion</th>
						<th>DNI</th>
						<th>Telefono</th>
						<th>Sexo</th>
						<th>Acciones</th>
						<th>Mediciones</th>
						<th>Antecedentes</th>




					</tr>
				</thead>
				<tbody id="myTable">
					<c:forEach var="paciente" items="${pacientes}">
						<tr id="${paciente.id_usuario}">
							<td>${paciente.nombre}</td>
							<td>${paciente.apellidos}</td>
							<td>${paciente.fechanacimiento}</td>
							<td>${paciente.direccion}</td>

							<td>${paciente.dni}</td>

							<td>${paciente.telefono}</td>
							<td>${paciente.sexo}</td>

							<td><a onclick="a1_onclick('${paciente.id_usuario}')"
								class="btn btn-success btn-sm btn-block" role="button"
								title="Detalle"> <span style="font-size: smaller">Detalles</span></a>
							<td><a href="${urlGeneral}/${paciente.id_usuario}"
								class="btn btn-primary btn-sm btn-block" role="button"
								title="Mediciones Generales"><span
									style="font-size: smaller">General</span></a> <a
								href="${urlEspecifica}/${paciente.id_usuario}"
								class="btn btn-info btn-sm btn-block" role="button"
								title="Mediciones Especifica"><span
									style="font-size: smaller">Especifica</span></a> <a
								href="${urlSegmental}/${paciente.id_usuario}"
								class="btn btn-warning btn-sm btn-block" role="button"
								title="Mediciones Segmentales"><span
									style="font-size: smaller">Segmental</span></a></td>
							<td><a href="${urlTratamiento}/${paciente.id_usuario}"
								class="btn btn-primary btn-sm btn-block" role="button"
								title="Antecedentes Tratamiento"><span
									style="font-size: smaller">Tratamiento</span></a> <a
								href="${urlClinico}/${paciente.id_usuario}"
								class="btn btn-info btn-sm btn-block" role="button"
								title="Antecendetes Clinicos"><span
									style="font-size: smaller">Clinico</span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>

	<div class="modal" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Detalle de el paciente</h4>
					<br>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<br />

				</div>
				<div class="modal-body">
					<form id="pacienteFormulario" name="pacienteFormulario">
						<div class="form-row">
							<div class="form-group col-md-6">

								<label for="nombre">Nombre</label> <input hidden
									name="id_usuario" id="id_usuario" /> <input hidden
									name="nutricionista.id_usuario" value="${nutricionista}"
									id="nutricionista.id_usuario" /> <input class="form-control"
									path="nombre" id="nombre" required="required"
									placeholder="Nombre" />
							</div>
							<div class="form-group col-md-6">

								<label for="apellidos">Apellidos</label> <input
									class="form-control" name="apellidos" id="apellidos"
									required="required" placeholder="Apellidos" />
							</div>
						</div>

						<div class="form-group">
							<label for="direccion">Direccion</label> <input
								class="form-control" name="direccion" id="direccion"
								required="required" placeholder="Direccion" />
						</div>

						<div class="form-row">

							<div class="form-group col-md-6">
								<label for="localidad">Localidad</label> <input
									class="form-control" name="localidad" id="localidad"
									required="required" placeholder="Localidad" />
							</div>


							<div class="form-group col-md-4">
								<label for="provincia">Provincia </label> <input
									class="form-control" path="provincia" id="provincia"
									required="required" placeholder="Provincia" />
							</div>

							<div class="form-group col-md-2">
								<label for="codigopostal">Codigo Postal</label> <input
									class="form-control" path="codigopostal" id="codigopostal"
									required="required" placeholder="Codigo Postal" />
							</div>
						</div>



						<div class="form-row">

							<div class="form-group col-md-4">
								<label for="fechanacimiento">Fecha Nacimiento</label> <input
									type="date" class="form-control" path="fechanacimiento"
									id="fechanacimiento" required="required" />
							</div>
							<div class="form-group col-md-4">
								<label for="dni">DNI </label> <input class="form-control"
									path="dni" id="dni" required="required" placeholder="DNI" />
							</div>
							<div class="form-group col-md-4">
								<label for="email">Email</label> <input path="email" id="email"
									class="form-control" required="required" placeholder="Email" />
							</div>

						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label for="altura">Altura</label> <input class="form-control"
									path="altura" id="altura" required="required" type="number"
									min="0.01" step="0.01" placeholder="Altura en Metros" />
							</div>
							<div class="form-group col-md-6">
								<label for="telefono">Telefono</label> <input
									class="form-control" path="telefono" id="telefono"
									required="required" placeholder="Telefono de contacto" />
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label for="sexo">Sexo</label>

								<div class="form-check form-check">
									<input type="radio" path="sexo" value="hombre"
										class="form-check-input" name="sexo" id="sexo_hombre" /> <label
										class="form-check-label" for="sexo">Hombre</label>
								</div>
								<div class="form-check form-check">
									<input type="radio" path="sexo" value="mujer"
										class="form-check-input" id="sexo_mujer" name="sexo">
									<label class="form-check-label" for="sexo">Mujer</label>


								</div>
							</div>


						</div>
					</form>
				</div>
				<div class="modal-footer">

					<div class="btn-group">
					<button type="button" id="botonEditar" class="btn btn-primary" title="Editar paciente" onclick="editarPaciente()">
					Editar</button>
						<button type="button" id="botonGuardar" class="btn btn-success"
							title="Editar paciente" onclick="guardarPaciente()">Guardar</button>
						<button id="botonEliminar" class="btn btn-danger"
							title="Eliminar paciente"onclick="eliminarPaciente()">Eliminar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
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

		 $('.table-bordered').DataTable({
	            "language": {
	                "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json"
	            }
	        } );
		

	});</script>
	<script type="text/javascript">
	
		function a1_onclick(id) {
			console.log(id);
			urle = 'http://localhost:8080/thunderfat/paciente/detalles/' + id
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

		}
		function pintarModal(data) {
			
			document.getElementById("pacienteFormulario").reset();
			$("#pacienteFormulario input").prop("disabled", true);
			$("#pacienteFormulario radio").prop("disabled", true);
			$("#botonEditar").show();
			$("#botonEliminar").show();
			$("#botonGuardar").hide();
			
			
			
			$("#id_usuario").val(data.id_usuario);
			$("#nutricionista.id_usuario").val(data.nutricionista.id_usuario);
			$("#nombre").val(data.nombre);
			$("#apellidos").val(data.apellidos);
			$("#direccion").val(data.direccion);
			$("#localidad").val(data.localidad);
			$("#provincia").val(data.provincia);
			$("#dni").val(data.dni);
			$("#codigopostal").val(data.codigopostal);
			$("#altura").val(data.altura);
			$("#email").val(data.email);
			$("#telefono").val(data.telefono);
			fechanacimiento = fechaParser(data.fechanacimiento.year,
					data.fechanacimiento.monthValue,
					data.fechanacimiento.dayOfMonth);
			console.log(fechanacimiento);
			$("#fechanacimiento").val(fechanacimiento);

			var $radios = $('input:radio[name=sexo]');
			if (data.sexo == "hombre") {
				$radios.filter('[value=hombre]').prop('checked', true);
			} else {
				$radios.filter('[value=mujer]').prop('checked', true);
			}
			//onclick='return confirm("¿Estas seguro?")'
			//$('#myModal').modal('show');
				
			$("#myModal").modal('toggle');
			$('#myModal').modal('show');
			$("#myModal").trigger('focus');
			$('.modal').modal('show');

		}
		function borrarContenidoModel() {
			$('#detalle').empty();
			$("#botonEliminar").removeAttr("href");
			$("#botonEliminar").removeAttr("onClick");
			//$("#botonEditar").removeAttr("href");
			//$("#botonEditar").removeAttr("onClick");
			$("#detalle").remove();

		}
		function fechaParser(year, month, day) {
			MyDateString = year + '-' + ('0' + month).slice(-2) + '-'
					+ ('0' + day).slice(-2);
			return MyDateString;
		}
		 
		function nuevoPaciente() {
			$("#pacienteFormulario  input").removeAttr('disabled');
			$('#pacienteFormulario radio').removeAttr('disabled');
			document.getElementById("pacienteFormulario").reset();
			//$("#pacienteFormulario").reset();
			$("#botonEditar").hide();
			$("#botonEliminar").hide();
			$("#myModal").modal('toggle');
			$('#myModal').modal('show');
			$("#myModal").trigger('focus');
			$('.modal').modal('show');
			$("#botonGuardar").show();
		}
		function guardarPaciente() {
			console.log("llego a la funcion guardarPaciente ");
			var data = {};
			data['id_usuario'] = $("#id_usuario").val();

			data['id_nutricionista'] = ${nutricionista};

			data['nombre'] = $("#nombre").val();
			data['apellidos'] = $("#apellidos").val();
			data['direccion'] = $("#direccion").val();

			data['localidad'] = $("#localidad").val();
			data['provincia'] = $("#provincia").val();
			data['dni'] = $("#dni").val();
			data['fechanacimiento'] = $("#fechanacimiento").val();
			data['codigopostal'] = $("#codigopostal").val();

			data['altura'] = $("#altura").val();
			data['email'] = $("#email").val();
			data['telefono'] = $("#telefono").val();
			if (document.getElementById('sexo_mujer').checked) {
				//Male radio button is checked
				data['sexo'] = "mujer";
			} else if (document.getElementById('sexo_hombre').checked) {
				data['sexo'] = "hombre";
			}
			console.log(data);
			insertarEnBd(data);
		};
		function insertarEnBd(data) {
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			$
					.ajax({
						type : "POST",
						contentType : "application/json",
						url : "/thunderfat/paciente/saveAjax",
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
							if ($('#' + data.id_usuario).length > 0) {
								alert("Has the row!");
								var linea = $('#' + data.id_usuario);
								var celdas = linea.find('td');
								console.log(celdas);
								celdas[0].innerHTML = '' + data.nombre;
								celdas[1].innerHTML = '' + data.apellidos;
								
								celdas[2].innerHTML = '' + data.fechanacimiento;
								celdas[3].innerHTML = '' + data.direccion;
								celdas[4].innerHTML = '' + data.dni;
								celdas[5].innerHTML = '' + data.telefono;
								celdas[6].innerHTML = '' + data.sexo;
							} else {
								
								
								
								 var t= $('.table-bordered').DataTable();
								  
								    t.row.add( [
								    	data.nombre,
								    	data.apellidos,
								    	data.fechanacimiento,
								    	data.direccion,
								    	data.dni,
								    	data.telefono,
								    	data.sexo,
								    	'<button onclick="a1_onclick('+ data.id_usuario+ ')"class="btn btn-success btn-sm btn-block" role="button" title="Detalle"> <span style="font-size: smaller">Detalles</span></button>',
								    	'<a href="/thunderfat/medicion_general/index/'+data.id_usuario+'"class="btn btn-primary btn-sm btn-block" role="button"	title="Mediciones Generales"><span style="font-size: smaller">General</span></a>',
										'<a href="/thunderfat/medicion_especifica/index/'+data.id_usuario+'"	class="btn btn-info btn-sm btn-block" role="button" title="Mediciones Especifica"><span style="font-size: smaller">Especifica</span></a> ',
										'<a href="/thunderfat/medicion_segmental/index/'+data.id_usuario+'" class="btn btn-warning btn-sm btn-block" role="button" title="Mediciones Segmentales"><span style="font-size: smaller">Segmental</span></a>',
										'<a href="/thunderfat/antecedente_tratamiento/index/'+data.id_usuario+'" class="btn btn-primary btn-sm btn-block" role="button" title="Antecedentes Tratamiento"><span style="font-size: smaller">Tratamiento</span></a> ',
										'<a href="/thunderfat/antecedente_clinico/index/'+data.id_usuario+'" class="btn btn-info btn-sm btn-block" role="button"	title="Antecendetes Clinicos"><span	style="font-size: smaller">Clinico</span></a>'
								        ] ).node().id = data.id_usuario;
								    t.draw( false );	
							
								    
								    
			
							}

							console.log(data.dni);
							console.log(jQuery.parseJSON(JSON.stringify(data))
									+ "esto es lo que devuelve");
							console.log(data.id_usuario);
							$('.close').click();
							console.log("paciente guardada");
							$('#myModal').modal('hide');
							//...
						}

					});
		};
		function editarPaciente(){
			$("#pacienteFormulario  input").removeAttr('disabled');
			$('#pacienteFormulario radio').removeAttr('disabled');
			$("#botonEditar").hide();
			$("#botonEliminar").hide();
			$('#botonGuardar').show();  
		};
		function eliminarPaciente(){
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
		
			var id=$("#id_usuario").val();
			console.log(id+"id del paciente a borrar");
			urle = '/thunderfat/paciente/deleteAjax/' + id	+ '/';
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
	</script>
</body>
</html>