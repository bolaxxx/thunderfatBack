
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
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<title>Listado de Mediciones Generales</title>
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>


	<div class="container theme-showcase" role="main">

		<h3>Mediciones Generales del Paciente ${paciente.nombre}
			${paciente.apellidos}</h3>

		<c:if test="${msg !=null }">
			<div class='alert alert-success' role='alert'>${msg}</div>
		</c:if>

		<spring:url value="/medicion_general/edit" var="urlEdit" />
		<spring:url value="/medicion_general/delete" var="urlDelete" />
		<spring:url value="/medicion_general/create" var="urlCreate" />
		<button onclick="nuevaMedicion()" class="btn btn-success"
			role="button" title="Nuevo paciente">Nuevo</button><br> <br> <br>
		<br>
		<div class="row">
			<div class="col-md-8">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title" id="tituloGrafico1">Grafica</h4>
						<canvas id="myChart" width="400" height="300"></canvas>
					</div>
				</div>
			</div>
			</div>
		
		<br> <br>
		<div class="table-responsive" id="tablaPrincipal">
			<table class="table table-hover table-striped table-bordered">
			<thead>
				<tr>
					
					<th>Fecha</th>
					<th>Peso Ideal KG</th>
					<th>Peso Actual KG</th>
					<th>Brazo Cm</th>
					<th>Cintura Cm</th>
					<th>Cadera Cm</th>
					<th>ICC</th>
					<th>IMC</th>
					<th>%Grasas</th>
					<th>Tension Max</th>
					<th>Tension Min</th>
					<th>Acciones</th>



				</tr>
				</thead>
				<tbody>
				<c:forEach var="medicion" items="${mediciones}">
					<tr id="${medicion.id_medicion_general}">


						<%-- <fmt:formatDate pattern="dd-MM-yyyy" value=" --%>

						<td>${medicion.fecha}</td>
						<td>${medicion.peso_ideal}</td>
						<td>${medicion.peso_actual}</td>
						<td>${medicion.brazo}</td>
						<td>${medicion.cintura}</td>
						<td>${medicion.cadera}</td>
						<td>${medicion.icc}</td>
						<td>${medicion.IMC}</td>
						<td>${medicion.porcentajegrasas}</td>
						<td>${medicion.tension_max}</td>
						<td>${medicion.tension_min}</td>
						<td><button type="button" onclick="a1_onclick('${medicion.id_medicion_general}')" class="btn btn-success btn-sm btn-block" role="button"
							title="Detalle">Detalle</button></td>
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
								<input hidden id="id_medicion_general" />
								<input hidden id="paciente.id_usuario"
									value="${paciente.id_usuario}" />
								<input class="form-control" path="fecha" id="fecha"
									required="required" autocomplete="nope" type="date" />
							</div>
						</div>

						<div class="form-group row">
							<label for="brazo" class="col-2 col-form-label">Circunferencia
								Brazo(cm)</label>
							<div class="col-10">
								<input class="form-control" path="brazo" id="brazo"
									required="required" type="text" />
							</div>
						</div>

						<div class="form-group row">
							<label for="cadera" class="col-2 col-form-label">Cadera(cm)</label>
							<div class="col-10">
								<input class="form-control" path="cadera" id="cadera"
									required="required" type="text" />
							</div>
						</div>

						<div class="form-group row">
							<label for="cintura" class="col-2 col-form-label">Cintura(cm)</label>
							<div class="col-10">
								<input class="form-control" path="cintura" id="cintura"
									required="required" type="text" />
							</div>
						</div>
						<div class="form-group row">
							<label for="icc" class="col-2 col-form-label">I.C.C</label>
							<div class="col-10">
								<input class="form-control" path="icc" id="icc" type="text" />
							</div>
						</div>

						<div class="form-group row">
							<label for="peso_actual" class="col-2 col-form-label">Peso
								Actual(Kg)</label>
							<div class="col-10">
								<input class="form-control" path="peso_actual"
									id="peso_actual" required="required" type="text" />
							</div>
						</div>
						<div class="form-group row">
							<label for="peso_ideal" class="col-2 col-form-label">Peso
								Ideal(Kg)</label>
							<div class="col-10">
								<input class="form-control" path="peso_ideal"
									id="peso_ideal" required="required" type="text" />
							</div>
						</div>
						<div class="form-group row">
							<label for="IMC" class="col-2 col-form-label">IMC</label>
							<div class="col-10">
								<input class="form-control" path="IMC" id="IMC" type="text" />
							</div>
						</div>
						<div class="form-group row">
							<label for="porcentajegrasas" class="col-2 col-form-label">%Grasas</label>
							<div class="col-10">
								<input class="form-control" path="porcentajegrasas"
									id="porcentajegrasas" type="text" />
							</div>
						</div>
						<div class="form-group row">
							<label for="tension_max" class="col-2 col-form-label">Tension
								Maxima</label>
							<div class="col-10">
								<input class="form-control" path="tension_max"
									id="tension_max" type="text" />
							</div>
						</div>
						<div class="form-group row">
							<label for="tension_min" class="col-2 col-form-label">Tension
								Minima</label>
							<div class="col-10">
								<input class="form-control" path="tension_min"
									id="tension_min" type="text" />
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
	<script type="text/javascript">
	
	
	
	function a1_onclick(id) {
		console.log(id);
		urle = 'http://localhost:8080/thunderfat/medicion_general/detalles/'
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
		$("#id_medicion_general").val(data.id_medicion_general);
		$("#paciente.id_usuario").val(data.paciente.id_usuario);
			
		fecha = fechaParser(data.fecha.year, data.fecha.monthValue,
				data.fecha.dayOfMonth);
		$("#fecha").val(fecha);
		$("#brazo").val(data.brazo);
		$("#cadera").val(data.cadera);
		$("#cintura").val(data.cintura);
		$("#metabolismo").val(data.metabolismo);
		$("#icc").val(data.icc);
		$("#peso_actual").val(data.peso_actual);
		$("#peso_ideal").val(data.peso_ideal);
		$("#IMC").val(data.imc);
		$("#porcentajegrasas").val(data.porcentajegrasas);
		$("#tension_max").val(data.tension_max);
		$("#tension_min").val(data.tension_min);
// 		$("#grasasIdMin").val(data.grasasid_min);
// 		$("#grasasIdMax").val(data.grasaid_max);
// 		$("#aguaId").val(data.aguaid);
// 		$("#MusculoIdMax").val(data.musculo_idmax);
// 		$("#MusculoIdMin").val(data.musculo_idmin);
// 		$("#PesoOxMuscMax").val(data.poxmus_max);
// 		$("#PesoOxMuscMin").val(data.poxmus_min);
// 		$("#LitrosAgua").val(data.litrosagua);
// 		$("#RetencionLiquidos").val(data.retencionliquidos);
		
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

		var id = $("#id_medicion_general").val();
		urle = '/thunderfat/medicion_general/deleteAjax/' + id + '/';
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
	
	
	$('#brazo, #cintura').change(function() {
		console.log('llego al script 1');
		var cadera = $('#cadera').val();
		var cintura = $('#cintura').val();
		var icc = cintura / cadera;
		$('#icc').val(redondearDosDecimales(icc));
	});
	
	function redondearDosDecimales (numero){
		return Math.round(numero * 100) / 100;
	}
		$('#peso_actual').change(function() {
			console.log('llego al script 2');
			var peso = $('#peso_actual').val();
			var altura = ${paciente.altura};
			var sexo ="${paciente.sexo}";
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
	
	function guardarMedicion() {
		console.log("llego a la funcion guardarAntecedente");
		var data = {};
		data['id_medicion_general'] = $("#id_medicion_general").val();
		data['id_paciente'] = ${paciente.id_usuario};
		data['brazo'] = $("#brazo").val();
		data['fecha'] = $("#fecha").val();
		data['cintura']=$("#cintura").val();
		data['cadera']=$("#cadera").val();			
		data['icc']=$("#icc").val();
		data['peso_actual']=$("#peso_actual").val();
		data['peso_ideal']=$("#peso_ideal").val();			
		data['IMC']=$("#IMC").val();
		data['porcentajegrasas']=$("#porcentajegrasas").val();
		data['tension_max']=$("#tension_max").val();
		data['tension_min']=$("#tension_min").val();

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
					url : "/thunderfat/medicion_general/saveAjax",
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
							var linea = $('#' + data.id_medicion_general);
							var celdas = linea.find('td');
							console.log(celdas);
							celdas[0].innerHTML = '' + data.fecha;
							celdas[1].innerHTML = '' + data.peso_ideal;
							celdas[2].innerHTML = '' + data.peso_actual;
							celdas[3].innerHTML = '' + data.brazo;
							celdas[4].innerHTML = '' + data.cintura;
							celdas[5].innerHTML = '' + data.cadera;
							celdas[6].innerHTML = '' + data.porcentajegrasas;
							celdas[7].innerHTML = '' + data.icc;
							celdas[8].innerHTML = '' + data.IMC; 
							celdas[9].innerHTML = '' + data.tension_max;
							celdas[10].innerHTML = '' + data.tension_min;
							
						} else {
													 
							    var t= $('.table-bordered').DataTable();
							  
							    t.row.add( [
							    	data.fecha,
							    	data.peso_ideal,
							    	data.peso_actual,
							    	data.brazo,
							    	data.cintura,
							    	data.cadera,
							    	data.porcentajegrasas,
							    	data.icc,
							    	data.IMC,
							    	data.tension_max,
							    	data.tension_min,
							    	'<button onclick="a1_onclick('+ data.id_medicion_general+ ')"class="btn btn-success btn-sm btn-block" role="button" title="Detalle"> <span style="font-size: smaller">Detalles</span></button>'
							        ] ).node().id = data.id_medicion_general;
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
			takeData(paciente);

		});
		function takeData(paciente) {
			console.log("llego al script para cojer el json ");
			// 			"${home}/localidadesenProvincia/${provincia}"
			var urle = 'http://localhost:8080/thunderfat/medicion_general/datosGrafica/'
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

				},
				error : function(e) {
					console.log("ERROR: ", e);
					display(e);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
		}

		function pintarGrafica(result) {
			console.log("llego al script para el pintado ");

			var labels = result.map(function(e) {

				var input = e.fecha
				var day = e.fecha.dayOfMonth;
				var month = e.fecha.monthValue - 1; // Month is 0-indexed
				var year = e.fecha.year;

				var date = ''+day+'/'+month+'/'+year;

				return date;
			}), source1 = result.map(function(e) {
				return e.peso_actual;
			}), source2 = result.map(function(e) {
				return e.cintura;
			}), source3 = result.map(function(e) {
				return e.cadera;
			}),

			source4 = result.map(function(e) {
				return e.porcentajegrasas;
			}), source5 = result.map(function(e) {
				return e.tension_max;
			}), source6 = result.map(function(e) {
				return e.tension_min;
			});
			var ctx = document.getElementById("myChart").getContext("2d");
			var myChart = new Chart(ctx, {
				type : 'line',
				data : {
					labels : labels,
					datasets : [ {
						label : "Peso",
						data : source1,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(6, 167, 125, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(6, 167, 125, 1)",
						pointHoverBackgroundColor : "rgba(6, 167, 125, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "Cintura",
						data : source2,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(246, 71, 64, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(246, 71, 64, 1)",
						pointHoverBackgroundColor : "rgba(246, 71, 64, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "Cadera",
						data : source3,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(26, 143, 227, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(26, 143, 227, 1)",
						pointHoverBackgroundColor : "rgba(26, 143, 227, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "%Grasas",
						data : source4,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(4, 3, 0, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(4, 3, 0, 1)",
						pointHoverBackgroundColor : "rgba(4, 3, 0, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "Tension_max",
						data : source5,
						borderWidth : 2,
						backgroundColor : "rgba(254, 253, 234, 0.1)",
						borderColor : "rgba(250, 166, 10, 1)",
						pointBackgroundColor : "rgba(225, 225, 225, 1)",
						pointBorderColor : "rgba(250, 166, 10, 1)",
						pointHoverBackgroundColor : "rgba(250, 166, 10, 1)",
						pointHoverBorderColor : "#fff"
					}, {
						label : "Tension_min",
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
			// 				});
		}
	</script>
</body>
</html>