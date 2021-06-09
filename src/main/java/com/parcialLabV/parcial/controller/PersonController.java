package com.parcialLabV.parcial.controller;

import com.parcialLabV.parcial.model.Person;
import com.parcialLabV.parcial.model.dto.PersonDto;
import com.parcialLabV.parcial.model.projections.PersonProjection;
import com.parcialLabV.parcial.service.PersonService;
import com.parcialLabV.parcial.utils.EntityURLBuilder;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static final String PERSON_PATH = "person";
    private PersonService personService;
    private ConversionService conversionService;

    @Autowired
    public PersonController(PersonService personService, ConversionService conversionService) {
        this.personService = personService;
        this.conversionService = conversionService;
    }

    @PostMapping("/")
    public ResponseEntity<String> addPersona(@RequestBody Person newPerson){
        Person personCreated = personService.addPerson(newPerson);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(EntityURLBuilder.buildURL(PERSON_PATH, personCreated.getId()))
                .contentType(MediaType.APPLICATION_JSON)
                .body("Person has been created");
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll(@RequestParam (value = "page", defaultValue = "0") Integer page,
                                               @RequestParam (value = "size", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Person> personPage = personService.getAll(pageable);
        if(!personPage.getContent().isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("X-total-Count", Long.toString(personPage.getTotalElements()))
                    .header("X-Total-Pages", Long.toString(personPage.getTotalPages()))
                    .body(personPage.getContent());
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personPage.getContent());
        }
    }


    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable Integer id){
        return conversionService.convert(personService.getPersonById(id), PersonDto.class);
    }

    @GetMapping("/{id}/{name}")
    public PersonProjection getPersonByIdProjection(@PathVariable Integer id, @PathVariable String name){
        return personService.getPersonByIdAndName(id, name);
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable Integer id){
        personService.deletePerson(id);
    }

    @PutMapping("/{id}/players/{idPlayer}")
    public void addPlayerToManager(@PathVariable Integer id, @PathVariable Integer idPlayer){
        personService.addPlayerToManager(id, idPlayer);
    }

    @PutMapping("/{id}/currencie/{idCurrency}")
    public void addCurrencyToPlayer(@PathVariable Integer id, @PathVariable Integer idCurrency){
        personService.addCurrencyToPlayer(id, idCurrency);
    }

}
