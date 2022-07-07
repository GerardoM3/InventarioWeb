<%-- 
    Document   : actualizarCategoria
    Created on : 06-20-2022, 10:10:59 PM
    Author     : Monroy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id = "categoria" scope="session" class= "Model.Categoria" />
<%@page import = "DAO.CategoriaDAO" %>
<%@page import = "DAO.CategoriaDAOImplementar" %>

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
            
            
        %>
        
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf"%>
        <h1>Mantenimiento Categoria</h1>
        <%
            String id_cat_edit = request.getParameter("id_cate");
            String nom_cat_edit = request.getParameter("nombre_cate");
            String est_cat_edit = request.getParameter("estado_cate");
        %>
        <form class="form-horizontal" id="frmCategoria" action="<%= request.getContextPath()%>/categorias?opcion=editar" method="post">
            <div class="form-group">
                <label for="txtIdCategoria" class="col-sm-2 control-label">ID de la Categoria:</label>
                <div class="col-sm-10">
                    <input type="text" name="id1" id="id1" class="form-control" name="txtIdCategoria" value="<%= id_cat_edit %>">
                    <input type="hidden" name="id" id="id" class="form-control" name="txtIdCategoria" value="<%= id_cat_edit %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtNomCategoria" class="col-sm-2 control-label">Nombre de Categoria:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="nombre" id="nombre" value="<%= nom_cat_edit %>">
                </div>
            </div>
                
            <div class="form-group">
                <label for="txtEstCategoria" class="col-sm-2 control-label">Estado de la Categoria:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="estado" id="estado" value="<%= est_cat_edit %>">
                </div>
            </div>
                
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar" />
                    <input type="button" class="btn btn-danger btn-sm" onclick="regresar('<%= request.getContextPath() %>/categorias?opcion=listar')" name="btnRegresar" value="Regresar" />
                </div>
            </div>
        </form>
        
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf"%>
    </body>
</html>
