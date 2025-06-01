package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodoVehiculo {
    private Vehiculo vehiculo;
    private NodoVehiculo siguiente;

    public Vehiculo getVehiculo() {
        return vehiculo;
    }


}

