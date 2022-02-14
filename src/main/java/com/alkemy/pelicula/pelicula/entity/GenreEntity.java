package com.alkemy.pelicula.pelicula.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity

@Table(name="genre")

@Getter

@Setter

public class GenreEntity {
    @Id

    @GeneratedValue(strategy =GenerationType.SEQUENCE)

    private Long id;

    private String name;

    private String imageUrl;
}
