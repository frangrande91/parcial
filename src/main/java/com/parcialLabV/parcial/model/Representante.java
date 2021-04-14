package com.parcialLabV.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Representante extends Persona {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugador_id")
    public List<Jugador> jugadores;

    private Double pesoBoveda;

    private Double montoTotal;

    @Override
    public TipoPersona tipoPersona() {
        return TipoPersona.REPRESENTANTE;
    }




}
