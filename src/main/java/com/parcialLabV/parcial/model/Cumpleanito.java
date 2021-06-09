package com.parcialLabV.parcial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.In;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cumpleanito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    private LocalDate date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person cumpleaniero;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private List<Player> invitados;


}
