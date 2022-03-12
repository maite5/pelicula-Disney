package com.alkemy.pelicula.pelicula.mapper;
import com.alkemy.pelicula.pelicula.dto.ActorDTO;
import com.alkemy.pelicula.pelicula.dto.MovieBasicDTO;
import com.alkemy.pelicula.pelicula.dto.MovieDTO;
import com.alkemy.pelicula.pelicula.entity.MoviesEntity;
import com.alkemy.pelicula.pelicula.entity.ActorEntity;
import org.springframework.stereotype.Component;

import java.util.*;
@Component //
public class MovieMapper {
    private ActorEntity actorEntity;
    private ActorMapper actorMapper;
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
        //dto.setHistory(entity.getHistory());
        if (loadActor){
            List<ActorDTO> actorDTO= this.actorMapper.actorEntityList2DTOList(entity.getActors(), false);
                 //        dto.Actor(actorDTO);
                    dto.setActor(actorDTO);
        }
        return dto;
    }
    //refres
    public void movieEntityRefreshValues(MoviesEntity entity, MovieDTO movieDTO){
        entity.setImageUrl(movieDTO.getImageUrl());
        entity.setTitle(movieDTO.getTitle());
        entity.setFechaCreacion(movieDTO.getFechaCreacion());
        entity.setCalification(movieDTO.getCalification());
        //entity.setHistory(actorDTO.getHistory());

    }
    public Set<MoviesEntity> movieDTOList2Entity(List<MovieDTO> dtos) {
        Set<MoviesEntity> entities = new HashSet<>();
        for (MovieDTO dto : dtos) {
            entities.add(this.movieDTO2Entity(dto));
        }
        return entities;
    }
    public List<MovieDTO> movieEntitySet2DTOList(Collection<ActorEntity> entities, boolean loadActor){
        List<MovieDTO> dtos= new ArrayList<>();
        for (MoviesEntity entity : entities){
            dtos.add(this.movieEntity2DTO(entity, loadActor));
        }
        return dtos;
    }
    public List<MovieBasicDTO> movieEntitySet2BasicDTOList(Collection<MoviesEntity> entities){
        List<MovieBasicDTO> dtos= new ArrayList<>();
        MovieBasicDTO basicDTO;
        for (MoviesEntity entity: entities){
            basicDTO = new MovieBasicDTO();
            basicDTO.setId(entity.getId());
            // basicDTO.setImageUrl(entity.getImageUrl());
            // basicDTO.setName(entity.getName());
            // basicDTO.setAge(entity.getAge());
            // basicDTO.setWeight(entity.getWeight());
            //  basicDTO.setHistory(entity.getHistory());
            basicDTO.setImageUrl(entity.getImageUrl());
            basicDTO.setTitle(entity.getTitle());

          //  basicDTO.setDenomination(entity.getDenomination());
            dtos.add(basicDTO);

        }
        return dtos;
}

    public List<MovieDTO> movieEntityList2DTOList(List<MoviesEntity> moviess, boolean b) {
    }
}