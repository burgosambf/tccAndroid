package com.herprogramacion.tcc.pager.model;

/**
 * Created by abel.burgos on 29/05/2017.
 */
public class Datos {
    private String codigo;
    private String detalle;

    public Datos() {
    }

    public Datos(String codigo, String detalle) {
        this.codigo = codigo;
        this.detalle = detalle;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
