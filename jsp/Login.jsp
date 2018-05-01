<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
       <div class="container" style="text-align: center">
		<div class="row col-xs-5">
			<img src="logo.jpg">
		</div>

		<div class="row ">
			<h1>Iniciar Sesion</h1>
		</div>

		<div class="row col-xs-4" style="margin-left: +380px">
			<form action="admin.html">
				<div class="form-group ">
					<label for="email">Usuario</label>
					<input type="email" class="form-control" id="email">
				</div>
				<div class="form-group">
					<label for="pwd">Contraseña</label>
					<input type="password" class="form-control" id="pwd">
				</div>
				<div class="checkbox">
					<label><input type="checkbox"> Recordar </label>
				</div>
				<button type="submit" class="btn btn-primary">Iniciar Sesion</button>
			</form>
		</div>
	</div>
    </body>
</html>
