package com.alkemy.pelicula.pelicula.mapper;

import antlr.actions.python.CodeLexer;
import com.alkemy.pelicula.pelicula.dto.ActorBasicDTO;
import com.alkemy.pelicula.pelicula.dto.ActorDTO;
import com.alkemy.pelicula.pelicula.entity.ActorEntity;
import com.alkemy.pelicula.pelicula.entity.MoviesEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Component
public class ActorMapper {
    private MoviesEntity moviesEntity;
    public ActorEntity actorDTO2Entity(ActorDTO dto) {
        ActorEntity entity = new ActorEntity();
        entity.setImageUrl(dto.getImageUrl());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setAge(dto.getHistory());
        return entity;
    }
    public ActorDTO actorEntity2DTO(ActorEntity entity, boolean loadMovie){
        ActorDTO dto= new ActorDTO();
        dto.setId(entity.getId());
        dto.setImageUrl(entity.getImageUrl());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());
        if (loadMovie){
            List<MovieDTO> movieDTO= this.movieMapper.movieEntityList2DTOList(entity.getMoviess(),
                    dto.Movies(movieDTO);
        }
        return dto;
    }
    //refres
    public void actorEntityRefreshValues(ActorEntity entity, ActorDTO actorDTO){
        entity.setImageUrl(actorDTO.getImageUrl());
        entity.setName(actorDTO.getName());
        entity.setAge(actorDTO.getAge());
        entity.setWeight(actorDTO.getWeight());
        entity.setHistory(actorDTO.getHistory());

    }
    public Set<ActorEntity> actorDTOLis2Entity(List<actorDTO> dtos) {
        Set<ActorEntity> entities = new HashSet<>();
        for (ActorDTO dto : dtos) {
            entities.add(this.actorDTO2Entity(dto));
        }
        return entities;
    }
    public List<ActorDTO> actorEntitySet2DTOList(Collection<ActorEntity> entities, boolean loadMovie){
        List<ActorDTO> dtos= new ArrayList<>();
        for (ActorEntity entity : entities){
            dtos.add(this.actorEntity2DTO(entity, loadMovie));
        }
        return dtos;
    }
    public List<ActorBasicDTO> actorEntitySet2BasicDTOList(Collection<ActorEntity> entities){
    List<ActorBasicDTO> dtos= new ArrayList<>();
    ActorBasicDTO basicDTO;
    for (ActorEntity entity: entities){
        basicDTO = new ActorBasicDTO();
        basicDTO.setId(entity.getId());
       // basicDTO.setImageUrl(entity.getImageUrl());
        basicDTO.setName(entity.getName());
       // basicDTO.setAge(entity.getAge());
       // basicDTO.setWeight(entity.getWeight());
      //  basicDTO.setHistory(entity.getHistory());
        dtos.add(basicDTO);

    }
    return dtos;
}

}
