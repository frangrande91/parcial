package com.parcialLabV.parcial.model;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.net.URI;

@Builder
public class PostResponse {

    private URI url;
    private HttpStatus httpStatus;
}
