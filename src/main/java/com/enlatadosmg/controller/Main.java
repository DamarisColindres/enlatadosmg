package com.enlatadosmg.controller;

import com.enlatadosmg.datastructures.*;
import com.enlatadosmg.model.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // ** LISTA DE PEDIDOS **
        ListaPedidos listaPedidos = new ListaPedidos();

        // Crear pedidos de ejemplo (puedes completar asignaciones después)
        Pedido pedido1 = new Pedido();
        pedido1.setNumeroPedido(1);
        pedido1.setDepartamentoOrigen("Dep1");
        pedido1.setDepartamentoDestino("Dep2");
        pedido1.setFechaHoraInicio(LocalDateTime.now());
        pedido1.actualizarNumeroCajas();

        Pedido pedido2 = new Pedido();
        pedido2.setNumeroPedido(2);
        pedido2.setEstado("Completado");
        pedido2.setFechaHoraInicio(LocalDateTime.now().minusDays(1));

        // Agregar pedidos iniciales a la lista
        listaPedidos.agregarPedido(pedido1);
        listaPedidos.agregarPedido(pedido2);


        // Crear Cliente, Repartidor y Vehículo
        Cliente cliente = new Cliente("123456789", "Allan", "Gómez", "555-1234");
        Repartidor repartidor = new Repartidor("987654321", "Ana", "Martínez", "A", "555-5678");
        Vehiculo vehiculo = new Vehiculo("V001", "Toyota", "ABC-123", "Corolla", "2023", "Camioneta");

        // Crear nodos
        NodoCliente nodoCliente = new NodoCliente(cliente);
        NodoRepartidor nodoRepartidor = new NodoRepartidor(repartidor);
        NodoVehiculo nodoVehiculo = new NodoVehiculo(vehiculo, null);

        // Crear lista de productos y agregar productos
        ListaProductos listaProductosPedido = new ListaProductos();
        listaProductosPedido.agregarProducto(new Producto("P001", "Atún", "Enlatado", 8.50, 100));
        listaProductosPedido.agregarProducto(new Producto("P002", "Frijoles", "Enlatado", 6.75, 50));

        // Crear pedido con asignaciones completas
        Pedido pedido3 = new Pedido();
        pedido3.setNumeroPedido(3);
        pedido3.setDepartamentoOrigen("Dep3");
        pedido3.setDepartamentoDestino("Dep4");
        pedido3.setFechaHoraInicio(LocalDateTime.now());
        pedido3.setCliente(nodoCliente);
        pedido3.setRepartidor(nodoRepartidor);
        pedido3.setVehiculo(nodoVehiculo);
        pedido3.setProductos(listaProductosPedido);
        pedido3.actualizarNumeroCajas();
        pedido3.setEstado("Pendiente");


        listaPedidos.agregarPedido(pedido3);

        //Mostrar los pedidos
        System.out.println("LISTA DE PEDIDOS:");
        listaPedidos.mostrarPedidos();




        System.out.println("Detalle pedido 3:");
        System.out.println("Número Pedido: " + pedido3.getNumeroPedido());
        System.out.println("Cliente: " + pedido3.getCliente().getCliente().getNombre());
        System.out.println("Repartidor: " + pedido3.getRepartidor().getRepartidor().getNombre());
        System.out.println("Vehículo: " + pedido3.getVehiculo().getVehiculo().getMarca());
        System.out.println("Número de cajas: " + pedido3.getNumeroCajas());
        System.out.println("Estado: " + pedido3.getEstado());

    }
}
