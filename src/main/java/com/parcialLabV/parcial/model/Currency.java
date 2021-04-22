package com.parcialLabV.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private TypeCurrency typeCurrency;

    private Integer amount;


    public Integer getAmountPesos(){
        return (this.amount * this.getTypeCurrency().getConversion());
    }
}
