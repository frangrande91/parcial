package com.parcialLabV.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player extends Person {
    private Double weight;
    private Double height;
    private Integer goals;
    private Integer minutesPlayed;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    private LocalDate dateBirth;

    @Override
    public TypePerson typePerson() {
        return TypePerson.PLAYER;
    }
}
