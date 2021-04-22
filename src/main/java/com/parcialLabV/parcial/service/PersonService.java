package com.parcialLabV.parcial.service;

import com.parcialLabV.parcial.model.Currency;
import com.parcialLabV.parcial.model.Player;
import com.parcialLabV.parcial.model.Person;
import com.parcialLabV.parcial.model.Manager;
import com.parcialLabV.parcial.repository.CurrencyRepository;
import com.parcialLabV.parcial.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private CurrencyService currencyService;

    @Autowired
    public PersonService(PersonRepository personRepository, CurrencyService currencyService) {
        this.personRepository = personRepository;
        this.currencyService = currencyService;
    }


    public void addPerson(Person newPerson) {
        personRepository.save(newPerson);
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public Person getPerson(Integer id) {
        return personRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }


    public void addPlayerToManager(Integer id, Integer idJugador) {
        Person manager = getPerson(id);
        Person player = getPerson(idJugador);
        if(manager instanceof Manager && player instanceof Player){
            ((Manager) manager).getPlayers().add((Player)player);
        }
        personRepository.save(manager);
    }

    public void addCurrencyToPlayer(Integer id, Integer idCurrency) {
        Currency currency = currencyService.getCurrencyById(idCurrency);
        Person person = getPerson(id);
        if(person instanceof Player){
            ((Player) person).setCurrency(currency);
        }
        personRepository.save(person);
    }
}
