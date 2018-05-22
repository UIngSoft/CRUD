function BuscarExt(){
	$.post( "/buscarID",
			{id: $('#id').val()},
			function( extintor ) {
				console.log(extintor);
				
				var tabla = '<table id="Extintores" class="table table-bordered table-striped">' +
						'<tr>' +
						'<td><label>Identificador</label></td>' +
						'<td><label>Tipo</label></td>' +
						'<td><label>Tamaño</label></td>' +
						'<td><label>Fecha ultima recarga</label></td>' +
						'<td><label>Fecha de vencimiento</label></td>' +
						'<td><label>Caducidad (años)</label></td>' +
						'<td><label>Estado</label></td>' +
						'<td><label>Acciones</label></td>' +
						'</tr>' +
						'<tr>' +
						'<td id="'+extintor.idelemento+'" text="'+extintor.idelemento+'">'+extintor.idelemento+'</td>' +
						'<td text="'+extintor.fichatecnica.tipo+'">'+extintor.fichatecnica.tipo+'</td>' +
						'<td text="'+extintor.tamanio+'">'+extintor.tamanio+'</td>' +
						'<td text="'+extintor.fechaultimarecarga+'">'+extintor.fechaultimarecarga+'</td>' +
						'<td text="'+extintor.fechavencimiento+'">'+extintor.fechavencimiento+'</td>' +
						'<td text="'+extintor.caducidadanios+'">'+extintor.caducidadanios+'</td>' +
						'<td text="'+extintor.estado+'">'+extintor.estado+'</td>' +
						'<td >' +
						'<button id="'+extintor.elemento.id+'" class="glyphicon glyphicon-pencil btn btn-primary" onclick="enviar(this.id);"></button>' +
						'<button class="glyphicon glyphicon-trash btn btn-danger"></button>' +
						'</td>' +
						'</tr></table>';
				$('#Extintores').html(tabla);
			}
	);
}