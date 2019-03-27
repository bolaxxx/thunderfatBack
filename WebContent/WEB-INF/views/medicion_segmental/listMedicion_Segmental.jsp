    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources" var="urlPublic" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="${_csrf.token}" name="_csrf" />
<meta content="${_csrf.headerName}" name="_csrf_header" />
<title>Lista de Medicion Segmentales</title>
</head>
<body>
<jsp:include page="../includes/menu.jsp"></jsp:include>


<div class="container theme-showcase" role="main">

		<h3> Mediciones Segmentales  del Paciente ${paciente.nombre} ${paciente.apellidos}</h3>
      
        <c:if test="${msg !=null }">        
        		<div class='alert alert-success' role='alert'>${msg}</div>
        </c:if> 
      
        <spring:url value="/medicion_segmental/edit" var="urlEdit" />
        <spring:url value="/medicion_segmental/delete" var="urlDelete" />
        <spring:url value="/medicion_segmental/create" var="urlCreate" />
        <button onclick="nuevaMedicion()" class="btn btn-success" role="button" title="Nuevo paciente" >Nuevo</button><br><br>        
      
        <div class="table-responsive" id="tablaPrincipal">	
	        <table class="table table-hover table-striped table-bordered">
				<thead>
				<tr>
					
					<th>Fecha</th>
					<th>BD Musculo</th>
					<th>BD % Grasas</th> 
					<th>BI Musculo</th> 
					<th>BI % Grasas</th> 
					<th>PD Musculo</th> 
					<th>PD %Grasas</th> 
					<th>PI Musculo</th>
					<th>PI %Grasas</th> 
					<th>T Musculo</th> 
					<th>T % Grasas</th>
					<th>Detalle</th>
					
									
					
		</tr>
		</thead>
		<tbody>
				<c:forEach var="medicion" items="${mediciones}">
					<tr id="${medicion.id_medicion_segmental}">
					


