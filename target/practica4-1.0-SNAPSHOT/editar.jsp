<%@page import="com.emergentesii.Registro"%>

<%
    Registro semi = (Registro) request.getAttribute("seminarios");
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

        <h1 align="center">REGISTRO DE SEMINARIOS</h1>

        <form action="MainServlet" method="post">
            <input type="hidden" name="id" value="<%= semi.getId()%>">
            <div style="display: flex;">
                
                <div style="border: 4px solid #B695C0; padding: 20px; width: 50%;">
                    <h2>Datos</h2>
                    <table border="0">
                        <tr>
                            <td>Fecha</td>
                            <td><input type="date" name="Fecha" value="<%= request.getAttribute("fechaFormateada")%>"></td>
                        </tr>
                        <tr>
                            <td>Nombre</td>
                            <td><input type="text" name="Nombre" value="<%= semi.getNombre()%>"></td>
                        </tr>
                        <tr>
                            <td>Apellidos</td>
                            <td><input type="text" name="Apellidos" value="<%= semi.getApellidos()%>"></td>
                        </tr>
                        <tr>
                            <td>Turno</td>
                            <td>
                                <input type="radio" name="Turno" value="Mañana" <%= (semi.getTurno().equals("MAÑANA")) ? "checked" : ""%>>Mañana
                                <input type="radio" name="Turno" value="Tarde" <%= (semi.getTurno().equals("TARDE")) ? "checked" : ""%>>Tarde
                                <input type="radio" name="Turno" value="Noche" <%= (semi.getTurno().equals("NOCHE")) ? "checked" : ""%>>Noche
                            </td>
                        </tr>
                    </table>
                </div>
                <div style="border: 4px solid #B695C0; padding: 20px; width: 50%;">
                    <h2>Seminarios Disponibles</h2>
                    <table border="0">
                        <tr>
                            <td>
                                <input type="checkbox" name="seminarios" value="Inteligencia Artificial"> Inteligencia Artificial<br>
                                <input type="checkbox" name="seminarios" value="Machine Learning"> Machine Learning<br>
                                <input type="checkbox" name="seminarios" value="Simulacion con Arena"> Simulación con Arena<br>
                                <input type="checkbox" name="seminarios" value="Robotica Educativa"> Robótica Educativa<br>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <center>
                <button type="submit" class="boton-rectangular">Enviar registro</button>
            </center>
        </form>
    </body>
</html>
