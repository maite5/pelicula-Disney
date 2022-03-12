package com.alkemy.pelicula.pelicula.dto;
import java.time.LocalDate;
import java.util.List;

import  lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MovieDTO {
    private Long id;
    private String imageUrl;
    private String title;
    private LocalDate fechaCreacion;
    private Long calification;
    //Details of movie and actor
    private List<ActorDTO> actor;
}
