package com.alkemy.pelicula.pelicula.dto;
import  lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ActorDTO {
    private Long id;
    private String imageUrl;
    private String name;
    private String age;
    private Float weight;
    private String history;
    private List<MovieDTO> moviess;
}
