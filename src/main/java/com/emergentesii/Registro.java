package com.emergentesii;

import java.util.Date;

public class Registro {
    private int id;
    private Date Fecha;
    private String Nombre;
    private String Apellidos;
    private String Turno;
    private String Seminarios;

    public Registro() {
        this.id = 0;
        this.Fecha = new Date();
        this.Nombre = "";
        this.Apellidos = "";
        this.Turno = "";
        this.Seminarios = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
    }

    public String getSeminarios() {
        return Seminarios;
    }

    public void setSeminarios(String Seminarios) {
        this.Seminarios = Seminarios;
    }

    @Override
    public String toString() {
        return "Registro{" + "id=" + id + ", Fecha=" + Fecha
                + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Turno=" + Turno + ","
                + " Seminarios=" + Seminarios + '}';
    }
}
