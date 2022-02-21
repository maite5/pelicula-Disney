package com.alkemy.pelicula.pelicula.controller;

import com.alkemy.pelicula.pelicula.dto.GenreDTO;
import com.alkemy.pelicula.pelicula.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genre){
    GenreDTO genreSave= genreService.save(genre);
     return ResponseEntity.status(HttpStatus.CREATED).body(genreSave);
}}
