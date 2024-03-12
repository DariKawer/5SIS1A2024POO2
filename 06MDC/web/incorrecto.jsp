<%-- 
    Document   : incorrecto
    Created on : 10 mar 2024, 19:24:14
    Author     : ilove
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Mensaje"%>  
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Datos incorrectos</title>
  </head>
  <body>
    <%Mensaje mensajeError = (Mensaje) request.getAttribute("m");  if (mensajeError != null) {%>
        <h1><%= mensajeError.getTexto() %></h1>
    <%} else {%>
        <p>No hay mensaje de error disponible.</p>
    <%}%>
        <br>
        <button><a href="index.html" >Regresar al Menu Principal</a></button>
  </body>
</html>
