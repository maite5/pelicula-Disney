package com.alkemy.pelicula.pelicula.service.impl;

import com.alkemy.pelicula.pelicula.dto.*;
import com.alkemy.pelicula.pelicula.entity.MoviesEntity;
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

    @Service
        public class MovieServiceImpl implements MovieService {
        @Autowired
        private MovieMapper movieMapper;
        @Autowired
        private MovieRepository movieRepository;
        private MovieService movieService;
        private MovieSpecification movieSpecification;
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
        public MovieDTO save(MovieDTO dto){
            MoviesEntity entity = movieMapper.movieDTO2Entity(dto);
            MoviesEntity entitySaved = movieRepository.save(entity);
            MovieDTO result= movieMapper.movieEntity2DTO(entitySaved);
            return result;
        }
        @Override
        public List<MovieDTO> getAllMovie(){
            List<MoviesEntity> entities = this.movieRepository.findAll();
            List<MovieDTO> result = this.movieMapper.movieEntityList2DTOList(entities);

            return result;
        }
        //filtrar
        public List<MovieBasicDTO> getAll(){
            List<MoviesEntity> entities= this.movieRepository.findAll();
            List<MovieBasicDTO> movieBasicDTOS= this.movieMapper.movieEntitySet2BasicDTOList(entities);
            return movieBasicDTOS;
        }
        //   public List<ActorDTO> getByFilters(String name, String imageUrl){
        //   ActorFiltersDTO filtersDTO = new ActorFiltersDTO(name, imageUrl);
        public List<MovieDTO> getByFilters(String title, LocalDate fechaCreacion, String order,String genre){
            MovieFiltersDTO filtersDTO = new MovieFiltersDTO(title, fechaCreacion, order,genre);
            List<MoviesEntity> entities= this.movieRepository.findAll(this.movieSpecification.getByFilters(filtersDTO));
            List<MovieDTO> dtos = this.movieMapper.movieEntitySet2DTOList(entities, true);
            return dtos;
        } /*
        public MovieDTO save(MovieDTO movieDTO){
            MoviesEntity entity= this.movieMapper.movieDTO2Entity(movieDTO);
            MoviesEntity entitySaved= this.movieRepository.save(entity);
            MovieDTO result =this.movieMapper.movieEntity2DTO(entitySaved, false);
            return result;
        } */
}
