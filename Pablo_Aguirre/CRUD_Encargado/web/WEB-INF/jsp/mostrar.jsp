<%-- 
    Document   : mostrar
    Created on : 15/04/2018, 05:11:28 PM
    Author     : PABLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value="resourse/css/b.css"/>">
        <meta charset="UTF-8">
        <title>JSP Page</title>
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
                    <li><a href="editar.htm">Editar</a></li>
                    
                </ul>
            </div>
        </div>
    </nav>

    <body>
        <h1>Mostrar Encargados</h1>
        <div class="container">
            <div class="row">
                
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th> Cedula </th>
                            <th> Nombre </th>
                            <th> Apellido </th>
                            <th> Celular </th>
                            <th> Correo </th>
                            <th> Cargo </th>
                            <th> Sede </th>
                            <th> Facultad </th>
                            <th> Programa </th>
                        </tr>  
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato"> 
                            <tr>
                                <td> <c:out value="${dato.cedula}"/> </td>
                                <td> <c:out value="${dato.nombre}"/> </td>
                                <td> <c:out value="${dato.apellido}"/> </td>
                                <td> <c:out value="${dato.celular}"/> </td>
                                <td> <c:out value="${dato.correo}"/> </td>
                                <td> <c:out value="${dato.cargo}"/> </td>
                                <td> <c:out value="${dato.sede}"/> </td>
                                <td> <c:out value="${dato.facultad}"/> </td>
                                <td> <c:out value="${dato.programa}"/> </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    
    <!-- implemetancion de los js -->
    <script src="<c:url value="resourse/js/jquery-3.3.1-slim.min.js"/>"></script>
    <script src="<c:url value="resourse/js/bootstrap.min.js"/>" ></script>
</html>
