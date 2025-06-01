package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Caja;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodoCaja {
    public Caja caja;
    public NodoCaja siguiente;

    public NodoCaja(Caja caja) {
        this.caja = caja;
        this.siguiente = null;
    }
}
