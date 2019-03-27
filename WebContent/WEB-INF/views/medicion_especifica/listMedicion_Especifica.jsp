
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="${_csrf.token}" name="_csrf" />
<meta content="${_csrf.headerName}" name="_csrf_header" />
<spring:url value="/resources" var="urlPublic" />
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap4.min.css">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<title>Listado de Mediciones Especifica</title>


</head>

<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>


	<div class="container theme-showcase" role="main">

		<h3> Mediciones Especificas del Paciente
			${paciente.nombre} ${paciente.apellidos}</h3>

		<c:if test="${msg !=null }">
			<div class='alert alert-success' role='alert'>${msg}</div>
		</c:if>

		<spring:url value="/medicion_especifica/edit" var="urlEdit" />
		<spring:url value="/medicion_especifica/delete" var="urlDelete" />
		<spring:url value="/medicion_especifica/create" var="urlCreate" />
		<button onclick="nuevaMedicion()" class="btn btn-success"
			role="button" title="Nuevo Medicicion Especifica">Nuevo</button>
		<br> <br>
<div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
      <h4  class="card-title" id="tituloGrafico1">Grafica Grasas</h4>
		<canvas id="myChart" width="300" height="300"></canvas>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h4  class="card-title" id="tituloGrafica2">Grafica Musculo</h4>
        <canvas id="myChart2" width="300" height="300"></canvas>
        
      </div>
    </div>
  </div>
