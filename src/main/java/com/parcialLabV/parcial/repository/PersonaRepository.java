package com.parcialLabV.parcial.repository;

import com.parcialLabV.parcial.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query(value = "", nativeQuery = true)
    List()

}
