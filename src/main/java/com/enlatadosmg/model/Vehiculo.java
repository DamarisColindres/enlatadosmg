package com.enlatadosmg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String anio;
    private String tipoTransmision;
}
