package com.enlatadosmg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private String cui;       // clave para AVL
    private String nombre;
    private String apellido;
    private String telefono;
}