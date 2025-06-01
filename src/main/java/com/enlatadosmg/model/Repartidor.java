package com.enlatadosmg.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Repartidor {
    private String cui;
    private String nombre;
    private String apellido;
    private String tipoLicencia;
    private String telefono;

    public Repartidor(String cui, String nombre, String apellido, String tipoLicencia, String telefono) {
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoLicencia = tipoLicencia;
        this.telefono = telefono;
    }
}
