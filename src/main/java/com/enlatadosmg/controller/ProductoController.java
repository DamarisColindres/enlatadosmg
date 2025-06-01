package com.enlatadosmg.controller;

import com.enlatadosmg.datastructures.ArbolAVLProductos;
import com.enlatadosmg.model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private ArbolAVLProductos arbolProductos = new ArbolAVLProductos();

    @PostMapping
    public ResponseEntity<String> insertarProducto(@RequestBody Producto producto) {
        arbolProductos.insertar(producto);
        return ResponseEntity.ok("Producto insertado");
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable String codigo) {
        Producto producto = arbolProductos.buscar(codigo);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{codigo}/stock")
    public ResponseEntity<String> actualizarStock(@PathVariable String codigo, @RequestParam int stock) {
        boolean actualizado = arbolProductos.actualizarStock(codigo, stock);
        if (!actualizado) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Stock actualizado");
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> eliminarProducto(@PathVariable String codigo) {
        arbolProductos.eliminar(codigo);
        return ResponseEntity.ok("Producto eliminado");
    }

    @GetMapping("/buscar/nombre")
    public ResponseEntity<Void> buscarPorNombre(@RequestParam String nombre) {
        arbolProductos.buscarPorNombre(nombre);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar/categoria")
    public ResponseEntity<Void> buscarPorCategoria(@RequestParam String categoria) {
        arbolProductos.buscarPorCategoria(categoria);
        return ResponseEntity.ok().build();
    }
}

