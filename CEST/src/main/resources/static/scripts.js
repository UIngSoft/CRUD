function filtrar(){
		var sede = document.getElementById('sedeSelected').value;
		location.href='/consulta?tipo=general&sede='+sede+'&bloque&piso';
	}