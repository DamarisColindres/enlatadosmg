package com.enlatadosmg.util;

import com.enlatadosmg.datastructures.ArbolAVLProductos;
import com.enlatadosmg.model.Producto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargaProductosTxt {

    public static void cargarProductosDesdeTxt(String rutaArchivo, ArbolAVLProductos arbol) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean esPrimera = true;

            while ((linea = br.readLine()) != null) {
                if (esPrimera) {
                    esPrimera = false;
                    continue;
                }

                String[] datos = linea.split(";");
                if (datos.length < 5) continue;

                String codigo = datos[0];
                String nombre = datos[1];
                String categoria = datos[2];
                double precio = Double.parseDouble(datos[3]);
                int stock = Integer.parseInt(datos[4]);

                Producto producto = new Producto(codigo, nombre, categoria, precio, stock);
                arbol.insertar(producto);
            }

            System.out.println("Productos cargados desde archivo TXT.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo de productos: " + e.getMessage());
        }
    }
}
