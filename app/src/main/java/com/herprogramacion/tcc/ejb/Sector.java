package com.herprogramacion.tcc.ejb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TID01 on 27/12/2016.
 */
public class Sector {
    private String cod_sector;
    private String cod_evento;
    private String descripcion;
    private String ilimitado;
    private String cantidad;
    public List<Sector> sectores = new ArrayList<>();

    public String getCod_sector() {
        return cod_sector;
    }

    public void setCod_sector(String cod_sector) {
        this.cod_sector = cod_sector;
    }

    public String getCod_evento() {
        return cod_evento;
    }

    public void setCod_evento(String cod_evento) {
        this.cod_evento = cod_evento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIlimitado() {
        return ilimitado;
    }

    public void setIlimitado(String ilimitado) {
        this.ilimitado = ilimitado;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
