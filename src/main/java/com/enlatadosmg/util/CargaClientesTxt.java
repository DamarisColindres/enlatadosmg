package com.enlatadosmg.util;

import com.enlatadosmg.datastructures.ArbolAVLClientes;
import com.enlatadosmg.model.Cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargaClientesTxt {

    // Méetodo principal que recibe ruta y árbol
    public static void cargarClientesDesdeTXT(String rutaArchivo, ArbolAVLClientes arbol) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean esPrimera = true;

            while ((linea = br.readLine()) != null) {
                if (esPrimera) {
                    esPrimera = false; // saltar encabezado
                    continue;
                }

                String[] datos = linea.split(";");
                if (datos.length < 4) continue;

                String cui = datos[0];
                String nombre = datos[1];
                String apellido = datos[2];
                String telefono = datos[3];

                Cliente cliente = new Cliente(cui, nombre, apellido, telefono);
                arbol.insertar(cliente);
            }

            System.out.println("✅ Clientes cargados desde archivo TXT.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
