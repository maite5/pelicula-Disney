package com.alkemy.pelicula.pelicula.controller;
import com.alkemy.pelicula.pelicula.dto.MovieBasicDTO;
import com.alkemy.pelicula.pelicula.dto.MovieDTO;
import com.alkemy.pelicula.pelicula.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController{
    private MovieService movieService;
  /*  @Autowired
    private MovieService = movieService;
    @PostMapping
    public  ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie){
        MovieDTO movieGuardado = movieService.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieGuardado);
    } */


    /*
    @PostMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> addMovie(@PathVariable Long id, @PathVariable Long idMovie){
        this.actorService.addMovie(id, idMovie);
        return  ResponseEntity.status((HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> removeMovie(@PathVariable Long id, @PathVariable long idMovie){
        this.actorService.removeMovies(id, idMovie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } */
    @Autowired
    public MovieController(MovieService movieService){ this.movieService = movieService;}
    @GetMapping("/all")
    public ResponseEntity<List<MovieBasicDTO>> getAll() {
        List<MovieBasicDTO> movies = this.movieService.getAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}") //31 word
    public  ResponseEntity<MovieDTO> getDetailsById(@PathVariable Long id){
        MovieDTO movie =this.movieService.getDetailsById(id);
        return ResponseEntity.ok(movie);
    }
    @GetMapping
    public ResponseEntity<List<MovieDTO>>getDetailsByFilters(
            //  @RequestParam(required = false) String name,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String fechaCreacion,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ) {
        List<MovieDTO> movie = this.movieService.getByFilters(title,fechaCreacion,order);
        return ResponseEntity.ok(movie);
    }
    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie){
        MovieDTO result = this.movieService.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO movie){
        MovieDTO result= this.movieService.update(id, movie);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PostMapping("/{id}/actor/{idActor}")
    public ResponseEntity<Void> addActor(@PathVariable Long id, @PathVariable Long idActor){
        this.actorService.addActor(id, idActor);
        return ResponseEntity.status(HttpStatus.CREATED).build(); //69
    }
    @DeleteMapping("/{id}/actor/{idActor}")
    public ResponseEntity<Void> removeActor(@PathVariable Long id, @PathVariable Long idActor){
        this.actorService.removeActor(id, idActor);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}