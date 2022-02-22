package com.alkemy.pelicula.pelicula.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import  lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Service
public class MovieController {
    @PostMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> addMovie(@PathVariable Long id, @PathVariable Long idMovie){
        this.actorService.addMovie(id, idMovie);
        return  ResponseEntity.status((HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> removeMovie(@PathVariable Long id, @PathVariable long idMovie){
        this.actorService.removeMovies(id, idMovie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
