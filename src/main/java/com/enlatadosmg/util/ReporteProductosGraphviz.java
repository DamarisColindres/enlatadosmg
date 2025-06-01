package com.enlatadosmg.util;

import com.enlatadosmg.datastructures.ArbolAVLProductos;

import java.io.FileWriter;
import java.io.IOException;

public class ReporteProductosGraphviz {

    public static void generarDot(ArbolAVLProductos arbol, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            writer.write("digraph G {\n");
            writer.write("node [shape=record];\n");
            writer.write(arbol.generarDot());
            writer.write("}\n");

            System.out.println("Reporte DOT de productos generado: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al generar el archivo DOT de productos.");
            e.printStackTrace();
        }
    }
}

