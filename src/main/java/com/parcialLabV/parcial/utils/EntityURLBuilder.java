package com.parcialLabV.parcial.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

//Clase creada para crear y retornar url de un objeto agregado
public class EntityURLBuilder {
    public static URI buildURL(String entity, Integer id){
        return ServletUriComponentsBuilder
                .fromCurrentContextPath() //ContextPath es donde estamos parados (localhost:8080/personas) y el metodo fromCurrentContextPath concatena el emtity y el id
                .path("/{entity}/{id}")
                .buildAndExpand(entity, id) //inyecta los parametros pasados
                .toUri();




    }
}
