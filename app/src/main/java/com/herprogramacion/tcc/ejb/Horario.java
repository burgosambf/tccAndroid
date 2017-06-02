package com.herprogramacion.tcc.ejb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TID01 on 27/12/2016.
 */
public class Horario {
    private String cod_horario;
    private String cod_evento;
    private String fecha_inicio;
    private String fecha_fin;
    private String disponible;
    public List<Horario> horarios = new ArrayList<>();

    public String getCod_horario() {
        return cod_horario;
    }

    public void setCod_horario(String cod_horario) {
        this.cod_horario = cod_horario;
    }

    public String getCod_evento() {
        return cod_evento;
    }

    public void setCod_evento(String cod_evento) {
        this.cod_evento = cod_evento;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }
}