</div>
<br>
<br>
<h5>Listado de Mediciones Especifica</h5>
		<div class="table-responsive" id="tablaPrincipal">
			<table class="table table-hover table-striped table-bordered">
				<thead>
				<tr>

					<th>Fecha</th>
					<th>%Grasas</th>
					<th>Metabolismo</th>
					<th>Edad Met</th>
					<th>Masa Osea</th>
					<th>Musculo</th>
					<th>%Agua</th>
					<th>Acciones</th>




				</tr>
				</thead>
				<tbody>
				<c:forEach var="medicion" items="${mediciones}">
					<tr id="${medicion.id_medicionespecifica}">
						<%-- 					<fmt:formatDate pattern="dd-MM-yyyy" value=" --%>
						<td>${medicion.fecha}</td>
						<td>${medicion.porcentajegrasa}</td>
						<td>${medicion.metabolismo}</td>
						<td>${medicion.edad_met}</td>
						<td>${medicion.masa_osea}</td>
						<td>${medicion.musculo}</td>
						<td>${medicion.porcentajeagua}</td>
						<td><a
							onclick="a1_onclick('${medicion.id_medicionespecifica}')"
							class="btn btn-success btn-sm btn-block" role="button"
							title="Detalle"> <span style="font-size: smaller">Detalles</span></a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<br>
		<br>
		<br>
		
		
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

						<form id="formularioMedicionEspecifica">
							<div class="form-group row ">
								<label for="fecha" class="col-2 col-form-label">Fecha</label>
								<div class="col-10">
									<input hidden id="id_medicionespecifica" /> <input hidden
										id="paciente.id_usuario" /> <input class="form-control"
										id="fecha" id="fecha" required="required" autocomplete="false"
										type="date" />
								</div>
							</div>
							<div class="form-group row">
								<label for="peso" class="col-2 col-form-label">Peso</label>
								<div class="col-10">
									<input class="form-control" path="peso" id="peso"
										required="required" type="text" />
								</div>
							</div>
							<div class="form-group row">
								<label for="porcentajegrasa" class="col-2 col-form-label">%Grasas</label>
								<div class="col-10">
									<input class="form-control" path="porcentajegrasa"
										id="porcentajegrasa" required="required" type="text" />
								</div>
							</div>

							<div class="form-group row">
								<label for="metabolismo" class="col-2 col-form-label">Metabolismo</label>
								<div class="col-10">
									<input class="form-control" path="metabolismo" id="metabolismo"
										required="required" type="text" />
								</div>
							</div>
							<div class="form-group row">
								<label for="edad_met" class="col-2 col-form-label">Edad
									Metabolica</label>
								<div class="col-10">
									<input class="form-control" path="edad_met" id="edad_met"
										required="required" type="text" />
								</div>
							</div>
							<div class="form-group row">
								<label for="musculo" class="col-2 col-form-label">Musculo</label>
								<div class="col-10">
									<input class="form-control" path="musculo" id="musculo"
										required="required" type="text" />
								</div>
							</div>



							<div class="form-group row">
								<label for="grasas" class="col-2 col-form-label">Grasa</label>
								<div class="col-10">
									<input class="form-control" path="grasas" id="grasas"
										required="required" type="text" />
								</div>
							</div>

							<div class="form-group row">
								<label for="grasavisceral" class="col-2 col-form-label">Grasa
									Visceral</label>
								<div class="col-10">
									<input class="form-control" path="grasavisceral"
										id="grasavisceral" required="required" type="text" />
								</div>
							</div>
							<div class="form-group row">
								<label for="masa_osea" class="col-2 col-form-label">Masa
									Osea</label>
								<div class="col-10">
									<input class="form-control" path="masa_osea" id="masa_osea"
										required="required" type="text" />
								</div>
							</div>
							
							<div id="calculado">
								<div class="form-group row">
									<label for="mbi" class="col-2 col-form-label">MBI</label>
									<div class="col-10">
										<input class="form-control" id="mbi" path="mbi" required
											type="text" />
									</div>
								</div>
								<div class="form-group row">
									<label for="grasasIdMin" class="col-2 col-form-label">grasasIdMin</label>
									<div class="col-10">
										<input class="form-control" id="grasasIdMin"
											path="grasasIdMin" required type="text" />
									</div>
								</div>
								<div class="form-group row">
									<label for="grasasIdMax" class="col-2 col-form-label">grasasIdMax</label>
									<div class="col-10">
										<input class="form-control" id="grasasIdMax" path="grasasIdMax" required
											type="text" />
									</div>
								</div>
								<div class="form-group row">
									<label for="aguaId" class="col-2 col-form-label">aguaId</label>
									<div class="col-10">
										<input class="form-control" id="aguaId" path="aguaId" required
											type="text" />
									</div>
								</div>
								<div class="form-group row">
									<label for="MusculoIdMax" class="col-2 col-form-label">MusculoIdMax</label>
									<div class="col-10">
										<input class="form-control" id="MusculoIdMax"
											path="MusculoIdMax" required type="text" />
									</div>
								</div>
								<div class="form-group row">
									<label for="MusculoIdMin" class="col-2 col-form-label">MusculoIdMin</label>
									<div class="col-10">
										<input class="form-control" id="MusculoIdMin"
											path="MusculoIdMin" required type="text" />
									</div>
								</div>
								<div class="form-group row">
									<label for="PesoOxMuscMax" class="col-2 col-form-label">PesoOxMuscMax</label>
									<div class="col-10">
										<input class="form-control" id="PesoOxMuscMax"
											path="PesoOxMuscMax" required type="text" />
									</div>
								</div>
								<div class="form-group row">
									<label for="PesoOxMuscMin" class="col-2 col-form-label">PesoOxMuscMin</label>
									<div class="col-10">
										<input class="form-control" id="PesoOxMuscMin"
											path="PesoOxMuscMin" required type="text" />
									</div>
								</div>
								<div class="form-group row">
									<label for="LitrosAgua" class="col-2 col-form-label">LitrosAgua</label>
									<div class="col-10">
										<input class="form-control" id="LitrosAgua" path="LitrosAgua"
											required type="text" />
									</div>
								</div>
								<div class="form-group row">
									<label for="RetencionLiquidos" class="col-2 col-form-label">RetencionLiquidos</label>
									<div class="col-10">
										<input class="form-control" id="RetencionLiquidos"
											path="RetencionLiquidos" required type="text" />
									</div>
								</div>
							</div><div class="form-group row">
								<label for="porcentajeagua" class="col-2 col-form-label">%Agua</label>
								<div class="col-10">
									<input class="form-control" path="porcentajeagua" id="porcentajeagua" required="required" type="text">
								</div>
							</div>

						</form>

					</div>
					<div class="modal-footer">
						<div class="btn-group">
							<button id="botonGuardar" type="button" title="Guardar Medicion Especifica"
								class="btn btn-success" onclick="guardarMedicion()">Guardar</button>
							<button type="button" id="botonEditar" class="btn btn-primary"
								title="Editar cita" onclick="habilitarEdicion()">Editar</button> <button type="button"
								id="botonEliminar" class="btn btn-danger" title="Eliminar cita" onclick="eliminar()">Eliminar</button>
						</div>
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
		function a1_onclick(id) {
			console.log(id);
			urle = 'http://localhost:8080/thunderfat/medicion_especifica/detalles/'
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

			document.getElementById("formularioMedicionEspecifica").reset()
			$("#formularioMedicionEspecifica input").removeAttr('disabled');
			$('#formularioMedicionEspecifica textarea').removeAttr('disabled');
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
			$("#id_medicionespecifica").val(data.id_medicionespecifica);
			$("#paciente.id_usuario").val(data.paciente.id_usuario);

			fecha = fechaParser(data.fecha.year, data.fecha.monthValue,
					data.fecha.dayOfMonth);
			$("#fecha").val(fecha);
			$("#peso").val(data.peso);
			$("#porcentajegrasa").val(data.porcentajegrasa);
			$("#metabolismo").val(data.metabolismo);
			$("#edad_met").val(data.edad_met);
			$("#musculo").val(data.musculo);
			$("#grasas").val(data.grasas);
			$("#grasavisceral").val(data.grasavisceral);
			$("#masa_osea").val(data.masa_osea);
			$("#porcentajeagua").val(data.porcentajeagua);
			$("#mbi").val(data.mbi);
			$("#grasasIdMin").val(data.grasasid_min);
			$("#grasasIdMax").val(data.grasaid_max);
			$("#aguaId").val(data.aguaid);
			$("#MusculoIdMax").val(data.musculo_idmax);
			$("#MusculoIdMin").val(data.musculo_idmin);
			$("#PesoOxMuscMax").val(data.poxmus_max);
			$("#PesoOxMuscMin").val(data.poxmus_min);
			$("#LitrosAgua").val(data.litrosagua);
			$("#RetencionLiquidos").val(data.retencionliquidos);
			
			$("#formularioMedicionEspecifica input").prop("disabled", true);
			$("#formularioMedicionEspecifica textarea").prop("disabled", true);
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

			var id = $("#id_medicionespecifica").val();
			urle = '/thunderfat/medicion_especifica/deleteAjax/' + id + '/';
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
					var usuario=${paciente.id_usuario};
					takeData(usuario);
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
			$('#formularioMedicionEspecifica input').removeAttr('disabled');
			$('#formularioMedicionEspecifica textarea').removeAttr('disabled');
			$("#botonEditar").hide();
			$('#botonGuardar').show();
			//			.prop("disabled", true);
			//			.removeAttr('disabled')
		};
		function fechaParser(year, month, day) {
			MyDateString = year + '-' + ('0' + month).slice(-2) + '-'
					+ ('0' + day).slice(-2);
			return MyDateString;
		}
		function guardarMedicion() {
			console.log("llego a la funcion guardarAntecedente");
			var data = {};
			data['id_medicionespecifica'] = $("#id_medicionespecifica").val();
			data['id_paciente'] = ${paciente.id_usuario};
			data['grasasvisceral'] = $("#grasavisceral").val();
			data['fecha'] = $("#fecha").val();
			data['porcentajeagua']=$("#porcentajeagua").val();
			data['metabolismo']=$("#metabolismo").val();			
			data['edad_met']=$("#edad_met").val();
			data['musculo']=$("#musculo").val();
			data['masa_osea']=$("#masa_osea").val();			
			data['porcentajegrasas']=$("#porcentajegrasa").val();
			data['peso']=$("#peso").val();
			

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
						url : "/thunderfat/medicion_especifica/saveAjax",
						data : JSON.stringify(data),
						dataType : 'json',
						timeout : 6000,
						beforeSend : function(request) {
							//'Csrf-Token' is the expected header name, not $csrfTokenName
							request.setRequestHeader(header, token);
						},
						success : function(data) {
							var table = $('#myTable')[0];
							takeData(data.id_paciente)
							console.log(table);
							if ($('#' + data.id_medicionespecifica).length > 0) {
								alert("Has the row!");								
								var linea = $('#' + data.id_medicionespecifica);
								var celdas = linea.find('td');
								console.log(celdas);
								celdas[0].innerHTML = '' + data.fecha;
								celdas[1].innerHTML = '' + data.porcentajegrasas;
								celdas[2].innerHTML = '' + data.metabolismo;
								celdas[3].innerHTML = '' + data.edad_met;
								celdas[4].innerHTML = '' + data.masa_osea;
								celdas[5].innerHTML = '' + data.musculo;
								celdas[6].innerHTML = '' + data.porcentajeagua;
								

							} else {
														 
								    var t= $('.table-bordered').DataTable();
								  
								    t.row.add( [
								    	data.fecha,
								    	data.porcentajegrasas,
								    	data.metabolismo,
								    	data.edad_met,
								    	data.masa_osea,
								    	data.musculo,
								    	data.porcentajeagua,
								    	'<a onclick="a1_onclick('+ data.id_medicionespecifica+ ')"class="btn btn-success btn-sm btn-block" role="button" title="Detalle"> <span style="font-size: smaller">Detalles</span></a>'
								        ] ).node().id = data.id_medicionespecifica;
								    t.draw( false );
								
								
								console.log("pintado  la nueva fila ");
// 								var nuevafila = '<tr id="'+data.id_medicionespecifica+'""><td>'
// 										+ data.fecha + '</td>';
// 								nuevafila += '<td>' + data.porcentajegrasas
// 										+ '</td>';
// 								nuevafila += '<td>'+ data.metabolismo+'</td>';
// 								nuevafila += '<td>'+ data.edad_met+'</td>';
// 								nuevafila += '<td>'+ data.masa_osea+'</td>';
// 								nuevafila += '<td>'+ data.musculo+'</td>';
// 								nuevafila += '<td>'+ data.porcentajeagua+'</td>';
// 								nuevafila += '<td><a onclick="a1_onclick('
// 										+ data.id_medicionespecifica
// 										+ ')"class="btn btn-success btn-sm btn-block" role="button" title="Detalle"> <span style="font-size: smaller">Detalles</span></a></td></tr>';
// 								$('#myTable > tbody').append(nuevafila);
// 								console.log("pintada la nueva linea");
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
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			console.log("primer script ");
			
		        $('.table-bordered').DataTable();
		   
			paciente = ${paciente.id_usuario};
			takeData(paciente);

		});
		function takeData(paciente) {
			console.log("llego al script para cojer el json ");
			// 			"${home}/localidadesenProvincia/${provincia}"
			var urle = 'http://localhost:8080/thunderfat/medicion_especifica/datosGrafica/'
					+ paciente + '/';

			console.log(urle);

			$.ajax({
				type : "GET",

				url : urle,
				//data : JSON.stringify(data),
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					console.log("SUCCESS: ", data);
					//display(data);
					pintarGrafica(data);
					pintarGrafica2(data);
				},
				error : function(e) {
					console.log("ERROR: ", e);
					display(e);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
		};

		function pintarGrafica(result) {
			console.log("llego al script para el pintado ");
// 			$("#tablaPrincipal").after(
// 					'<h4 id="tituloGrafico1">Grafica Grasas</h4>');
// 			$("#tituloGrafico1").after(
// 					'<canvas id="myChart" width="400" height="400"></canvas>');

			var labels = result.map(function(e) {
				var input = e.fecha
				var day = e.fecha.dayOfMonth;
				var month = e.fecha.monthValue - 1; // Month is 0-indexed
				var year = e.fecha.year;

				//var date = new Date(Date.UTC(year, month, day));
				var  date=day+'/'+month+'/'+year;
				return date;

			}), source1 = result.map(function(e) {
				return e.grasasid_min;
			}), source2 = result.map(function(e) {
				return e.grasaid_max;
			}), source3 = result.map(function(e) {
				return e.grasavisceral;
			}), source5 = result.map(function(e) {
				return e.grasas;
			}),

			source4 = result.map(function(e) {
				return e.porcentajegrasas;
			});

			var ctx = document.getElementById("myChart").getContext("2d");
			var myChart = new Chart(ctx, {
				type : 'line',
				data : {
					labels : labels,
					datasets : [ {
						label : "Grasas",
						data : source5,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(6, 167, 125, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(6, 167, 125, 1)",
						pointHoverBackgroundColor : "rgba(6, 167, 125, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "Grasas Id Min",
						data : source1,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(246, 71, 64, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(246, 71, 64, 1)",
						pointHoverBackgroundColor : "rgba(246, 71, 64, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "Grasas Id Max",
						data : source2,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(26, 143, 227, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(26, 143, 227, 1)",
						pointHoverBackgroundColor : "rgba(26, 143, 227, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "Grasa Visceral",
						data : source3,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(4, 3, 0, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(4, 3, 0, 1)",
						pointHoverBackgroundColor : "rgba(4, 3, 0, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "%Grasas",
						data : source4,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(250, 166, 10, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(250, 166, 10, 1)",
						pointHoverBackgroundColor : "rgba(250, 166, 10, 1)",
						pointHoverBorderColor : "#fff"
					} ]
				}
			});

		};
		function pintarGrafica2(result) {
			console.log("llego al script para el pintado ");
// 			$("#myChart").after('<h4 id="tituloGrafica2">Grafica Musculo</h4>');
// 			$("#tituloGrafica2").after(
// 					'<canvas id="myChart2" width="400" height="400"></canvas>');

			var labels = result.map(function(e) {
				var input = e.fecha
				var day = e.fecha.dayOfMonth;
				var month = e.fecha.monthValue - 1; // Month is 0-indexed
				var year = e.fecha.year;

				//var date = new Date(Date.UTC(year, month, day));
					var  date=day+'/'+month+'/'+year;
				return date;
				//return new Date(e.fecha);
			}), source1 = result.map(function(e) {
				return e.musculo;
			}), source2 = result.map(function(e) {
				return e.musculo_idmax;
			}), source3 = result.map(function(e) {
				return e.musculo_idmin;
			}),

			source4 = result.map(function(e) {
				return e.poxmus_max;
			}), source5 = result.map(function(e) {
				return e.poxmus_min;
			}), source6 = result.map(function(e) {
				return e.masa_osea;
			});
			var ctx = document.getElementById("myChart2").getContext("2d");
			var myChart = new Chart(ctx, {
				type : 'line',
				data : {
					labels : labels,
					datasets : [ {
						label : "Musculo",
						data : source1,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(6, 167, 125, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(6, 167, 125, 1)",
						pointHoverBackgroundColor : "rgba(6, 167, 125, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "Musculo id Min",
						data : source2,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(246, 71, 64, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(246, 71, 64, 1)",
						pointHoverBackgroundColor : "rgba(246, 71, 64, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "Musculo id Min",
						data : source3,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(26, 143, 227, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(26, 143, 227, 1)",
						pointHoverBackgroundColor : "rgba(26, 143, 227, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "%POxMus Max",
						data : source4,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(4, 3, 0, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(4, 3, 0, 1)",
						pointHoverBackgroundColor : "rgba(4, 3, 0, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "POxMus Min",
						data : source5,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(250, 166, 10, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(250, 166, 10, 1)",
						pointHoverBackgroundColor : "rgba(250, 166, 10, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "Masa Osea",
						data : source6,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(246, 250, 15, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(246, 250, 15, 1)",
						pointHoverBackgroundColor : "rgba(246, 250, 15, 1)",
						pointHoverBorderColor : "#fff"
					} ]
				}
			});
			//		});
		};
	</script>

</body>
</html>