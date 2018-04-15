<%-- 
    Document   : agregar
    Created on : 15/04/2018, 09:41:32 AM
    Author     : PABLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value="resourse/css/b.css"/>">
        <meta charset="UTF-8">
        <title>Agregar Encargado</title>
    </head>

    <!-- navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="inicio.htm">CRUD Encargado</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="buscar.htm">Buscar</a></li>
                    <li><a href="editar.htm">Editar</a></li>
                    <li><a href="mostrar.htm">Ver Encargados</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <body>
        <h1>Agregar Encargado</h1>
        <div class="container">
        <!-- command name es el nombre del objeto que se envia en el encargadocontroller que es un onjeto de tipo encargado -->
        <form:form method="POST" commandName="encargado">
            
            <form:errors path="*" element="div" cssClass="alert alert-danger"/>
            
            <p>
                <form:label path="cedula">Cédula</form:label>
                <form:input path="cedula" cssClass="form-control"/>
                <form:errors path="cedula"/>
            </p>
            <p>
                <form:label path="nombre">Nombre</form:label>
                <form:input path="nombre" cssClass="form-control"/>
            </p>
            <p>
                <form:label path="Apellido">Apellido</form:label>
                <form:input path="Apellido" cssClass="form-control"/>
            </p>
            <p>
                <form:label path="celular">Celular</form:label>
                <form:input path="celular" cssClass="form-control"/>
            </p>
            <p>
                <form:label path="correo">Correo</form:label>
                <form:input path="correo" cssClass="form-control"/>
            </p>
            <p>
                <form:label path="cargo">Cargo</form:label>
                <form:input path="cargo" cssClass="form-control"/>
            </p>
            <p>
                <form:label path="sede">Sede</form:label>
                <form:input path="sede" cssClass="form-control"/>
            </p>
            <p>
                <form:label path="facultad">Facultad</form:label>
                <form:input path="facultad" cssClass="form-control"/>
            </p>
            <p>
                <form:label path="programa">Programa</form:label>
                <form:input path="programa" cssClass="form-control"/>
            </p>
            <input type="submit" value="Enviar" class="btn btn-primary"/>
        </form:form>
            </div>
    </body>

    <!-- implemetancion de los js -->
    <script src="<c:url value="resourse/js/jquery-3.3.1-slim.min.js"/>"></script>
    <script src="<c:url value="resourse/js/bootstrap.min.js"/>" ></script>
</body>
</html>
