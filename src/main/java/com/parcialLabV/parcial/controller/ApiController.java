package com.parcialLabV.parcial.controller;

import com.parcialLabV.parcial.api.ApiResponse;
import com.parcialLabV.parcial.service.ApiCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiCallService apiCallService;

    @GetMapping("/dolar")
    public ApiResponse getDolar() throws IOException, InterruptedException {
        return apiCallService.getDolar();
    }

    @GetMapping("/euro")
    public ApiResponse getEuro() throws IOException, InterruptedException {
        return apiCallService.getEuro();
    }
}
