package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodoProducto {
    private Producto producto;
    private NodoProducto izquierdo;
    private NodoProducto derecho;
    private int altura;

    public NodoProducto(Producto producto) {
        this.producto = producto;
        this.altura = 1;
    }

}
