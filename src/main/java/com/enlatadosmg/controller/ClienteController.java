package com.enlatadosmg.controller;

import com.enlatadosmg.datastructures.ArbolAVLClientes;
import com.enlatadosmg.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ArbolAVLClientes arbolClientes = new ArbolAVLClientes();

    @PostMapping
    public ResponseEntity<String> crearCliente(@RequestBody Cliente cliente) {
        arbolClientes.insertar(cliente);
        return ResponseEntity.ok("Cliente insertado correctamente.");
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(arbolClientes.obtenerClientesEnOrden());
    }

    @GetMapping("/{cui}")
    public ResponseEntity<?> obtenerCliente(@PathVariable String cui) {
        Cliente cliente = arbolClientes.buscar(cui);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{cui}")
    public ResponseEntity<String> actualizarCliente(@PathVariable String cui, @RequestBody Cliente clienteActualizado) {
        boolean actualizado = arbolClientes.actualizarCliente(cui, clienteActualizado.getNombre(), clienteActualizado.getApellido(), clienteActualizado.getTelefono());
        if (actualizado) {
            return ResponseEntity.ok("Cliente actualizado.");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cui}")
    public ResponseEntity<String> eliminarCliente(@PathVariable String cui) {
        boolean eliminado = arbolClientes.eliminar(cui);
        if (eliminado) {
            return ResponseEntity.ok("Cliente eliminado.");
        }
        return ResponseEntity.notFound().build();
    }
}