<%-- <fmt:formatDate pattern="dd-MM-yyyy" value=" --%>

		
						
						<td>${medicion.fecha}"</td>
						<td>${medicion.bd_musculo}</td>
						<td>${medicion.bdporcentajegrasas}</td>
						<td>${medicion.bimusculo}</td>
						<td>${medicion.biporcentajegrasas}</td>
						<td>${medicion.pdmusculo}</td>
						<td>${medicion.pdporcentajegrasas}</td>
						<td>${medicion.pimusculo}</td>
						<td>${medicion.piporcentajegrasas}</td>
						<td>${medicion.tmusculo}</td>
						<td>${medicion.tporcentajegrasa}</td>
						<td>
						   <button onclick="a1_onclick('${medicion.id_medicion_segmental}')"
								class="btn btn-success btn-sm btn-block" role="button"
								title="Detalle"> <span style="font-size: smaller">Detalles</button>
					   </td>
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
					<h4 class="modal-title">Detalle de la Medicion Especifica</h4>
					<br>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<br />
				</div>
				<div class="modal-body">

					<form id="formularioMedicionGeneral">
					<div class="form-group row ">
				<label for="fecha" class="col-2 col-form-label">Fecha</label>
				<div class="col-10">
					<input hidden id="id_medicion_segmental" />
					<input hidden id="paciente.id_usuario"
						/>
					<input class="form-control" path="fecha" id="fecha"
						required="required" autocomplete="nope" type="date"  />
				</div>
			</div>

			<div class="form-group row">
				<label for="bdporcentajegrasas" class="col-2 col-form-label">
					Bd%Grasas</label>
				<div class="col-10">
					<input class="form-control" path="bdporcentajegrasas"
						id="bdporcentajegrasas" required="required" type="number" min="0.1" step="0.1"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="bd_musculo" class="col-2 col-form-label">
					Bd musculo</label>
				<div class="col-10">
					<input class="form-control" path="bd_musculo"
						id="bd_musculo" required="required" type="number" min="0.1" step="0.1" />
				</div>
			</div>
			<div class="form-group row">
				<label for="bimusculo" class="col-2 col-form-label">
					Bi Musculo</label>
				<div class="col-10">
					<input class="form-control" path="bimusculo" id="bimusculo"
						required="required" type="number" min="0.1" step="0.1" />
				</div>
			</div>
			<div class="form-group row">
				<label for="piporcentajegrasas" class="col-2 col-form-label">
					Pi%grasas</label>
				<div class="col-10">
					<input class="form-control" path="piporcentajegrasas"
						id="piporcentajegrasas" required="required" type="number" min="0.1" step="0.1"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="pdmusculo" class="col-2 col-form-label">
					Pd Musculo</label>
				<div class="col-10">
					<input class="form-control" path="pdmusculo" id="pdmusculo"
						required="required" type="number" min="0.1" step="0.1" />
				</div>
			</div>
			<div class="form-group row">
				<label for="pdporcentajegrasas" class="col-2 col-form-label">
					Pd%Grasas</label>
				<div class="col-10">
					<input class="form-control" path="pdporcentajegrasas"
						id="pdporcentajegrasas" required="required" type="number" min="0.1" step="0.1" />
				</div>
			</div>
			<div class="form-group row">
				<label for="tporcentajegrasa" class="col-2 col-form-label">
					T%grasa</label>
				<div class="col-10">
					<input class="form-control" path="tporcentajegrasa"
						id="tporcentajegrasa" required="required" type="number" min="0.1" step="0.1" />
				</div>
			</div>
			<div class="form-group row">
				<label for="tmusculo" class="col-2 col-form-label">T Musculo</label>
				<div class="col-10">
					<input class="form-control" path="tmusculo" id="tmusculo"
						required="required" type="number" min="0.1" step="0.1"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="pimusculo" class="col-2 col-form-label">Pi Musculo</label>
				<div class="col-10">
					<input class="form-control" path="pimusculo" id="pimusculo"
						required="required" type="number" min="0.1" step="0.1"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="biporcentajegrasas" class="col-2 col-form-label">Bi%Grasas</label>
				<div class="col-10">
					<input class="form-control" path="biporcentajegrasas"
						id="biporcentajegrasas" required="required" type="number" min="0.1" step="0.1"/>
				</div>
			</div>

					</form>

				</div>
				<div class="modal-footer">
					<div class="btn-group">
						<button id="botonGuardar" type="button"
							title="Guardar Medicion Especifica" class="btn btn-success"
							onclick="guardarMedicion()">Guardar</button>
						<button type="button" id="botonEditar" class="btn btn-primary"
							title="Editar cita" onclick="habilitarEdicion()">Editar</button>
						<button type="button" id="botonEliminar" class="btn btn-danger"
							title="Eliminar cita" onclick="eliminar()">Eliminar</button>
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
<!-- 			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
	<script type="text/javascript">
	function a1_onclick(id) {
		console.log(id);
		urle = 'http://localhost:8080/thunderfat/medicion_segmental/detalles/'
				+ id + '/';
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
	function nuevaMedicion() {

		document.getElementById("formularioMedicionGeneral").reset()
		$("#formularioMedicionGeneral input").removeAttr('disabled');
		$('#formularioMedicionGeneral textarea').removeAttr('disabled');
		$("#botonEditar").hide();
		$("#botonEliminar").hide();
		$('#botonGuardar').show();
		$("#calculado").hide();
		$("#myModal").modal('toggle');
		$('#myModal').modal('show');
		$("#myModal").trigger('focus');
		$('.modal').modal('show');
	};
	function pintarModal(data) {

		
		
		$("#id_medicion_segmental").val(data.id_medicion_segmental);
		$("#paciente.id_usuario").val(data.paciente.id_usuario);
			
		fecha = fechaParser(data.fecha.year, data.fecha.monthValue,
				data.fecha.dayOfMonth);
		$("#fecha").val(fecha);
		$("#bdporcentajegrasas").val(data.bdporcentajegrasas);
		$("#bd_musculo").val(data.bd_musculo);
		$("#bimusculo").val(data.bimusculo);
		$("#piporcentajegrasas").val(data.piporcentajegrasas);
		$("#pdmusculo").val(data.pdmusculo);
		$("#pdporcentajegrasas").val(data.pdporcentajegrasas);
		$("#tporcentajegrasa").val(data.tporcentajegrasa);
		$("#tmusculo").val(data.tmusculo);
		$("#pimusculo").val(data.pimusculo);
		$("#biporcentajegrasas").val(data.biporcentajegrasas);

		
		$("#formularioMedicionGeneral input").prop("disabled", true);
		$("#formularioMedicionGeneral textarea").prop("disabled", true);
		$("#botonEditar").show();
		$("#botonEliminar").show();
		$("#botonGuardar").hide();
		
		
		$("#calculado").show();
		$("#myModal").modal('toggle');
		$('#myModal').modal('show');
		$("#myModal").trigger('focus');
		$('.modal').modal('show');

	}
	function borrarContenidoModel() {
		$('#detalle').empty();
		$("#botonEliminar").removeAttr("href");
		$("#botonEliminar").removeAttr("onClick");
		$("#botonEditar").removeAttr("href");
		$("#botonEditar").removeAttr("onClick");
		$("#detalle").remove();

	}
	function eliminar() {
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");

		var id = $("#id_medicion_segmental").val();
		urle = '/thunderfat/medicion_segmental/deleteAjax/' + id + '/';
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
				$('#' + id).remove();
				
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
	function habilitarEdicion() {
		$('#formularioMedicionGeneral input').removeAttr('disabled');
		$('#formularioMedicionGeneral textarea').removeAttr('disabled');
		$("#botonEditar").hide();
		$('#botonGuardar').show();
		//			.prop("disabled", true);
		//			.removeAttr('disabled')
	};
	function fechaParser(year, month, day) {
		MyDateString = year + '-' + ('0' + month).slice(-2) + '-'
				+ ('0' + day).slice(-2);
		return MyDateString;
	};
	
	function guardarMedicion() {
		console.log("llego a la funcion guardarAntecedente");
		var data = {};
		

		
		
		data['id_medicion_segmental'] = $("#id_medicion_segmental").val();
		data['id_paciente'] = ${paciente.id_usuario};
		data['bdporcentajegrasas'] = $("#bdporcentajegrasas").val();
		data['fecha'] = $("#fecha").val();
		data['bd_musculo']=$("#bd_musculo").val();
		data['bimusculo']=$("#bimusculo").val();			
		data['piporcentajegrasas']=$("#piporcentajegrasas").val();
		data['pdmusculo']=$("#pdmusculo").val();
		data['pdporcentajegrasas']=$("#pdporcentajegrasas").val();			
		data['tporcentajegrasa']=$("#tporcentajegrasa").val();
		data['tmusculo']=$("#tmusculo").val();
		data['pimusculo']=$("#pimusculo").val();
		data['biporcentajegrasas']=$("#biporcentajegrasas").val();

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
					url : "/thunderfat/medicion_segmental/saveAjax",
					data : JSON.stringify(data),
					dataType : 'json',
					timeout : 6000,
					beforeSend : function(request) {
						//'Csrf-Token' is the expected header name, not $csrfTokenName
						request.setRequestHeader(header, token);
					},
					success : function(data) {
						var table = $('#myTable')[0];
						//takeData(data.id_paciente)
						console.log(table);
						if ($('#' + data.id_medicionespecifica).length > 0) {
							alert("Has the row!");								
							var linea = $('#' + data.id_medicion_segmental);
							var celdas = linea.find('td');
							console.log(celdas);
							celdas[0].innerHTML = '' + data.fecha;
							celdas[1].innerHTML = '' + data.bd_musculo;
							celdas[2].innerHTML = '' + data.bdporcentajegrasas;
							celdas[3].innerHTML = '' + data.bimusculo;
							celdas[4].innerHTML = '' + data.biporcentajegrasas;
							celdas[5].innerHTML = '' + data.pdmusculo;
							celdas[6].innerHTML = '' + data.pdporcentajegrasas;
							celdas[7].innerHTML = '' + data.pimusculo;
							celdas[8].innerHTML = '' + data.piporcentajegrasas; 
							celdas[9].innerHTML = '' + data.tmusculo;
							celdas[10].innerHTML = '' + data.tporcentajegrasa;
							
						
							
							
				
							

						} else {
													 
							    var t= $('.table-bordered').DataTable();
							  
							    t.row.add( [
							    	data.fecha,
							    	data.bd_musculo,
							    	data.bdporcentajegrasas,
							    	data.bimusculo,
							    	data.biporcentajegrasas,
							    	data.pdmusculo,
							    	data.pdporcentajegrasas,
							    	data.pimusculo,
							    	data.piporcentajegrasas,
							    	data.tmusculo,
							    	data.tporcentajegrasa,
							    	'<button onclick="a1_onclick('+ data.id_medicion_segmental+ ')"class="btn btn-success btn-sm btn-block" role="button" title="Detalle"> <span style="font-size: smaller">Detalles</span></button>'
							        ] ).node().id = data.id_medicion_segmental;
							    t.draw( false );
							
							
							console.log("pintado  la nueva fila ");
//								var nuevafila = '<tr id="'+data.id_medicionespecifica+'""><td>'
//										+ data.fecha + '</td>';
//								nuevafila += '<td>' + data.porcentajegrasas
//										+ '</td>';
//								nuevafila += '<td>'+ data.metabolismo+'</td>';
//								nuevafila += '<td>'+ data.edad_met+'</td>';
//								nuevafila += '<td>'+ data.masa_osea+'</td>';
//								nuevafila += '<td>'+ data.musculo+'</td>';
//								nuevafila += '<td>'+ data.porcentajeagua+'</td>';
//								nuevafila += '<td><a onclick="a1_onclick('
//										+ data.id_medicionespecifica
//										+ ')"class="btn btn-success btn-sm btn-block" role="button" title="Detalle"> <span style="font-size: smaller">Detalles</span></a></td></tr>';
//								$('#myTable > tbody').append(nuevafila);
//								console.log("pintada la nueva linea");
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
	
	
	
		$(document).ready(function() {
			console.log("primer script ");
			paciente = ${paciente.id_usuario};
			 $('.table-bordered').DataTable();
			

		});
	
	</script>
</body>
</html>