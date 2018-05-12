function ObtenerBloques(){
	$.post( "/obtenerBloques",
			{sede: $('#sede').val()},
			function( data ) {
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
			{bloque: $('#bloque').val()},
			function( data ) {
				$.each(data, 
						function(i,val){
							$('#pisos').append('<option>'+val+'</option>');
						}
				);
			}
	);
}