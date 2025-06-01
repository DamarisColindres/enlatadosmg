package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Producto;
import lombok.Getter;

@Getter
public class ListaProductos {
    private NodoProductoLista head;

    public void agregarProducto(Producto producto) {
        NodoProductoLista nuevo = new NodoProductoLista(producto, null);
        if (head == null) {
            head = nuevo;
        } else {
            NodoProductoLista actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    public int contarNodos() {
        int contador = 0;
        NodoProductoLista actual = head;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NodoProductoLista actual = head;
        while (actual != null) {
            sb.append(actual.getProducto().toString()).append("\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
}
