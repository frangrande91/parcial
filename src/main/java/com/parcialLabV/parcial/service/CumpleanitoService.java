package com.parcialLabV.parcial.service;

import com.parcialLabV.parcial.controller.ApiController;
import com.parcialLabV.parcial.model.Cumpleanito;
import com.parcialLabV.parcial.model.Person;
import com.parcialLabV.parcial.model.Player;
import com.parcialLabV.parcial.repository.CumpleanitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.List;

@Service
public class CumpleanitoService {

    @Autowired
    private CumpleanitoRepository cumpleanitoRepository;

    @Autowired
    private ApiController apiController;

    @Autowired
    private PersonService personService;

    public Cumpleanito addCumpleanito(Cumpleanito cumpleanito) {
        return cumpleanitoRepository.save(cumpleanito);
    }


    public Cumpleanito getCumpleanitoById(Integer id) {
        return cumpleanitoRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public Cumpleanito addCumpleanieroToCumpleanito(Integer id, Integer idPerson) {
        Cumpleanito cumpleanito = getCumpleanitoById(id);
        Person person = personService.getPersonById(idPerson);
        cumpleanito.setCumpleaniero(person);
        return cumpleanitoRepository.save(cumpleanito);
    }

    public Cumpleanito addInvitadoToCumpleanito(Integer id, Integer idPerson) throws Exception {
        Cumpleanito cumpleanito = getCumpleanitoById(id);
        Person person = personService.getPersonById(idPerson);
        if(person instanceof Player) {
            cumpleanito.getInvitados().add((Player)person);
            return cumpleanitoRepository.save(cumpleanito);
        }
        else{
            throw new Exception(String.format("No es un jugador"));
        }
    }


    public void pagoCumpleanito(Integer idCumpleanito) throws IOException, InterruptedException {
        Cumpleanito cumpleanito = getCumpleanitoById(idCumpleanito);
        List<Player> invitados = cumpleanito.getInvitados();
        for(Player p : invitados){
            if(p.getCurrency().getTypeCurrency().equals("DOLLAR")){
                p.getCurrency().setConversion(apiController.getDolar().getVenta());
            }
            else if(p.getCurrency().getTypeCurrency().equals("EURO")){
                p.getCurrency().setConversion(apiController.getEuro().getVenta());
            }
        }

    }

    public List<Player> getListado(Integer idCumpleanito) {
        Cumpleanito cumpleanito = getCumpleanitoById(idCumpleanito);
        return cumpleanito.getInvitados();
    }

}
