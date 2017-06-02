package com.herprogramacion.tcc.ejb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TID01 on 27/12/2016.
 */
public class Localidad {
    private String cod_localidad;
    private String descripcion;
    public List<Localidad> localidades = new ArrayList<>();

    public String getCod_localidad() {
        return cod_localidad;
    }

    public void setCod_localidad(String cod_localidad) {
        this.cod_localidad = cod_localidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
