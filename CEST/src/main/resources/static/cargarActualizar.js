function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
	
function Leer(){
	$.post( "/obtenerExtintor",
			{id: getParameterByName('id')},
			function( extintor ) {
				console.log(extintor);
				$('#id').val(extintor.elemento.id);
				$('#cedulaencargado').val(extintor.elemento.encargado.cedula);
				$('#numerocontrato').val(extintor.elemento.contrato.numero);
				$('#tamanio').html('<option>'+extintor.tamanio+'<option>');
				$('#fichatecnica').html('<option>'+extintor.fichatecnica.tipo+'<option>');
				$('#empresa').val(extintor.elemento.contrato.empresa.nombre);
				$('#fechaultimarecarga').val(extintor.fechaultimarecarga);
				$('#caducidad').html('<option>'+extintor.caducidadanios+'<option>');
				$('#fechavencimiento').val(extintor.fechavencimiento);
				$('#estado').html('<option>'+extintor.estado+'<option>');
				$('#sede').html('<option>'+extintor.elemento.piso.bloque.sede.nombre+'<option>');
				$('#bloque').html('<option>'+extintor.elemento.piso.pisoPk.letrabloque+'<option>');
				$('#piso').html('<option>'+extintor.elemento.piso.pisoPk.numero+'<option>');
				
				/*$('#id').text(extintor.elemento.id);
				$('#cedulaencargado').text(extintor.elemento.encargado.cedula);
				$('#numerocontrato').text(extintor.elemento.contrato.numero);
				$('#tamanio').html('<option>'+extintor.tamanio+'<option>');
				$('#fichatecnica').html('<option>'+extintor.fichatecnica.tipo+'<option>');
				$('#empresa').text(extintor.elemento.contrato.empresa.nombre);
				$('#fechaultimarecarga').text(extintor.fechaultimarecarga);
				$('#caducidad').html('<option>'+extintor.caducidadanios+'<option>');
				$('#fechavencimiento').text(extintor.fechavencimiento);
				$('#estado').html('<option>'+extintor.estado+'<option>');
				$('#sede').html('<option>'+extintor.elemento.piso.bloque.sede.nombre+'<option>');
				$('#bloque').html('<option>'+extintor.elemento.piso.pisoPk.letrabloque+'<option>');
				$('#piso').html('<option>'+extintor.elemento.piso.pisoPk.numero+'<option>');*/
			}
	);
}
window.onload = Leer;