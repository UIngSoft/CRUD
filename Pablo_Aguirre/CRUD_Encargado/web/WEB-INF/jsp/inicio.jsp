<%-- 
    Document   : inicio
    Created on : 15/04/2018, 09:40:57 AM
    Author     : PABLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="<c:url value="resourse/css/b.css"/>">
        <meta charset="UTF-8">
        <title>Inicioe</title>
    </head>
    <body>
        <h1>CRUD Encargado!</h1>
        
        <input type="submit" value="Agregar" onclick = "location='/CRUD_Encargado/agregar.htm'" class="btn btn-primary"/>
        <input type="submit" value="Buscar" onclick = "location='/CRUD_Encargado/buscar.htm'" class="btn btn-primary"/>
        <input type="submit" value="Editar" onclick = "location='/CRUD_Encargado/editar.htm'" class="btn btn-primary"/>
        <input type="submit" value="Ver Encargados" onclick = "location='/CRUD_Encargado/mostrar.htm'" class="btn btn-primary"/>
        
    </body>
</html>
