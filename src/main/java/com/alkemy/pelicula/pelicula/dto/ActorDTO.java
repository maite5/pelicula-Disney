package com.alkemy.pelicula.pelicula.dto;
import  lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ActorDTO {
    private Long id;
    private String imageUrl;
    private String name;
    private String age;
    private Float weight;
    private String history;
}
