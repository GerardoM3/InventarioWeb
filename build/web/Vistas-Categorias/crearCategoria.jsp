<%-- 
    Document   : crearCategoria
    Created on : 06-17-2022, 10:06:25 PM
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
<jsp:useBean id = "categoria" scope="session" class= "Model.Categoria" />
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
    </head>
    <body>
        <%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf"%>
        <h1>Mantenimiento Categorías</h1>
        <form class="form-horizontal" id="frmCategoria" name="frmCategoria" action="<%= request.getContextPath()%>/categorias?opcion=crear" method="post">
            <input type="hidden" value="<%= categoria.getId_categoria() %>" name="id_categoria">
            <div class="form-group">
                <label for="txtNomCategoria" class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtNomCategoria" value="<%= categoria.getNom_categoria() %>">
                </div>
            </div>
            <div class="form-group">
                <label for="txtEstadoCategoria" class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="txtEstadoCategoria" value="<%= categoria.getEstado_categoria() %>">
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
<%
        }
    }catch(Exception e){
        
    }
%>