package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodoProductoLista {
    private Producto producto;
    private NodoProductoLista siguiente;
}
