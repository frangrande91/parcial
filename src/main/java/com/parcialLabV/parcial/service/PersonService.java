package com.parcialLabV.parcial.service;

import com.parcialLabV.parcial.model.Currency;
import com.parcialLabV.parcial.model.Manager;
import com.parcialLabV.parcial.model.Person;
import com.parcialLabV.parcial.model.Player;
import com.parcialLabV.parcial.model.dto.PersonDto;
import com.parcialLabV.parcial.model.projections.PersonProjection;
import com.parcialLabV.parcial.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonService {

    private static final String PERSON_PATH = "person";
    private PersonRepository personRepository;
    private CurrencyService currencyService;

    @Autowired
    public PersonService(PersonRepository personRepository, CurrencyService currencyService) {
        this.personRepository = personRepository;
        this.currencyService = currencyService;
    }

    public Person addPerson(Person newPerson) {
        return personRepository.save(newPerson);
    }


    public Page<Person> getAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }


    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public PersonProjection getPersonByIdAndName(Integer id, String name) {
        return personRepository.findByIdAndName(id, name);
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }


    public void addPlayerToManager(Integer id, Integer idJugador) {
        Person manager = getPersonById(id);
        Person player = getPersonById(idJugador);
        if(manager instanceof Manager && player instanceof Player){
            ((Manager) manager).getPlayers().add((Player)player);
        }
        personRepository.save(manager);
    }

    public void addCurrencyToPlayer(Integer id, Integer idCurrency) {
        Currency currency = currencyService.getCurrencyById(idCurrency);
        Person person = getPersonById(id);
        if(person instanceof Player){
            ((Player) person).setCurrency(currency);
        }
        personRepository.save(person);
    }


}
