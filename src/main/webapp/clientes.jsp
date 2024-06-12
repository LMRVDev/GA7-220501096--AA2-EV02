<%-- 
    Document   : clientes
    Created on : 10/06/2024, 6:54:38 p. m.
    Author     : lmrv95
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        
        <!-- J Query -->
        <!--
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        -->
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        
        <!--popper.js -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.11.8/umd/popper.min.js" integrity="sha512-TPh2Oxlg1zp+kz3nFA0C5vVC6leG/6mm1z9+mA81MI5eaUVqasPLO8Cuk4gMF4gUfP5etR73rgU/8PNMsSesoQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        
        <title>CLIENTES</title>
    </head>
    <body>
        
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp" />
        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp" />
        <jsp:include page="WEB-INF/paginas/comunes/piePagina.jsp" />

        
        <jsp:include page="WEB-INF/paginas/cliente/listadoClientes.jsp" />
        
        <!-- comment 
        <h1>Lista de Clientes</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Ciudad</th>
                    <th>Barrio</th>
                    <th>Teléfono</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${Clientes}">
                    <tr>
                        <td>${cliente.id}</td>
                        <td>${cliente.name}</td>
                        <td>${cliente.address}</td>
                        <td>${cliente.city}</td>
                        <td>${cliente.neighborhood}</td>
                        <td>${cliente.phone_number}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        -->
        
    </body>
</html>
