package com.enlatadosmg.controller;

import com.enlatadosmg.datastructures.PilaCajas;
import com.enlatadosmg.model.Caja;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cajas")
public class CajaController {

    private PilaCajas pilaCajas = new PilaCajas();

    @PostMapping
    public ResponseEntity<String> pushCaja(@RequestBody Caja caja) {
        pilaCajas.push(caja);
        return ResponseEntity.ok("Caja apilada");
    }

    @DeleteMapping
    public ResponseEntity<Caja> popCaja() {
        Caja caja = pilaCajas.pop();
        if (caja == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(caja);
    }

    @GetMapping
    public ResponseEntity<String> mostrarPila() {
        pilaCajas.mostrar(); // Imprime en consola
        return ResponseEntity.ok("Pila mostrada en consola");
    }
}
