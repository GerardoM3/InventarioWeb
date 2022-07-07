<%-- 
    Document   : listarProductos
    Created on : 28-jun-2022, 9:28:32
    Author     : ITCA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@page import = "Model.Producto" %><!-- Importar el modelo -->
<jsp:useBean id = "lista" scope="session" class = "java.util.List"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de inventario</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <div style="width: 900px;">
            <a href="<%=request.getContextPath() %>/productos?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button"> Nuevo Producto</a>
            <h3>Listado de Productos registrados</h3>
            
            <table class="table table-striped">
                <tr>
                    <th>ID</th><th>NOMBRE</th><th>EXISTENCIAS</th><th>PRECIO</th><th>UNIDAD DE MEDIDA</th><th>ESTADO</th><th>ID CATEGORIA</th><th>ACCION</th>
                </tr>
                <%
                    for(int i = 0 ; i < lista.size() ; i++){
                        Producto producto = new Producto();
                        producto = (Producto)lista.get(i);


                %>
                <tr>
                <input name="id_producto_eliminar"  value="<%= producto.getId_producto() %>" />
                    <td name="id_produ"><%= producto.getId_producto() %></td>
                    <td name="nombre_produ"><%= producto.getNom_producto() %></td>
                    <td name="stock_produ"><%= producto.getStock() %></td>
                    <td name="precio_produ"><%= producto.getPrecio() %></td>
                    <td name="unidad_de_medida"><%= producto.getUnidadMedida() %></td>
                    <td name="estado_producto"><%= producto.getEstado() %></td>
                    <td name="id_categoria"><%= producto.getCategoria_id() %></td>
                    <td>
                        <a href="<%=request.getContextPath() %>/productos?opcion=editar&&id_prod=<%= producto.getId_producto() %>&&nom_prod=<%= producto.getNom_producto() %>&&stock=<%= producto.getStock() %>&&precio=<%= producto.getPrecio() %>&&unidadMedida=<%= producto.getUnidadMedida() %>&&estado=<%= producto.getEstado() %>&&id_cat=<%= producto.getCategoria_id() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button"> Editar</a>
                        <a href="<%= request.getContextPath()%>/productos?opcion=eliminar&&id_producto_eliminar=<%= producto.getId_producto() %>" id="modal-381168" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"> Eliminar</a>
                        
                        <%--<%= request.getContextPath()%>/categorias?opcion=eliminar&&id_categoria_eliminar=<%= categoria.getId_categoria() %>--%>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            
        </div>
        
        
        
        
        
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>
