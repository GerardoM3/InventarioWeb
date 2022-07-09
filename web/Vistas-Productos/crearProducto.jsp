<%-- 
    Document   : crearProducto
    Created on : 06-28-2022, 01:01:22 PM
    Author     : ITCA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try{
        HttpSession var_sesion = request.getSession(false);
        String nombres = (String) var_sesion.getAttribute("sessionNombres");
        String user = (String) var_sesion.getAttribute("sessionUsuario");
        String tipo = (String) var_sesion.getAttribute("sessionTipo");
        String correo = (String) var_sesion.getAttribute("sessionEmail");
        
        if(user == null){
            out.print("<center><h2><font color='blue'>Debe de haber iniciado sesión para poder ingresar a esta página.</font><br><hr><font color='blue'>Inténtelo de nuevo</font><hr><h2></center><br>");
            out.print("<center><h2><font color='blue'> Por favor espere...</font><hr><h2></center>");
            
            response.sendRedirect("./");
            
        }else if(user!=null){
%> 
<jsp:useBean id = "producto" scope="session" class= "Model.Producto" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>JSP Page</title>
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        
        <script type="text/javascript">
            function regresar(url){
                location.href = url;
            }
        </script>
        
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf"%>
        <h1>Mantenimiento de Productos</h1>
        <form class="form-horizontal" id="frmProducto" name="frmProducto" action="<%= request.getContextPath()%>/productos?opcion=listar" method="post">
            <input type="hidden" value="<%= producto.getId_producto() %>" name="id_productos">
            
            <div class="form-group">
                <label for="txtNomProducto" class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtNomProducto" value="<%= producto.getNom_producto() %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtStockProducto" class="col-sm-2 control-label">Stock:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtStockProducto" value="<%= producto.getStock() %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtPrecioProducto" class="col-sm-2 control-label">Precio:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtPrecioProducto" value="<%= producto.getPrecio() %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtUnidadMedidaProducto" class="col-sm-2 control-label">Unidad de medida:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtUnidadMedidaProducto" value="<%= producto.getUnidadMedida() %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtEstadoProducto" class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtEstadoProducto" value="<%= producto.getEstado() %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtCategoriaProducto" class="col-sm-2 control-label">Id Categoría:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtCategoriaProducto" value="<%= producto.getCategoria_id()%>">
                </div>
            </div>
                
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar" />
                    <input type="button" class="btn btn-danger btn-sm" onclick="regresar('<%= request.getContextPath() %>/productos?opcion=listar')" name="btnRegresar" value="Regresar" />
                </div>
            </div>
        </form>
        
        
        
        
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf"%>
    </body>
</html>
<%
        }
    }catch(Exception e){
        
    }
%>