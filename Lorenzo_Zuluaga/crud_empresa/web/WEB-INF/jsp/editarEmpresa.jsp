<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Editar Registro</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/vistaEmpresa.htm" />">Empresas</a></li>
                <li class="active">EDITAR</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario</div>
                <div class="panel-body">
                   
                        <form:form method="post" commandName="empresa">
                            <h2>Editar Empresa</h2>
                            
                            <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            
                            <p>
                                <form:label path="nit">Nit</form:label>
                                <form:input path="nit" cssClass="form-control" />
                            </p>
                            <p>
                                <form:label path="nombre">Nombre</form:label>
                                <form:input path="nombre" cssClass="form-control" />
                            </p>
                            <p>
                                <form:label path="direccion">Direccion</form:label>
                                <form:input path="direccion" cssClass="form-control" />
                            </p>
                            <p>
                                <form:label path="telefono">Telefono</form:label>
                                <form:input path="telefono" cssClass="form-control" />
                            </p>
                            
                            <hr />
                            <input type="submit" value="Agregar" class="btn btn-danger" />
                        </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
