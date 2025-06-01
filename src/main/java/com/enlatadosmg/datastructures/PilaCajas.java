package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Caja;
import lombok.Getter;

@Getter
public class PilaCajas {
    private NodoCaja tope;

    public PilaCajas() {
        this.tope = null;
    }

    public void push(Caja caja) {
        NodoCaja nuevo = new NodoCaja(caja);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

    public Caja pop() {
        if (tope == null) return null;
        Caja caja = tope.getCaja();
        tope = tope.getSiguiente();
        return caja;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void mostrar() {
        NodoCaja actual = tope;
        while (actual != null) {
            System.out.println(actual.getCaja());
            actual = actual.getSiguiente();
        }
    }

    public NodoCaja getTope() {
        return tope;
    }
}
