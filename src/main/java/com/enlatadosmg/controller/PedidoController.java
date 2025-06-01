package com.enlatadosmg.controller;

import com.enlatadosmg.datastructures.ListaPedidos;
import com.enlatadosmg.model.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private ListaPedidos listaPedidos = new ListaPedidos();

    @PostMapping
    public ResponseEntity<String> crearPedido(@RequestBody Pedido pedido) {
        listaPedidos.agregarPedido(pedido);
        return ResponseEntity.ok("Pedido creado exitosamente");
    }

    @GetMapping
    public ResponseEntity<String> verPedidos() {
        listaPedidos.mostrarPedidos(); // imprime en consola
        return ResponseEntity.ok("Pedidos mostrados en consola");
    }
}
