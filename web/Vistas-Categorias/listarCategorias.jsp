<%-- 
    Document   : listarCategorias
    Created on : 14-jun-2022, 15:28:40
    Author     : ITCA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Model.Categoria" %><!-- Importar el modelo -->
<%@page import = "DAO.CategoriaDAOImplementar" %>
<%@page import = "DAO.CategoriaDAO" %>
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
            <button id="btnnuevo" > Botón</button>
            
            
            
            <h3>Listado de Categorías Registradas</h3>
            
            <table class="table table-striped">
                <tr>
                    <th>ID</th><th>NOMBRE</th><th>ESTADO</th><th>ACCION</th>
                </tr>
                <%
                    CategoriaDAO editar = new CategoriaDAOImplementar();
                    for(int i = 0 ; i < lista.size() ; i++){
                        Categoria categoria = new Categoria();
                        
                        categoria = (Categoria)lista.get(i);
                        System.out.println(lista.lastIndexOf(categoria));
                        
                %>
                <tr>
                <input name="id_categoria_eliminar"  value="<%= categoria.getId_categoria() %>" />
                    <td name="id_cate"><%= categoria.getId_categoria() %></td>
                    <td name="nombre_cate"><%= categoria.getNom_categoria() %></td>
                    <td name="estado_cate"><%=categoria.getEstado_categoria() %></td>
                    <td>
                        <a href="<%=request.getContextPath() %>/categorias?opcion=editar&&id_cate=<%= categoria.getId_categoria()%>&&nombre_cate=<%= categoria.getNom_categoria()%>&&estado_cate=<%= categoria.getEstado_categoria()%>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button"> Editar</a>
                        <a href="<%= request.getContextPath()%>/categorias?opcion=eliminar&&id_categoria_eliminar=<%= categoria.getId_categoria() %>" type="button" name='btneliminar' id='btneliminar' class="btn btn-primary btn-sm glyphicon glyphicon-remove" data-toggle="modal" data-target="#myModal"> Eliminar</a>
                        <%--<%= request.getContextPath()%>/categorias?opcion=eliminar&&id_categoria_eliminar=<%= categoria.getId_categoria() %>--%>
                        <!-- Modal -->
                        <div class="modal fade" role="dialog" id="myModal" tabindex="-1" aria-labelledby="myModal" aria-hidden="true">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">

                                <h5 class="modal-title" id="myModalLabel">Eliminar registro</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              </div>
                              <div class="modal-body">
                                <h2>¿Está seguro que desea eliminar la categoría seleccionada?</h2>
                                <h3>(Al confirmar, las acciones NO se pueden deshacer)</h3>
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <a type="button" role="button" class="btn btn-danger" href="<%= request.getContextPath()%>/categorias?opcion=eliminar&&id_categoria_eliminar=<%= categoria.getId_categoria() %>">CONFIRMAR</a>
                              </div>
                            </div>
                          </div>
                        </div>
                        
                        
                    </td>
                </tr>
                <%
                    }
                %>
                
                <%
                    lista.clear();
                %>
            </table>
            
            
            
        </div>
                  
                  
                  
        <!-- Button trigger modal 
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Launch demo modal
</button>

<!-- Modal 
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
</div>-->
        <%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
        
        
        
        <script src='js/codigo.js'></script>
    </body>
</html>
