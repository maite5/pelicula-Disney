package com.alkemy.pelicula.pelicula.mapper;
import com.alkemy.pelicula.pelicula.dto.ActorDTO;
import com.alkemy.pelicula.pelicula.dto.GenreDTO;
import com.alkemy.pelicula.pelicula.dto.MovieBasicDTO;
import com.alkemy.pelicula.pelicula.dto.MovieDTO;
import com.alkemy.pelicula.pelicula.entity.GenreEntity;
import com.alkemy.pelicula.pelicula.entity.MoviesEntity;
import com.alkemy.pelicula.pelicula.entity.ActorEntity;
import org.springframework.stereotype.Component;

import java.util.*;
@Component //
public class MovieMapper {
    private ActorEntity actorEntity;
    private ActorMapper actorMapper;
    private GenreMapper genreMapper;
    private MovieMapper movieMapper;
    public MoviesEntity movieDTO2Entity(MovieDTO dto) {
        MoviesEntity entity = new MoviesEntity();
        entity.setImageUrl(dto.getImageUrl());
        entity.setTitle(dto.getTitle());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setCalification(dto.getCalification());
        return entity;
    }
  public MovieDTO movieEntity2DTO(MoviesEntity entity, boolean loadActor){
      MovieDTO dto= new MovieDTO();
        dto.setId(entity.getId());
        dto.setImageUrl(entity.getImageUrl());
        dto.setTitle(entity.getTitle());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setCalification(entity.getCalification());
       // dto.setHistory(entity.getHistory());
	//esto no lo cambie quizas modificar por genre
        /*if (loadMovie){ //no lo cambie por genre
            List<MovieDTO> movieDTO= this.movieMapper.moviesEntityList2DTOList(entity.getMoviess(), false);
            dto.setMoviess(movieDTO);
        } */
      if (loadActor){ //no lo cambie por genre
          List<ActorDTO> actorDTO= this.actorMapper.actorEntitySet2DTOList(entity.getActors(), false);
          dto.setActor(actorDTO);
      }
        return dto;
    }
    // refresh es el buscador
    public void movieEntityRefreshValues(MoviesEntity entity, MovieDTO movieDTO){
        entity.setImageUrl(movieDTO.getImageUrl());
        entity.setTitle(movieDTO.getTitle());
        entity.setFechaCreacion(movieDTO.getFechaCreacion());
        entity.setCalification(movieDTO.getCalification());
       // entity.setHistory(dto.getHistory());

    } //linea 56
    public List<MoviesEntity> movieDTOList2Entity(List<MovieDTO> dtos) {
        List<MoviesEntity> entities = new ArrayList<>();
        for (MovieDTO dto : dtos) {
            entities.add(this.movieDTO2Entity(dto));
        }
        return entities;
    } //linea 48
    //public List<MovieDTO> moviesEntityList2DTOList(Collection<MoviesEntity> entities, boolean loadMovie){
    public List<MovieDTO> moviesEntityList2DTOList(List<MoviesEntity> entities, boolean loadActor){
        List<MovieDTO> dtos= new ArrayList<>(); //no cambie por genre
        for (MoviesEntity entity : entities){
            dtos.add(this.movieEntity2DTO(entity, loadActor));
        }
        return dtos;
    }
    public List<MovieBasicDTO> moviesEntitySet2BasicDTOList(Collection<MoviesEntity> entities){
        List<MovieBasicDTO> dtos= new ArrayList<>();
        MovieBasicDTO basicDTO;
        for (MoviesEntity entity: entities){
            basicDTO = new MovieBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImageUrl(entity.getImageUrl());
            basicDTO.setTitle(entity.getTitle());
		    basicDTO.setFechaCreacion(entity.getFechaCreacion());
            // basicDTO.setAge(entity.getAge());
            // basicDTO.setWeight(entity.getWeight());
            //  basicDTO.setHistory(entity.getHistory());
            //  basicDTO.setDenomination(entity.getDenomination());
            dtos.add(basicDTO);
        }
        return dtos;
    }

  //  public List<ActorDTO> actorEntityList2DTOList(Set<ActorEntity> actors, boolean b) {
    //}
}