<%-- 
    Document   : vistaUbicacion
    Created on : Apr 14, 2018, 2:42:35 AM
    Author     : arch-linux
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <title>Consultar Extintor</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>.:: EXTINTORES ::.</h1>
            </div>
            <div class="row">
                <p>
                    <a href="<c:url value="crearUbicacion.htm" />" class="btn btn-success">Agregar <span class="glyphicon glyphicon-plus"></span></a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        
                        <tr>
                            <th>ID ELEMENTO</th>
                            <th>TIPO</th>
                            <th>TAMANIO</th>
                            <th>FECHA INSTALACION</th>
                            <th>FECHA RECARGA</th>
                            <th>FECHA VENCIMIENTO</th>
                            <th>ESTADO</th>
                            <th>CADUCIDAD ANIOS</th>
                            <th>OBSERVACION</th>
                            <th>DOCUMENTO ENCARGADO</th>
                            <th>UBICACION</th>
                            <th>OPC</th>
                        </tr>
                        <tr>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th> </th>
                            <th> </th>
                            <th> </th>
                            <th></th>
                            <th> </th>
                            <th></th>
                            <th> </th>
                            <th></th>
                            <th> 
                                <a href="<c:url value="" />" class="btn btn-primary"> <span class="glyphicon glyphicon-pencil"></span></a> 
                                <a href="<c:url value="" />" class="btn btn-danger"> <span class="glyphicon glyphicon-trash"></span></a> 
                            </th>
                        </tr>
                    </thead>
                    
                </table>
            </div>
        </div>
    </body>
</html>
