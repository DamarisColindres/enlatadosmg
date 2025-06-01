package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Cliente;

public class NodoCliente {
    private Cliente cliente; // <- este campo es privado
    public NodoCliente izquierdo;
    public NodoCliente derecho;
    public int altura;

    public NodoCliente(Cliente cliente) {
        this.cliente = cliente;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1;
    }

        public Cliente getCliente() {
             return cliente;
         }


         public void setCliente(Cliente cliente) {
             this.cliente = cliente;
         }
}
