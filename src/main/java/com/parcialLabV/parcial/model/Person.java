package com.parcialLabV.parcial.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typePerson", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Manager.class, name = "MANAGER"),
        @JsonSubTypes.Type(value = Player.class, name = "PLAYER")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)


public abstract  class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotNull
    protected String name;

    @NotNull
    protected String lastName;

    protected String address;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypePerson typePerson();

}
