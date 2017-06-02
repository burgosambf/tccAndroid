package com.herprogramacion.tcc.ejb;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by TID01 on 28/04/2017.
 */
public class EventoDetalle {
    private List<Horarios> horarios;
    private List<Sectores> sectores;
    private List<ListaPrecios> precios;

    public EventoDetalle() {
    }

    public List<Horarios> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horarios> horarios) {
        this.horarios = horarios;
    }

    public List<Sectores> getSectores() {
        return sectores;
    }

    public void setSectores(List<Sectores> sectores) {
        this.sectores = sectores;
    }

    public List<ListaPrecios> getPrecios() {
        return precios;
    }

    public void setPrecios(List<ListaPrecios> precios) {
        this.precios = precios;
    }

    public class Horarios {
        private String codHorario;
        private String codEvento;
        private String fecInicio;
        private String fecFin;
        private String disponible;

        public Horarios() {
        }

        public String getCodHorario() {
            return codHorario;
        }

        public void setCodHorario(String codHorario) {
            this.codHorario = codHorario;
        }

        public String getCodEvento() {
            return codEvento;
        }

        public void setCodEvento(String codEvento) {
            this.codEvento = codEvento;
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

        public String getDisponible() {
            return disponible;
        }

        public void setDisponible(String disponible) {
            this.disponible = disponible;
        }

    }
    public class ListaPrecios {

        private String codLista;
        private String codEvento;
        private String codSector;

        private BigDecimal valor;
        private String fecInicio;
        private String fecFin;

        public ListaPrecios() {
        }

        public String getCodLista() {
            return codLista;
        }

        public void setCodLista(String codLista) {
            this.codLista = codLista;
        }

        public String getCodEvento() {
            return codEvento;
        }

        public void setCodEvento(String codEvento) {
            this.codEvento = codEvento;
        }

        public String getCodSector() {
            return codSector;
        }

        public void setCodSector(String codSector) {
            this.codSector = codSector;
        }

        public BigDecimal getValor() {
            return valor;
        }

        public void setValor(BigDecimal valor) {
            this.valor = valor;
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

    }
    public class Sectores {

        private String codSector;
        private String codEvento;
        private String descripcion;
        private String ilimitado;
        private BigDecimal cantidad;

        public Sectores() {
        }

        public String getCodSector() {
            return codSector;
        }

        public void setCodSector(String codSector) {
            this.codSector = codSector;
        }

        public String getCodEvento() {
            return codEvento;
        }

        public void setCodEvento(String codEvento) {
            this.codEvento = codEvento;
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

        public BigDecimal getCantidad() {
            return cantidad;
        }

        public void setCantidad(BigDecimal cantidad) {
            this.cantidad = cantidad;
        }

    }


}
