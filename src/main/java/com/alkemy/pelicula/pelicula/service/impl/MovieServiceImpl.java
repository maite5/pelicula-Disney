package com.alkemy.pelicula.pelicula.service.impl;

import com.alkemy.pelicula.pelicula.dto.*;
import com.alkemy.pelicula.pelicula.entity.MoviesEntity;
import com.alkemy.pelicula.pelicula.exception.ParamNotFound;
import com.alkemy.pelicula.pelicula.mapper.MovieMapper;
import com.alkemy.pelicula.pelicula.repository.MovieRepository;
import com.alkemy.pelicula.pelicula.repository.specification.MovieSpecification;
import com.alkemy.pelicula.pelicula.service.MovieService;
import com.alkemy.pelicula.pelicula.entity.ActorEntity;
import com.alkemy.pelicula.pelicula.mapper.ActorMapper;
import com.alkemy.pelicula.pelicula.repository.ActorRepository;
import com.alkemy.pelicula.pelicula.repository.specification.ActorSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import com.alkemy.pelicula.pelicula.service.ActorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
        public class MovieServiceImpl implements MovieService {
        //@Autowired
        private MovieMapper movieMapper;
        //@Autowired
        private MovieRepository movieRepository;
        private MovieService movieService;
        private MovieSpecification movieSpecification;
        private ActorService actorService;
    @Autowired
     public MovieServiceImpl(
                MovieRepository movieRepository,
                MovieSpecification movieSpecification,
                ActorService actorService,
                MovieMapper movieMapper)  {
            this.movieRepository = movieRepository;
            this.movieSpecification = movieSpecification;
            this.movieMapper = movieMapper;
     //       this.actorService = actorService;
        }
    public MovieDTO getDetailsById(Long id) {
        Optional<MoviesEntity> entity = this.movieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id movie no valido");
        }
        MovieDTO movieDTO = this.movieMapper.movieEntity2DTO(entity.get(), true);
        return movieDTO;
    }

    //filtrar
    public List<MovieBasicDTO> getAll() {
        List<MoviesEntity> entities = this.movieRepository.findAll();
        List<MovieBasicDTO> movieBasicDTOS = this.movieMapper.movieEntitySet2BasicDTOList(entities);
        return movieBasicDTOS;
    }

    public List<MovieDTO> getByFilters(String title, Set<Long> name , String order) {
        MovieFiltersDTO filtersDTO = new MovieFiltersDTO(title,name, order);
        List<MoviesEntity> entities = this.movieRepository.findAll(this.movieSpecification.getByFilters(filtersDTO));
        List<MovieDTO> dtos = this.movieMapper.movieEntitySet2DTOList(entities, true);
        return dtos;
    }

    public MovieDTO save(MovieDTO movieDTO) {
        MoviesEntity entity = this.movieMapper.movieDTO2Entity(movieDTO);
        MoviesEntity entitySaved = this.movieRepository.save(entity);
        MovieDTO result = this.movieMapper.movieEntity2DTO(entitySaved, false);
        return result;
    }

    //update
    public MovieDTO update(Long id, MovieDTO movieDTO) {
        Optional<MoviesEntity> entity = this.movieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id movie no valido");
        }
        this.movieMapper.movieEntityRefreshValues(entity.get(), movieDTO);
        MoviesEntity entitySaved = this.movieRepository.save(entity.get());
        MovieDTO result = this.movieMapper.movieEntity2DTO(entitySaved, false);
        return result;
    }

    public void addActor(Long id, Long idActor) {
        MoviesEntity entity = this.movieRepository.getById(id);
        entity.getActors().size();
        ActorEntity actorEntity = this.actorService.getEntityById(idActor);
        entity.addActor(actorEntity);
        this.movieRepository.save(entity);
    }

    public void removeActor(Long id, Long idActor) {
        MoviesEntity entity = this.movieRepository.getById(id);
        entity.getActors().size();
        ActorEntity actorEntity = this.actorService.getEntityById(idActor);
        entity.removeActor(actorEntity);
        this.movieRepository.save(entity);
    }

    public void delete(Long id) {
        this.movieRepository.deleteById(id);
    }

}




