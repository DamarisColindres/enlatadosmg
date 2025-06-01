package com.enlatadosmg.util;

import com.enlatadosmg.datastructures.ColaRepartidores;
import com.enlatadosmg.datastructures.NodoRepartidor;
import com.enlatadosmg.model.Repartidor;

import java.io.FileWriter;
import java.io.IOException;

public class ReporteRepartidoresGraphviz {

    public static void generarDot(ColaRepartidores cola, String rutaSalida) {
        try (FileWriter writer = new FileWriter(rutaSalida)) {
            writer.write("digraph ColaRepartidores {\n");
            writer.write("    rankdir=LR;\n");
            writer.write("    node [shape=record, style=filled, fillcolor=lightgreen];\n");

            NodoRepartidor actual = cola.getFrente();
            int contador = 0;

            while (actual != null) {
                Repartidor r = actual.repartidor;
                writer.write(String.format("    nodo%d [label=\"CUI: %s\\nNombre: %s %s\\nLicencia: %s\\nTel: %s\"];\n",
                        contador, r.getCui(), r.getNombre(), r.getApellido(), r.getTipoLicencia(), r.getTelefono()));
                if (actual.siguiente != null) {
                    writer.write(String.format("    nodo%d -> nodo%d;\n", contador, contador + 1));
                }
                actual = actual.siguiente;
                contador++;
            }

            writer.write("}\n");
            System.out.println("Reporte de cola de repartidores generado en: " + rutaSalida);
        } catch (IOException e) {
            System.err.println("Error al generar DOT de repartidores: " + e.getMessage());
        }
    }
}
