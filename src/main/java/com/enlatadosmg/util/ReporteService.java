package com.enlatadosmg.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReporteService {

    public static void generarImagenDesdeDot(String nombreArchivoDot, String nombreImagen) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(
                "dot", "-Tpng", nombreArchivoDot, "-o", nombreImagen
        );
        builder.directory(new File(".")); // carpeta raíz
        Process proceso = builder.start();
        int exitCode = proceso.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Error al generar imagen con Graphviz");
        }
    }

    public static void guardarDot(String contenidoDot, String rutaArchivo) throws IOException {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            writer.write(contenidoDot);
        }
    }
}
