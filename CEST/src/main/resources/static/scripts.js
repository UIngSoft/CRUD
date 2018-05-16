function ObtenerBloques(){
	$.post( "/obtenerBloques",
			{sede: $('#sede').val()},
			function( data ) {
				$('#bloque').empty();
				$('#bloque').append('<option>Seleccione</option>');
				$.each(data, 
						function(i,val){
							$('#bloque').append('<option>'+val+'</option>');
						}
				);
			}
	);
}


function ObtenerPisos(){
	$.post( "/obtenerPisos",
			{sede: $('#sede').val(), bloque: $('#bloque').val()},
			function( data ) {
				$('#piso').empty();
				$('#piso').append('<option>Seleccione</option>');
				$.each(data, 
						function(i,val){
							$('#piso').append('<option>'+val+'</option>');
						}
				);
			}
	);
<<<<<<< HEAD
}

function CalcularVencimiento(){
	alert('Calcumando vencimiento');
=======
>>>>>>> 669416525bb28225375f5c59b453c9fa08583460
}