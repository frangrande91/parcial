package com.parcialLabV.parcial.controller;

import com.parcialLabV.parcial.model.Persona;
import com.parcialLabV.parcial.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;


    @PostMapping("/")
    public void addPersona(@RequestBody Persona newPersona){
        personaService.addPersona(newPersona);
    }

    @GetMapping
    public List<Persona> getPersonas(){
        return personaService.getPersonas();
    }

    @GetMapping("/{id}")
    public Persona getPersona(@PathVariable Integer id){
        return personaService.getPersona(id);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Integer id){
        personaService.deletePersona(id);
    }

    @PutMapping("/{id}/jugadores/{idJugador}")
    public void addJugadorToPersona(@PathVariable Integer id, @PathVariable Integer idJugador){
        personaService.addJugadorToPersona(id, idJugador);
    }

    @GetMapping("{id}")
    public List<Persona> getJugadoresById(@PathVariable Integer id){
        return personaService.getJugadoresById(id);
    }

    @GetMapping("{id}")
    public double getMontoTotal(@PathVariable Integer id){
        return personaService.getMontoTotal(id);
    }
}
