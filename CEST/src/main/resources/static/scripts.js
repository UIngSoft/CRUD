function BuscarId(id){
	$.post( "/buscarID",
			{id: id},
			function( extintor ) {
				$('#Extintores').val(extintor);
			}
	);
}

function ObtenerBloques(){
	$.post( "/obtenerBloques",
			{sede: $('#sede').val()},
			function( data ) {
				$('#bloque').html('<option>Seleccione</option>');
				$('#piso').html('<option>Seleccione</option>');
				$.each(data, 
						function(i,val){
							$('#bloque').append('<option value="'+val+'">'+val+'</option>');
						}
				);
			}
	);
}


function ObtenerPisos(){
	$.post( "/obtenerPisos",
			{sede: $('#sede').val(), bloque: $('#bloque').val()},
			function( data ) {
				$('#piso').html('<option>Seleccione</option>');
				$.each(data, 
						function(i,val){
							$('#piso').append('<option value="'+val+'">'+val+'</option>');
						}
				);
			}
	);
}

function CalcularVencimiento(caducidad){
	var array = $('#fechaultimarecarga').val().split('-');
	var fechavencimiento = (parseInt(array[0])+parseInt(caducidad))+'-'+array[1]+'-'+array[2]
	$('#fechavencimiento').val(fechavencimiento);
	$('#fechavencimiento').text(fechavencimiento);
}

function ObtenerEmpresa(nit){
	$.post( "/obtenerEmpresa",
			{numerocontrato: $('#numerocontrato').val()},
			function( data ) {
				$('#empresa').val(data);
				$('#empresa').text(data);
			}
	);
}