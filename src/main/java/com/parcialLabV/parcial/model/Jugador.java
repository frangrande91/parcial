package com.parcialLabV.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Currency;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jugador extends Persona {
    private Double peso;
    private Double altura;
    private Integer goles;
    private Integer minutosJugados;
    private Currency currency;
    private LocalDate fechaNacimiento;

    @Override
    public TipoPersona tipoPersona() {
        return TipoPersona.JUGADOR;
    }
}
