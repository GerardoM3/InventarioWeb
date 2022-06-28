<%-- 
    Document   : listarCategorias
    Created on : 14-jun-2022, 15:28:40
    Author     : ITCA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Model.Categoria" %><!-- Importar el modelo -->
<jsp:useBean id = "lista" scope="session" class = "java.util.List"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de inventario</title>
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <div style="width: 600px;">
            <a href="<%=request.getContextPath() %>/categorias?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button"> Nueva Categoría</a>
            <h3>Listado de Categorías Registradas</h3>
            
            <table class="table table-striped">
                <tr>
                    <th>ID</th><th>NOMBRE</th><th>ESTADO</th><th>ACCION</th>
                </tr>
                <%
                    for(int i = 0 ; i < lista.size() ; i++){
                        Categoria categoria = new Categoria();
                        categoria = (Categoria)lista.get(i);


                %>
                <tr>
                <input name="id_categoria_eliminar"  value="<%= categoria.getId_categoria() %>" />
                    <td name="id_cate"><%= categoria.getId_categoria() %></td>
                    <td name="nombre_cate"><%= categoria.getNom_categoria() %></td>
                    <td name="estado_cate"><%= categoria.getEstado_categoria() %></td>
                    <td>
                        <a href="<%=request.getContextPath() %>/categorias?opcion=editar" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button"> Editar</a>
                        <button id="modal-381168" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"> Eliminar</button>
                        
                        <%--<%= request.getContextPath()%>/categorias?opcion=eliminar&&id_categoria_eliminar=<%= categoria.getId_categoria() %>--%>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <!-- Modal -->
            <div class="modal fade" id="modal-container-381168" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Eliminar registro</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                      ID Producto: <%= request.getParameter("id_categoria_eliminar") %>
                    Nombre de la categoria: <%= request.getParameter("nombre_cate") %>
                    Estado: <%= request.getParameter("estado_cate") %>

                    <h2>¿Está seguro que desea eliminar la categoría seleccionada?</h2>
                    <h3>(Al confirmar, las acciones NO se pueden deshacer)</h3>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-warning" href="<%= request.getContextPath()%>/categorias?opcion=eliminar&&id_categoria_eliminar=<%= request.getParameter("id_categoria_eliminar") %>">CONFIRMAR</button>
                  </div>
                </div>
              </div>
            </div>
            
        </div>
                  
                  
                  
        <!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>
