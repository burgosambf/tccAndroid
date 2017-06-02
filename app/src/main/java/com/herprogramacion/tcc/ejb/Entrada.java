package com.herprogramacion.tcc.ejb;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by TID01 on 27/12/2016.
 */
public class Entrada {

    private String cod_entrada;
    private String cod_evento;
    private String cod_sector;
    private String cod_cliente;
    private String cod_horario;
    private String cod_lista;
    private String descripcion;
    private String numero;
    private String estado;
    public  List<Entrada> entradas = new ArrayList<>();

    public String getCod_entrada() {
        return cod_entrada;
    }

    public void setCod_entrada(String cod_entrada) {
        this.cod_entrada = cod_entrada;
    }

    public String getCod_evento() {
        return cod_evento;
    }

    public void setCod_evento(String cod_evento) {
        this.cod_evento = cod_evento;
    }

    public String getCod_sector() {
        return cod_sector;
    }

    public void setCod_sector(String cod_sector) {
        this.cod_sector = cod_sector;
    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getCod_horario() {
        return cod_horario;
    }

    public void setCod_horario(String cod_horario) {
        this.cod_horario = cod_horario;
    }

    public String getCod_lista() {
        return cod_lista;
    }

    public void setCod_lista(String cod_lista) {
        this.cod_lista = cod_lista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
