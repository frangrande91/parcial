package com.parcialLabV.parcial.model;


public enum TypePerson {
    MANAGER("Player's manager"),
    PLAYER("Football player");

    private String description;

    TypePerson(String description){
        this.description = description;
    }

    public static TypePerson find(String value){
        for(TypePerson p : values()){
            if(p.toString().equalsIgnoreCase(value))
                return p;

        }
        throw new IllegalArgumentException(String.format("Invalid TypePerson: %s", value));
    }

    public String getDescription() {
        return description;
    }

}
