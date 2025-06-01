package com.enlatadosmg.controller;

import com.enlatadosmg.datastructures.ColaVehiculo;
import com.enlatadosmg.model.Vehiculo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private ColaVehiculo colaVehiculos = new ColaVehiculo();

    @PostMapping
    public ResponseEntity<String> encolarVehiculo(@RequestBody Vehiculo vehiculo) {
        colaVehiculos.encolar(vehiculo);
        return ResponseEntity.ok("Vehículo encolado");
    }

    @DeleteMapping
    public ResponseEntity<Vehiculo> desencolarVehiculo() {
        Vehiculo vehiculo = colaVehiculos.desencolar();
        if (vehiculo == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(vehiculo);
    }

    @GetMapping
    public ResponseEntity<String> mostrarCola() {
        colaVehiculos.mostrar(); // Imprime en consola, para pruebas
        return ResponseEntity.ok("Cola mostrada en consola");
    }
}
