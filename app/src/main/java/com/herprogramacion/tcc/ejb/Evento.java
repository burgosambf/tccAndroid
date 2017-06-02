package com.herprogramacion.tcc.ejb;

/**
 * Created by TID01 on 27/12/2016.
 */
public class Evento {
    private String codEvento;
    private String prov;
    private String tipoEvDesc;
    private String desceve;
    private String nomeven;
    private String fecInicio;
    private String fecFin;
    private String estado;
    //public List<Evento> eventos = new ArrayList<>();


    public String getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(String codEvento) {
        this.codEvento = codEvento;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getTipoEvDesc() {
        return tipoEvDesc;
    }

    public void setTipoEvDesc(String tipoEv) {
        this.tipoEvDesc = tipoEv;
    }

    public String getDesceve() {
        return desceve;
    }

    public void setDesceve(String desceve) {
        this.desceve = desceve;
    }

    public String getNomeven() {
        return nomeven;
    }

    public void setNomeven(String nomeven) {
        this.nomeven = nomeven;
    }

    public String getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(String fecInicio) {
        this.fecInicio = fecInicio;
    }

    public String getFecFin() {
        return fecFin;
    }

    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
