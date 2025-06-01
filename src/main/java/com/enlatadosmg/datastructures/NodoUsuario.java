package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Usuario;

public class NodoUsuario {
    public Usuario usuario;
    public NodoUsuario siguiente;

    public NodoUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.siguiente = null;
    }
}
