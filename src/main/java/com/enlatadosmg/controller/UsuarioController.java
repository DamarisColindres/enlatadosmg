package com.enlatadosmg.controller;

import com.enlatadosmg.datastructures.ListaUsuarios;
import com.enlatadosmg.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final ListaUsuarios listaUsuarios = new ListaUsuarios();

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return listaUsuarios.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable String id) {
        Usuario usuario = listaUsuarios.buscarPorId(id);
        if (usuario != null) return ResponseEntity.ok(usuario);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> agregarUsuario(@RequestBody Usuario usuario) {
        listaUsuarios.agregar(usuario);
        return ResponseEntity.ok("Usuario agregado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        boolean eliminado = listaUsuarios.eliminar(id);
        return eliminado ? ResponseEntity.ok("Eliminado") : ResponseEntity.notFound().build();
    }
}
