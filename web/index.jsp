<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <%@include file="WEB-INF/Vistas-Parciales/style_login.jspf" %>
    </head>
    <body>
        
        <div class="container">
            <div class="login-container">
                <h1 class="login-title">Iniciar sesión</h1>
                <form action="index" method="post">
                    <div >
                        Usuario: <input type="text" name="txtuser" class="user-label" placeholder="Ingrese su usuario" />
                    </div>
                    <div >
                        Contraseña: <input type="password" name="txtpass" class="pass-label" placeholder="Ingrese su contraseña" />
                    </div>

                    <div class="div-btn-ingresar">
                        <input class="btn-ingresar" type="submit" value="Ingresar" name="btn_session">
                    </div>

                    <br>
                    <div class="register-link">
                        <a href="#" class="enlace-registrar">Registrarme</a>
                    </div>
                </form>
                
                
                
            </div>
              
                
        </div>
        
        
        <div class="pie_pag">
            <%@include file="WEB-INF/Vistas-Parciales/pie.jspf"%>
        </div>  
        
    </body>
</html>
