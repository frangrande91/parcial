package com.parcialLabV.parcial.controller;

import com.parcialLabV.parcial.model.Person;
import com.parcialLabV.parcial.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping("/")
    public void addPersona(@RequestBody Person newPerson){
        personService.addPerson(newPerson);
    }

    @GetMapping
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Integer id){
        return personService.getPerson(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Integer id){
        personService.deletePerson(id);
    }

    @PutMapping("/{id}/players/{idPlayer}")
    public void addPlayerToManager(@PathVariable Integer id, @PathVariable Integer idPlayer){
        personService.addPlayerToManager(id, idPlayer);
    }

    @PutMapping("/{id}/{idCurrency}")
    public void addCurrencyToPlayer(@PathVariable Integer id, @PathVariable Integer idCurrency){
        personService.addCurrencyToPlayer(id, idCurrency);
    }

}
