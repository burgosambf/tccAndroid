package com.herprogramacion.tcc.ejb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TID01 on 27/12/2016.
 */
public class ListaPrecio {
    private String cod_lista;
    private String sector;
    private String evento;
    private BigDecimal valor;
    public List<ListaPrecio> listaPrecios = new ArrayList<>();

    public String getCod_lista() {
        return cod_lista;
    }

    public void setCod_lista(String cod_lista) {
        this.cod_lista = cod_lista;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
