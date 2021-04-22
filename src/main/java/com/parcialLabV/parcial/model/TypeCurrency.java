package com.parcialLabV.parcial.model;

public enum TypeCurrency {
    DOLLAR(140), EURO(160);

    private final Integer conversion;

    TypeCurrency(Integer conversion) {
        this.conversion = conversion;
    }

    public Integer getConversion(){
        return this.conversion;
    }
}
