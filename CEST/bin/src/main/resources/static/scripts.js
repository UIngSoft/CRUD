<<<<<<< HEAD
function filtrar(){
	var sede = document.getElementById('sedeSelected').value;
	alert('Será redirecionado');
	location.href='/consulta?tipo=general&sede='+sede+'&bloque&piso';
}
=======
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

function CalcularVencimiento(caducidad){
	var fecharecarga = $('#fechaultimarecarga').val();
	alert(fecharecarga);
}
>>>>>>> backup
