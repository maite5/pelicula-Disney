package com.alkemy.pelicula.pelicula.service;

import com.alkemy.pelicula.pelicula.dto.ActorDTO;
import com.alkemy.pelicula.pelicula.dto.MovieBasicDTO;
import com.alkemy.pelicula.pelicula.dto.MovieDTO;
import com.alkemy.pelicula.pelicula.entity.MoviesEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface MovieService {
    MovieDTO getDetailsById(Long id);
    List<MovieBasicDTO> getAll();
    List<MovieDTO> getByFilters(String title, Set<Long> name, String order);
    MovieDTO save(MovieDTO movieDTO);
    MovieDTO update(Long id, MovieDTO movie);

    void addActor(Long id, Long idActor);
    void delete(Long id);
    void removeActor(Long id,Long idActor);
//agregad 12/03
    void  addGenre(Long id, Long idGenre);
    void removeGenre(Long id, Long idGenre);
//creado 27/04/2022
    MoviesEntity getEntityById(Long idMovie);
}
