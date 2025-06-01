package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Repartidor;
import lombok.Getter;

public class ColaRepartidores {
    @Getter
    private NodoRepartidor frente;
    private NodoRepartidor fin;
    private int size;

    public ColaRepartidores() {
        frente = null;
        fin = null;
        size = 0;
    }

    public void encolar(Repartidor repartidor) {
        NodoRepartidor nuevo = new NodoRepartidor(repartidor);
        if (fin == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        size++;
    }

    public Repartidor desencolar() {
        if (frente == null) {
            return null;
        }
        Repartidor rep = frente.repartidor;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        size--;
        return rep;
    }

    public Repartidor peek() {
        if (frente == null) return null;
        return frente.repartidor;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int size() {
        return size;
    }


    public void mostrar() {
        NodoRepartidor actual = frente;
        System.out.println("Cola de repartidores:");
        while (actual != null) {
            System.out.println(actual.repartidor);
            actual = actual.siguiente;
        }
    }
}