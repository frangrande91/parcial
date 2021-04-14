package com.parcialLabV.parcial.model;


public enum TipoPersona {
    REPRESENTANTE("Representante de jugadores"),
    JUGADOR("Jugador de futbol");

    private String description;

    TipoPersona(String description){
        this.description = description;
    }

    public static TipoPersona find(String value){
        for(TipoPersona n : values()){
            if(n.toString().equalsIgnoreCase(value))
                return n;

        }
        throw new IllegalArgumentException(String.format("Invalid TypeVehicle: %s", value));
    }

    public String getDescription() {
        return description;
    }

}
