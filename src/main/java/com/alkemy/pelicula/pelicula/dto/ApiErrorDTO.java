package com.alkemy.pelicula.pelicula.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ApiErrorDTO {
    private HttpStatus status;
    private  String message;
    private List<String> errors;
}
