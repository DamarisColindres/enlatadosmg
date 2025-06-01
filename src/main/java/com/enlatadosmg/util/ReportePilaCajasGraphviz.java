package com.enlatadosmg.util;

import com.enlatadosmg.datastructures.NodoCaja;
import com.enlatadosmg.datastructures.PilaCajas;
import com.enlatadosmg.model.Caja;

import java.io.FileWriter;
import java.io.IOException;

public class ReportePilaCajasGraphviz {

    public static void generarDot(PilaCajas pila, String rutaSalida) {
        try (FileWriter writer = new FileWriter(rutaSalida)) {
            writer.write("digraph PilaCajas {\n");
            writer.write("    rankdir=TB;\n");
            writer.write("    node [shape=record, style=filled, fillcolor=lightgoldenrod];\n");

            NodoCaja actual = pila.getTope(); // ← usa tu método getTope()
            int contador = 0;

            while (actual != null) {
                Caja caja = actual.caja;
                writer.write(String.format("    nodo%d [label=\"ID: %d\\nFecha: %s\"];\n",
                        contador, caja.getId(), caja.getFechaIngreso()));
                if (actual.siguiente != null) {
                    writer.write(String.format("    nodo%d -> nodo%d;\n", contador, contador + 1));
                }
                actual = actual.siguiente;
                contador++;
            }

            writer.write("}");
            System.out.println("Archivo DOT generado en: " + rutaSalida);
        } catch (IOException e) {
            System.err.println("Error al generar archivo DOT: " + e.getMessage());
        }
    }
}
