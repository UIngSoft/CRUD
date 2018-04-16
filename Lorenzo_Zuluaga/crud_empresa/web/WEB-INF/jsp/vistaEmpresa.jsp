<%-- 
    Document   : vistaEmpresa
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
        <title>CRUD EMPRESA</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Empresa</h1>
            </div>
            <div class="row">
                <p>
                    <a href="<c:url value="crearEmpresa.htm" />" class="btn btn-success">Agregar <span class="glyphicon glyphicon-plus"></span></a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        
                        <tr>
                            <th>NIT</th>
                            <th>NOMBRE</th>
                            <th>DIRECCION</th>
                            <th>TELEFONO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.nit}"/></td>
                                <td> <c:out value="${dato.nombre}"/></td>
                                <td> <c:out value="${dato.direccion}"/></td>
                                <td> <c:out value="${dato.telefono}"/></td>
                                <td> 
                                    <a href="<c:url value="editarEmpresa.htm?nit=${dato.nit}" />" class="btn btn-primary"> <span class="glyphicon glyphicon-pencil"></span></a> 
                                    <a href="<c:url value="eliminarEmpresa.htm?nit=${dato.nit}" />" class="btn btn-danger"> <span class="glyphicon glyphicon-trash"></span></a> 
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
        </div>
        
    </body>
</html>
