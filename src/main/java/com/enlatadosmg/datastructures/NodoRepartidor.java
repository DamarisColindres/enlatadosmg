package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Repartidor;

public class NodoRepartidor {
    public Repartidor repartidor;
    public NodoRepartidor siguiente;

    public NodoRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
        this.siguiente = null;
    }


    public Repartidor getRepartidor() {
        return repartidor;
    }
}
