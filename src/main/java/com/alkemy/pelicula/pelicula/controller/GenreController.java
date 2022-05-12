package com.alkemy.pelicula.pelicula.controller;
import com.alkemy.pelicula.pelicula.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class GenreController {
    MovieService movieService;
    @PostMapping("/{id}/genre/{idGenre}")
    public ResponseEntity<Void> addGenre(@PathVariable Long id, @PathVariable Long idGenre){
        this.movieService.addGenre(id, idGenre);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/genre/{idGenre}")
    public ResponseEntity<Void> removeGenre(@PathVariable Long id, @PathVariable Long idGenre){
        this.movieService.removeGenre(id, idGenre);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
