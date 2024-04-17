package com.emergentesii;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
      
        String action = request.getParameter("action") != null ? request.getParameter("action") : "view"; 
 
        switch (action) {
            case "view":
                response.sendRedirect("index.jsp");
                break;
            case "nuevo":
                Registro s = new Registro();
                request.setAttribute("seminarios", s);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));

                HttpSession sesion = request.getSession();
                List<Registro> lista = (ArrayList<Registro>) sesion.getAttribute("lista");
                Registro editarSemi = new Registro();
                for (Registro item : lista) {
                    if (item.getId() == idEditar) {
                        editarSemi = item;
                        break;
                    }
                }

                request.setAttribute("seminarios", editarSemi);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar"://cuando haga clic en eliminar
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                HttpSession sesion1 = request.getSession();
                List<Registro> lista1 = (ArrayList<Registro>) sesion1.getAttribute("lista");

                Iterator<Registro> iterator = lista1.iterator();
                while (iterator.hasNext()) {
                    Registro item = iterator.next();
                    if (item.getId() == idEliminar) {
                        iterator.remove();
                        break;
                    }
                }
                response.sendRedirect("index.jsp");
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int id = Integer.parseInt((request.getParameter("id")));
        String fechaString = request.getParameter("Fecha");
        String nombre = request.getParameter("Nombre");
        String apellidos = request.getParameter("Apellidos");
        String turno = request.getParameter("Turno");
        String[] seminariosSeleccionados = request.getParameterValues("seminarios");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = dateFormat.parse(fechaString);
            // Formatear la fecha en el formato deseado
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = dateFormat2.format(fecha);
            // Ahora pasamos la fecha formateada al JSP
            request.setAttribute("fechaFormateada", fechaFormateada);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String seminariosConcatenados = "";
        if (seminariosSeleccionados != null && seminariosSeleccionados.length > 0) {
            seminariosConcatenados = String.join(", ", seminariosSeleccionados);
        }
       
        HttpSession ses = request.getSession();
        List<Registro> lista = (ArrayList<Registro>) ses.getAttribute("lista");

        if (id == 0) {
            //nuevo Registro
            Registro s = new Registro();
            int idNuevo = obtenerNuevoId(lista);
            s.setId(idNuevo);
            s.setFecha(fecha);
            s.setNombre(nombre);
            s.setApellidos(apellidos);
            s.setTurno(turno);
            s.setSeminarios(seminariosConcatenados);

            //adicionamos elemento
            lista.add(s);
        } else {
            for (Registro item : lista) {
                if (item.getId() == id) {
                    item.setFecha(fecha);
                    item.setNombre(nombre);
                    item.setApellidos(apellidos);
                    item.setTurno(turno);
                    item.setSeminarios(seminariosConcatenados);

                    break;
                }
            }
        }

        //almacenar los datos en un objeto de tipo calificacion
        response.sendRedirect("index.jsp");

    }

    private int obtenerNuevoId(List<Registro> lista) {
        int nuevoId = 1;

        for (Registro item : lista) {
            if (item.getId() >= nuevoId) {
                nuevoId = item.getId() + 1;
            }
        }
        return nuevoId;
    }
}


