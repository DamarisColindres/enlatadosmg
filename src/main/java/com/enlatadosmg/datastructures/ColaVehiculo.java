package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Vehiculo;

public class ColaVehiculo {
    private NodoVehiculo frente;
    private NodoVehiculo fin;

    public ColaVehiculo() {
        frente = fin = null;
    }

    public void encolar(Vehiculo vehiculo) {
        NodoVehiculo nuevo = new NodoVehiculo(vehiculo, null);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public Vehiculo desencolar() {
        if (estaVacia()) return null;
        Vehiculo v = frente.getVehiculo();
        frente = frente.getSiguiente();
        if (frente == null) fin = null;
        return v;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrar() {
        NodoVehiculo actual = frente;
        while (actual != null) {
            Vehiculo v = actual.getVehiculo();
            System.out.printf("Placa: %s | Marca: %s | Modelo: %s | Color: %s | Año: %d | Transmisión: %s%n",
                    v.getPlaca(), v.getMarca(), v.getModelo(), v.getColor(), v.getAnio(), v.getTipoTransmision());
            actual = actual.getSiguiente();
        }
    }

    public String generarDot() {
        StringBuilder dot = new StringBuilder();
        dot.append("rankdir=LR;\n");
        NodoVehiculo actual = frente;
        int index = 0;

        while (actual != null) {
            Vehiculo v = actual.getVehiculo();
            dot.append(String.format("n%d [label=\"Placa: %s\\nMarca: %s\\nModelo: %s\"];\n",
                    index, v.getPlaca(), v.getMarca(), v.getModelo()));
            if (actual.getSiguiente() != null) {
                dot.append(String.format("n%d -> n%d;\n", index, index + 1));
            }
            actual = actual.getSiguiente();
            index++;
        }

        return dot.toString();
    }

    public NodoVehiculo getFrente() {
        return frente;
    }
}

