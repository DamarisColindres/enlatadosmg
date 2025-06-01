package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ArbolAVLClientes {
    private NodoCliente raiz;

    public ArbolAVLClientes() {
        raiz = null;
    }

    private int altura(NodoCliente n) {
        return n == null ? 0 : n.altura;
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private NodoCliente rotacionDerecha(NodoCliente y) {
        NodoCliente x = y.izquierdo;
        NodoCliente T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    private NodoCliente rotacionIzquierda(NodoCliente x) {
        NodoCliente y = x.derecho;
        NodoCliente T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }

    private int getBalance(NodoCliente n) {
        return (n == null) ? 0 : altura(n.izquierdo) - altura(n.derecho);
    }

    public void insertar(Cliente cliente) {
        raiz = insertarRec(raiz, cliente);
    }

    private NodoCliente insertarRec(NodoCliente nodo, Cliente cliente) {
        if (nodo == null)
            return new NodoCliente(cliente);

        if (cliente.getCui().compareTo(nodo.getCliente().getCui()) < 0)
            nodo.izquierdo = insertarRec(nodo.izquierdo, cliente);
        else if (cliente.getCui().compareTo(nodo.getCliente().getCui()) > 0)
            nodo.derecho = insertarRec(nodo.derecho, cliente);
        else
            return nodo;

        nodo.altura = 1 + max(altura(nodo.izquierdo), altura(nodo.derecho));

        int balance = getBalance(nodo);

        if (balance > 1 && cliente.getCui().compareTo(nodo.izquierdo.getCliente().getCui()) < 0)
            return rotacionDerecha(nodo);

        if (balance < -1 && cliente.getCui().compareTo(nodo.derecho.getCliente().getCui()) > 0)
            return rotacionIzquierda(nodo);

        if (balance > 1 && cliente.getCui().compareTo(nodo.izquierdo.getCliente().getCui()) > 0) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && cliente.getCui().compareTo(nodo.derecho.getCliente().getCui()) < 0) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(NodoCliente nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierdo);
            System.out.println(nodo.getCliente());
            inOrdenRec(nodo.derecho);
        }
    }

    public void inOrdenLista(List<Cliente> lista) {
        inOrdenListaRec(raiz, lista);
    }

    private void inOrdenListaRec(NodoCliente nodo, List<Cliente> lista) {
        if (nodo != null) {
            inOrdenListaRec(nodo.izquierdo, lista);
            lista.add(nodo.getCliente());
            inOrdenListaRec(nodo.derecho, lista);
        }
    }

    public Cliente buscar(String cui) {
        return buscarRec(raiz, cui);
    }

    private Cliente buscarRec(NodoCliente nodo, String cui) {
        if (nodo == null) return null;

        if (cui.equals(nodo.getCliente().getCui())) return nodo.getCliente();

        if (cui.compareTo(nodo.getCliente().getCui()) < 0)
            return buscarRec(nodo.izquierdo, cui);

        return buscarRec(nodo.derecho, cui);
    }

    public boolean eliminar(String cui) {
        raiz = eliminarRec(raiz, cui);
        return true;
    }

    private NodoCliente eliminarRec(NodoCliente nodo, String cui) {
        if (nodo == null) return null;

        if (cui.compareTo(nodo.getCliente().getCui()) < 0) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, cui);
        } else if (cui.compareTo(nodo.getCliente().getCui()) > 0) {
            nodo.derecho = eliminarRec(nodo.derecho, cui);
        } else {
            if (nodo.izquierdo == null) return nodo.derecho;
            else if (nodo.derecho == null) return nodo.izquierdo;

            NodoCliente sucesor = minValorNodo(nodo.derecho);
            nodo.setCliente(sucesor.getCliente());
            nodo.derecho = eliminarRec(nodo.derecho, sucesor.getCliente().getCui());
        }

        nodo.altura = 1 + max(altura(nodo.izquierdo), altura(nodo.derecho));

        int balance = getBalance(nodo);

        if (balance > 1 && getBalance(nodo.izquierdo) >= 0)
            return rotacionDerecha(nodo);

        if (balance > 1 && getBalance(nodo.izquierdo) < 0) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && getBalance(nodo.derecho) <= 0)
            return rotacionIzquierda(nodo);

        if (balance < -1 && getBalance(nodo.derecho) > 0) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    private NodoCliente minValorNodo(NodoCliente nodo) {
        NodoCliente actual = nodo;
        while (actual.izquierdo != null)
            actual = actual.izquierdo;
        return actual;
    }

    public boolean actualizarCliente(String cui, String nuevoNombre, String nuevoApellido, String nuevoTelefono) {
        NodoCliente nodo = buscarNodo(raiz, cui);
        if (nodo == null) return false;

        nodo.getCliente().setNombre(nuevoNombre);
        nodo.getCliente().setApellido(nuevoApellido);
        nodo.getCliente().setTelefono(nuevoTelefono);
        return true;
    }

    private NodoCliente buscarNodo(NodoCliente nodo, String cui) {
        if (nodo == null) return null;

        if (cui.equals(nodo.getCliente().getCui()))
            return nodo;

        if (cui.compareTo(nodo.getCliente().getCui()) < 0)
            return buscarNodo(nodo.izquierdo, cui);

        return buscarNodo(nodo.derecho, cui);
    }

    public List<Cliente> obtenerClientesEnOrden() {
        List<Cliente> lista = new ArrayList<>();
        inOrdenLista(raiz, lista);
        return lista;
    }

    private void inOrdenLista(NodoCliente nodo, List<Cliente> lista) {
        if (nodo != null) {
            inOrdenLista(nodo.izquierdo, lista);
            lista.add(nodo.getCliente());
            inOrdenLista(nodo.derecho, lista);
        }
    }

    public NodoCliente getRaiz() {
        return raiz;
    }
}
