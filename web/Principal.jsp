<%-- 
    Document   : Principal
    Created on : 07-05-2022, 11:02:19 PM
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
        <title>Inventario</title>
        <%@include file="/WEB-INF/Vistas-Parciales/css-js.jspf" %>
        
    </head>
    <body>
        
        <%@include file="/WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        
        <h1>Bienvenido</h1>
        
        
        
        
        
        <%@include file="/WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

<%
        }
    }catch(Exception e){
        
    }
%>
