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
public class Manager extends Person {

    public static final int BILL = 100;
    public static final int WEIGHT_BILL = 1;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private List<Player> players;

    private Integer weightSafe;

    private Integer totalAmount;

    @Override
    public TypePerson typePerson() {
        return TypePerson.MANAGER;
    }


    public Integer getTotalAmount(){
        return players.stream()
                .map(Player::getCurrency)
                .map(Currency::getAmount)
                .reduce(0, Integer::sum);
    }

    public Integer getWeightSafe(){
        return ((getTotalAmount() / BILL) * WEIGHT_BILL);
    }
}
