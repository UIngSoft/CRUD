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
}

<<<<<<< HEAD
function fecha(){
	alert('casd');
=======
function CalcularVencimiento(){
	alert('Calcumando vencimiento');
>>>>>>> 144b80de60ecd82b27fe88b518788bb174013c5d
}