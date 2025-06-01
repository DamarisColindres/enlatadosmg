package com.enlatadosmg.util;

import com.enlatadosmg.datastructures.ArbolAVLClientes;
import com.enlatadosmg.datastructures.NodoCliente;
import com.enlatadosmg.model.Cliente;

import java.io.FileWriter;
import java.io.IOException;

public class ReporteClientesGraphviz {

    public static void generarDot(ArbolAVLClientes arbol, String rutaSalida) {
        try (FileWriter writer = new FileWriter(rutaSalida)) {
            writer.write("digraph AVLClientes {\n");
            writer.write("    node [shape=record, style=filled, fillcolor=lightyellow];\n");
            writer.write("    rankdir=TB;\n");

            if (arbol != null) {
                generarNodos(writer, arbol.getRaiz());
                generarConexiones(writer, arbol.getRaiz());
            }

            writer.write("}\n");
            System.out.println("Reporte de árbol AVL de clientes generado en: " + rutaSalida);
        } catch (IOException e) {
            System.err.println("Error al generar DOT de clientes: " + e.getMessage());
        }
    }

    private static void generarNodos(FileWriter writer, NodoCliente nodo) throws IOException {
        if (nodo != null) {
            Cliente c = nodo.getCliente();
            writer.write(String.format("    \"%s\" [label=\"{%s\\n%s %s\\n%s}\"];\n",
                    c.getCui(), c.getCui(), c.getNombre(), c.getApellido(), c.getTelefono()));
            generarNodos(writer, nodo.izquierdo);
            generarNodos(writer, nodo.derecho);
        }
    }

    private static void generarConexiones(FileWriter writer, NodoCliente nodo) throws IOException {
        if (nodo != null) {
            if (nodo.izquierdo != null) {
                writer.write(String.format("    \"%s\" -> \"%s\";\n",
                        nodo.getCliente().getCui(), nodo.izquierdo.getCliente().getCui()));
            }
            if (nodo.derecho != null) {
                writer.write(String.format("    \"%s\" -> \"%s\";\n",
                        nodo.getCliente().getCui(), nodo.derecho.getCliente().getCui()));
            }
            generarConexiones(writer, nodo.izquierdo);
            generarConexiones(writer, nodo.derecho);
        }
    }

}
