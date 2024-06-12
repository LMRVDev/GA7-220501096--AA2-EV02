<%-- 
    Document   : agregarCliente
    Created on : 11/06/2024, 8:11:25 p. m.
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

<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-header bg-info text-white">
            <h5 class="modal-title">Agregar Cliente</h5>
            <button class="clse" data-dismiss="modal">
                <span>&times:</span>
            </button>
        </div>

        <form action="${pageContext.request.contextPath}/ServletControler?accion=insertar"
              method="POST" class="was-validated">
            <div class="modal-body">
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" name="nombre" required />
                    <label for="direccion">Direccion</label>
                    <input type="text" class="form-control" name="direccion" required />
                    <label for="barrio">Barrio</label>
                    <input type="text" class="form-control" name="barrio" required />
                    <label for="ciudad">Ciudad</label>
                    <input type="text" class="form-control" name="ciudad" required />
                    <label for="telefono">Telefono</label>
                    <input type="text" class="form-control" name="telefono" required />
                </div>
                <div class="modal-footer">
                    <button class="btn-primary" type="submit">Guardar Cliente</button>
                </div>
                     
            </div>

        </form>
    </div>

</div>