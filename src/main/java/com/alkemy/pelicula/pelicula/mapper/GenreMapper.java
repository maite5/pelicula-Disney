package com.alkemy.pelicula.pelicula.mapper;

import com.alkemy.pelicula.pelicula.dto.GenreDTO;
import com.alkemy.pelicula.pelicula.entity.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GenreMapper {
    public GenreEntity genreDTO2Entity(GenreDTO dto){
        GenreEntity genreEntity= new GenreEntity();
        genreEntity.setImageUrl(dto.getImageUrl());
        genreEntity.setName(dto.getName());
        return genreEntity;
    }
    public  GenreDTO genreEntity2DTO(GenreEntity entity){
        GenreDTO dto= new GenreDTO();
        dto.setId(entity.getId());
        dto.setImageUrl(entity.getImageUrl());
        dto.setName(entity.getName());
        return dto;
    }
    public List<GenreDTO> genreEntityList2DTOList(List<GenreEntity> entities){
        List<GenreDTO> dtos= new ArrayList<>();
        for(GenreEntity entity: entities) {
            dtos.add(this.genreEntity2DTO(entity));
        }
        return dtos;
    }
}
