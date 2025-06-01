package com.enlatadosmg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Caja {
    private int id;
    private LocalDate fechaIngreso;

    @Override
    public String toString() {
        return "Caja{id=" + id + ", fechaIngreso=" + fechaIngreso + '}';
    }
}
