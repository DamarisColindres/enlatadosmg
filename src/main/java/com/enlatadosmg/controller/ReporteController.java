package com.enlatadosmg.controller;

import com.enlatadosmg.datastructures.ListaUsuarios;
import com.enlatadosmg.model.Usuario;
import com.enlatadosmg.util.ReporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ListaUsuarios listaUsuarios;

    public ReporteController() {
        this.listaUsuarios = new ListaUsuarios();
        // Datos de prueba (puedes quitarlos y cargar desde otra clase)
        listaUsuarios.agregar(new Usuario("U1", "Lilian", "Colindres", "1234"));
        listaUsuarios.agregar(new Usuario("U2", "Gabriela", "Colindres", "abcd"));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<String> generarReporteUsuarios() {
        try {
            String dot = listaUsuarios.generarReporteDot();
            ReporteService.guardarDot(dot, "usuarios.dot");
            ReporteService.generarImagenDesdeDot("usuarios.dot", "usuarios.png");
            return ResponseEntity.ok("Reporte generado: usuarios.png");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al generar reporte: " + e.getMessage());
        }
    }
}
