package com.enlatadosmg.util;

import com.enlatadosmg.datastructures.ListaPedidos;
import com.enlatadosmg.datastructures.NodoPedido;
import java.io.FileWriter;
import java.io.IOException;

public class ReportePedidosGraphviz {

    public static void generarDOT(ListaPedidos listaPedidos) {
        StringBuilder dot = new StringBuilder();
        dot.append("digraph Pedidos {\n");
        dot.append("rankdir=LR;\n");
        dot.append("node [shape=box];\n");

        NodoPedido actual = listaPedidos.getHead();
        int contador = 0;

        while (actual != null) {
            dot.append("n").append(contador).append(" [label=\"")
                    .append("Pedido #").append(actual.getPedido().getNumeroPedido())
                    .append("\\nEstado: ").append(actual.getPedido().getEstado())
                    .append("\"];\n");

            if (actual.getSiguiente() != null) {
                dot.append("n").append(contador).append(" -> n").append(contador + 1).append(";\n");
            }

            actual = actual.getSiguiente();
            contador++;
        }

        dot.append("}");

        try (FileWriter writer = new FileWriter("pedidos.dot")) {
            writer.write(dot.toString());
            System.out.println("Archivo .dot generado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
