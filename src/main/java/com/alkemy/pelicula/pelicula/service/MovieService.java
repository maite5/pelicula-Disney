package com.alkemy.pelicula.pelicula.service;

import com.alkemy.pelicula.pelicula.dto.ActorDTO;
import com.alkemy.pelicula.pelicula.dto.MovieBasicDTO;
import com.alkemy.pelicula.pelicula.dto.MovieDTO;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {
    MovieDTO getDetailsById(Long id);
    List<MovieBasicDTO> getAll();
    List<MovieDTO> getByFilters(String imageUrl, String title, LocalDate fechaCreacion, String order);
    MovieDTO save(MovieDTO movieDTO);
    MovieDTO update(Long id, MovieDTO movie);

    void addActor(Long id, Long idActor);
    void delete(Long id);
    void removeMovie(Long id,Long idActor);
}
