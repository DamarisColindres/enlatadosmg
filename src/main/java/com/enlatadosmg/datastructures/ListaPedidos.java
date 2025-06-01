package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Pedido;
import lombok.Getter;

public class ListaPedidos {

    @Getter
    private NodoPedido head;

    public void agregarPedido(Pedido pedido) {
        NodoPedido nuevo = new NodoPedido(pedido, null);
        if (head == null) {
            head = nuevo;
        } else {
            NodoPedido actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }


        public void mostrarPedidos() {
        NodoPedido actual = head;
        while (actual != null) {
            System.out.println(actual.getPedido());
            actual = actual.getSiguiente();
        }
    }


    public NodoPedido getHead() {
        return head;
    }


}
