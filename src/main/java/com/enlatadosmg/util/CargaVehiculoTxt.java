package com.enlatadosmg.util;

import com.enlatadosmg.datastructures.ColaVehiculo;
import com.enlatadosmg.model.Vehiculo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargaVehiculoTxt {

    public static void cargarVehiculoDesdeTxt(String ruta, ColaVehiculo cola) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            boolean primera = true;

            while ((linea = br.readLine()) != null) {
                if (primera) {
                    primera = false; // Saltar encabezado
                    continue;
                }

                String[] datos = linea.split(";");
                if (datos.length < 6) continue;

                String placa = datos[0].trim();
                String marca = datos[1].trim();
                String modelo = datos[2].trim();
                String color = datos[3].trim();
                String anio = datos[4].trim();
                String tipoTransmision = datos[5].trim();

                Vehiculo v = new Vehiculo(placa, marca, modelo, color, anio, tipoTransmision);
                cola.encolar(v);
            }

            System.out.println("Vehículos cargados correctamente desde archivo TXT.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de vehículos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en el format del año de algún vehículo.");
        }
    }
}
