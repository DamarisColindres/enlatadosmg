package com.enlatadosmg.datastructures;

import com.enlatadosmg.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodoPedido {
    private Pedido pedido;
    private NodoPedido siguiente;
}
