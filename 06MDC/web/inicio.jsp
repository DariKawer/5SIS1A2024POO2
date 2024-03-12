<%-- 
    Document   : inicio
    Created on : 9 mar 2024, 15:38:43
    Author     : ilove
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Alumno"%>
<%@page import="Controlador.AccionesAlumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Alumnos</title>
    </head>
    <body>
        <h1>Lista General de Alumnos a presentar Extraordinarios</h1>
        <br><br>
        <a href="registro.jsp" >Registrar Alumno a Extraordinario</a>
        <div class="container" >
            <br>
            <table border="2" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Edad</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        //tenemos que obtener la lista de los alumnos
                        List<Alumno> lista = AccionesAlumno.getAllAlumnos();
                        //tenemos que recorrer toda la lista
                        for(Alumno alu : lista){
                        //aqui es donde yo debo de imprimir los datos de la tabla
                    %>    
                    <tr>
                        <td> <%=alu.getIdAlumno()%>  </td>
                        <td> <%=alu.getNom_alu()%>  </td>
                        <td> <%=alu.getAppat_alu()%>  </td>
                        <td> <%=alu.getApmat_alu()%>  </td>
                        <td> <%=alu.getEdad_alu()%>  </td>
                        <td> <a href="editaralumno.jsp?id=<%=alu.getIdAlumno()%>" >
                                <img src="ICONOEditar.png" width="50" height="50"></a></td>
                        <td> <a href="eliminaralumno?id=<%=alu.getIdAlumno()%>" >
                                <img src="ICONOEliminar.png" width="50" height="50"></a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <br><br>
            <a href="index.html" >Regresar a Inicio Sesion</a>
        </div>
    </body>
</html>