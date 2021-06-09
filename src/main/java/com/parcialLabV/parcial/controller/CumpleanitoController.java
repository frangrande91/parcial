package com.parcialLabV.parcial.controller;

import com.parcialLabV.parcial.model.Cumpleanito;
import com.parcialLabV.parcial.model.Person;
import com.parcialLabV.parcial.model.Player;
import com.parcialLabV.parcial.service.CumpleanitoService;
import com.parcialLabV.parcial.utils.EntityURLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cumpleanito")
public class CumpleanitoController {

    private static final String CUMPLEANITO_PATH = "cumpleanito";
    @Autowired
    private CumpleanitoService cumpleanitoService;

    @PostMapping("/")
    public ResponseEntity<String> addCumpleanito(@RequestBody Cumpleanito cumpleanito){
        Cumpleanito cumpleanito1 = cumpleanitoService.addCumpleanito(cumpleanito);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(EntityURLBuilder.buildURL(CUMPLEANITO_PATH, cumpleanito1.getId()))
                .contentType(MediaType.APPLICATION_JSON)
                .body("Cumpleanito has been created");
    }

    @GetMapping("/{id}")
    public Cumpleanito getCumpleanitoById(@PathVariable Integer id){
        return cumpleanitoService.getCumpleanitoById(id);
    }

    @PutMapping("/{id}/cumpleaniero/{idPerson}")
    public void addCumpleanieroToCumpleanito(@PathVariable Integer id, @PathVariable Integer idPerson){
        cumpleanitoService.addCumpleanieroToCumpleanito(id, idPerson);
    }

    @PutMapping("/{id}/invitados/{idPerson}")
    public void addPlayerToCumpleanito(@PathVariable Integer id, @PathVariable Integer idPerson) throws Exception {
        cumpleanitoService.addInvitadoToCumpleanito(id, idPerson);
    }

    @GetMapping("/{id}/invitados")
    public List<Player> getListadoInvitados(@PathVariable Integer id) throws IOException, InterruptedException {
        cumpleanitoService.pagoCumpleanito(id);
        return cumpleanitoService.getListado(id);




    }
}
