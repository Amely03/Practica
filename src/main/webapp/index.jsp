<%@page import="java.util.Date"%>
<%@page import="com.emergentesii.Registro"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%

    if (session.getAttribute("lista") == null) {
        ArrayList<Registro> lisaux = new ArrayList<Registro>();
        session.setAttribute("lista", lisaux);
    }
    List<Registro> lista = (ArrayList<Registro>) session.getAttribute("lista");
%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <style>
            tbody{
                color:purple;
            }
        </style>

        <h1 align="center">LISTADO DE INSCRITOS</h1>
        
       <button onclick="window.location.href='MainServlet?action=nuevo'">Nuevo</button> 
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>FECHA</th>
                <th>NOMBRE</th>
                <th>APELLIDOS</th>
                <th>TURNO</th>
                <th>SEMINARIOS</th>
            </tr>
            <%
                for (Registro semi : lista) {
                String fechaFormateada = "";
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    fechaFormateada = dateFormat.format(semi.getFecha());
                } catch (Exception e) {
                    fechaFormateada = "Error en formato de fecha";
                }

            %>
            
            <tr>
                <td><%= semi.getId()%></td>
                <td><%= fechaFormateada%></td>
                <td><%= semi.getNombre()%></td>
                <td><%= semi.getApellidos()%></td>
                <td><%= semi.getTurno()%></td>
                <td><%= semi.getSeminarios()%></td>
                
                <td><a href="MainServlet?action=editar&id=<%= semi.getId()%>">Editar</a></td>
                <td><a href="MainServlet?action=eliminar&id=<%= semi.getId()%>">Eliminar</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
