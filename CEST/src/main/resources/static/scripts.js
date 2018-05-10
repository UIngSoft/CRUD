function filtrar(){
	var sede = document.getElementById('sedeSelected').value;
	alert('Será redirecionado');
	location.href='/consulta?tipo=general&sede='+sede+'&bloque&piso';
}

function validar(){
	
}