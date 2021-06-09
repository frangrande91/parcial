package com.parcialLabV.parcial.repository;

import com.parcialLabV.parcial.model.Person;
import com.parcialLabV.parcial.model.projections.PersonProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {
    Page<Person> findAll(Pageable var1);

    PersonProjection findByIdAndName(Integer id, String name);
}
