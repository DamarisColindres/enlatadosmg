package com.enlatadosmg.util;

import com.enlatadosmg.datastructures.ColaVehiculo;
import java.io.FileWriter;
import java.io.IOException;

public class ReporteVehiculosGraphviz {
    public static void generarDot(ColaVehiculo cola, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            writer.write("digraph G {\n");
            writer.write(cola.generarDot()); // Este método debe estar en ColaVehiculo
            writer.write("}\n");
            System.out.println("Reporte de vehículos generado en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al generar el reporte DOT de vehículos.");
            e.printStackTrace();
        }
    }
}

