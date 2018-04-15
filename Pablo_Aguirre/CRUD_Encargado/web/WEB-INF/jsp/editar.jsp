<%-- 
    Document   : editar
    Created on : 15/04/2018, 09:41:45 AM
    Author     : PABLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value="resourse/css/b.css"/>">
        <meta charset="UTF-8">
        <title>Ediat Encargado</title>
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
                    <li class="active"><a href="agregar.htm">Agregar</a></li>
                    <li><a href="buscar.htm">Buscar</a></li>
                    <li><a href="mostrar.htm">Ver Encargados</a></li>
                </ul>
            </div>
        </div>
    </nav>
    
    <body>
        <h1>Editar Encargado</h1>
        
    </body>
    
    
    <!-- implemetancion de los js -->
    <script src="<c:url value="resourse/js/jquery-3.3.1-slim.min.js"/>"></script>
    <script src="<c:url value="resourse/js/bootstrap.min.js"/>" ></script>
</html>
