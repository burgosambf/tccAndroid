package com.herprogramacion.tcc.ejb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TID01 on 26/10/2016.
 */
public class Pais {
        private String codPais;
        private String descripcion;
        private String abreviatura;
        public List<Pais> paises = new ArrayList<>();

        public String getCodPais() {
            return codPais;
        }

        public void setCodPais(String codPais) {
            this.codPais = codPais;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getAbreviatura() {
            return abreviatura;
        }

        public void setAbreviatura(String abreviatura) {
            this.abreviatura = abreviatura;
        }
}


