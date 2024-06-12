<%-- 
    Document   : listadoClientes
    Created on : 11/06/2024, 6:18:29 p. m.
    Author     : lmrv95


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fnt:setLocale value="es_CO"/>

<section id="clientes">
    <div class="container">
        <div class="row">   
            <div class="col-md-9">

                <div class="card">
                    <h4>
                        Listado Clientes
                    </h4>
                </div>
                <table class="table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Ciudad</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cliente" items="${Clientes}" 
                                   varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${cliente.name}</td>
                                <td>${cliente.city}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${cliente.id}">
                                        Editar
                                    </a>
                                </td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>

            </div>

        </div>
    </div>
</section>

<jsp:include page="agregarCliente.jsp" />
