package com.enlatadosmg.util;

import com.enlatadosmg.datastructures.ColaRepartidores;
import com.enlatadosmg.model.Repartidor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargaRepartidoresTxt {

    public static void cargarRepartidoresDesdeTxt(String rutaArchivo, ColaRepartidores cola) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean esPrimera = true;

            while ((linea = br.readLine()) != null) {
                if (esPrimera) {
                    esPrimera = false; // Saltar encabezado
                    continue;
                }

                String[] datos = linea.split(";");
                if (datos.length < 5) continue;

                String cui = datos[0];
                String nombre = datos[1];
                String apellido = datos[2];
                String licencia = datos[3];
                String telefono = datos[4];

                Repartidor r = new Repartidor(cui, nombre, apellido, licencia, telefono);
                cola.encolar(r);
            }

            System.out.println("Repartidores cargados desde archivo TXT.");
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
    }
}
