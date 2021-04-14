package com.parcialLabV.parcial.service;

import com.parcialLabV.parcial.model.Jugador;
import com.parcialLabV.parcial.model.Persona;
import com.parcialLabV.parcial.model.Representante;
import com.parcialLabV.parcial.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    public void addPersona(Persona newPersona) {
        personaRepository.save(newPersona);
    }

    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    public Persona getPersona(Integer id) {
        return personaRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void deletePersona(Integer id) {
        personaRepository.deleteById(id);
    }


    public void addJugadorToPersona(Integer id, Integer idJugador) {
        Persona representante = getPersona(id);
        Persona jugador = getPersona(idJugador);
        if(representante instanceof Representante && jugador instanceof Jugador){
            ((Representante) representante).getJugadores().add((Jugador)jugador);
        }
    }


    public double getMontoTotal(Integer id) {
        Double monto = 0;
        List<Jugador> jugadores;
        Persona repre = getPersona(id);
        if(repre instanceof Jugador) {
            jugadores = ((Representante) repre).getJugadores();
            for (Jugador j : jugadores) {
                
            }

        }

    }


}
