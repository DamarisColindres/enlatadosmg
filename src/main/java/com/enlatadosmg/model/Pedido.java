package com.enlatadosmg.model;

import com.enlatadosmg.datastructures.ListaProductos;
import com.enlatadosmg.datastructures.NodoCliente;
import com.enlatadosmg.datastructures.NodoRepartidor;
import com.enlatadosmg.datastructures.NodoVehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private int numeroPedido;
    private String departamentoOrigen;
    private String departamentoDestino;
    private LocalDateTime fechaHoraInicio;

    private NodoCliente cliente;         // Apuntador a un nodo del árbol AVL de clientes
    private NodoRepartidor repartidor;   // Apuntador a un nodo de la cola de repartidores
    private NodoVehiculo vehiculo;       // Apuntador a un nodo de la cola de vehículos

    private ListaProductos productos;    // Lista enlazada de productos (cajas)
    private int numeroCajas;             // Calculado con productos.contarNodos()

    private String estado; // "Completado" o "Pendiente"

    public void actualizarNumeroCajas() {
        if (productos != null) {
            this.numeroCajas = productos.contarNodos();
        } else {
            this.numeroCajas = 0;
        }
    }
}
