package com.parcialLabV.parcial.api;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ApiResponse {


    @SerializedName("nombre")
    private String nombre;

    @SerializedName("compra")
    private Double compra;

    @SerializedName("updated_at")
    private Double venta;
}
