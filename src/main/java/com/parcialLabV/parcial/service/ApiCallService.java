package com.parcialLabV.parcial.service;

import com.google.gson.Gson;
import com.parcialLabV.parcial.api.ApiResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class ApiCallService {

    @CircuitBreaker(name = "euro", fallbackMethod = "fallback")
    public ApiResponse getEuro() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dolarsi.com/api/api.php?type=genedolar&opc=ta"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


        return new Gson().fromJson(response.body(), ApiResponse.class);
    }

    @CircuitBreaker(name = "dolar", fallbackMethod = "fallback")
    public ApiResponse getDolar() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dolarsi.com/api/api.php?type=dolar"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


        return new Gson().fromJson(response.body(), ApiResponse.class);
    }

    public ApiResponse fallback(Throwable t){
        log.info("fallback cause, {}", toString());
        return ApiResponse.builder().build();
    }
}
