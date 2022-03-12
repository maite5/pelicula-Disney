package com.alkemy.pelicula.pelicula.dto;

import java.time.LocalDate;
import  lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MovieBasicDTO {
    private Long id;
    private String imageUrl;
    private String title;
    private LocalDate fechaCreacion;
}
