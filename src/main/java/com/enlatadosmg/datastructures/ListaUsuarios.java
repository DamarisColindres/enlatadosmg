package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarios {
    private NodoUsuario cabeza;

    public void agregar(Usuario usuario) {
        NodoUsuario nuevo = new NodoUsuario(usuario);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoUsuario actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public void mostrar() {
        NodoUsuario actual = cabeza;
        while (actual != null) {
            System.out.println("ID: " + actual.usuario.getId() + " - Nombre: " + actual.usuario.getNombre());
            actual = actual.siguiente;
        }
    }

    public String generarReporteDot() {
        StringBuilder dot = new StringBuilder();
        dot.append("digraph G {\n");
        dot.append("rankdir=LR;\n");
        dot.append("node [shape=box];\n");

        NodoUsuario actual = cabeza;
        int contador = 0;
        while (actual != null) {
            dot.append(String.format("n%d [label=\"%s\"];\n", contador, actual.usuario.getNombre()));
            if (actual.siguiente != null) {
                dot.append(String.format("n%d -> n%d;\n", contador, contador + 1));
            }
            actual = actual.siguiente;
            contador++;
        }

        dot.append("}");
        return dot.toString();
    }

    public List<Usuario> obtenerTodos() {
        List<Usuario> lista = new ArrayList<>();
        NodoUsuario actual = cabeza;
        while (actual != null) {
            lista.add(actual.usuario);
            actual = actual.siguiente;
        }
        return lista;
    }

    public Usuario buscarPorId(String id) {
        NodoUsuario actual = cabeza;
        while (actual != null) {
            if (actual.usuario.getId().equals(id)) {
                return actual.usuario;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public boolean eliminar(String id) {
        if (cabeza == null) return false;
        if (cabeza.usuario.getId().equals(id)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        NodoUsuario actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.usuario.getId().equals(id)) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
}
