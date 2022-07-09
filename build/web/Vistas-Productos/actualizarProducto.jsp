<%-- 
    Document   : actualizarProducto
    Created on : 06-30-2022, 05:44:59 AM
    Author     : Monroy
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        <script type="text/javascript">
            function regresar(url){
                location.href = url;
            }
        </script>
        <%
            String id_p_edit = request.getParameter("id_prod");
            String nom_p_edit = request.getParameter("nom_prod");
            String stock_p_edit = request.getParameter("stock");
            String precio_p_edit = request.getParameter("precio");
            String unidadM_p_edit = request.getParameter("unidadMedida");
            String estado_p_edit = request.getParameter("estado");
            String idC_p_edit = request.getParameter("id_cat");
            
            System.out.println(id_p_edit);
            System.out.println(nom_p_edit);
            System.out.println(stock_p_edit);
            System.out.println(precio_p_edit);
            System.out.println(unidadM_p_edit);
            System.out.println(estado_p_edit);
            System.out.println(idC_p_edit);
            
        %>
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf"%>
        
        <h1>Mantenimiento Productos</h1>
        
        <form class="form-horizontal" id="frmCategoria" action="<%= request.getContextPath()%>/productos?opcion=editar" method="post">
            <div class="form-group">
                <label for="txtIdCategoria" class="col-sm-2 control-label">ID del Producto:</label>
                <div class="col-sm-10">
                    <input type="text" name="id1" id="id1" class="form-control" name="txtIdCategoria" value="<%= id_p_edit %>">
                    <input type="hidden" name="id" id="id" class="form-control" name="txtIdCategoria" value="<%= id_p_edit %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtNomCategoria" class="col-sm-2 control-label">Nombre del Producto:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="nombre" id="nombre" value="<%= nom_p_edit %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtStockCategoria" class="col-sm-2 control-label">Existencias del Producto:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="stock" id="stock" value="<%= stock_p_edit %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtPrecioCategoria" class="col-sm-2 control-label">Precio del Producto:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="precio" id="precio" value="<%= precio_p_edit %>">
                </div>
            </div>
            
            <div class="form-group">
                <label for="txtUnidadMedidaCategoria" class="col-sm-2 control-label">Unidad de medida:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="unidad_de_medida" id="unidad_de_medida" value="<%= unidadM_p_edit %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtEstCategoria" class="col-sm-2 control-label">Estado del Producto:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="estado" id="estado" value="<%= estado_p_edit %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtIdCategoria" class="col-sm-2 control-label">Categoria del Producto:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="id_categoria" id="id_categoria" value="<%= idC_p_edit %>">
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