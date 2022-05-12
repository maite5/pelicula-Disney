package com.alkemy.pelicula.pelicula.service.impl;

import com.alkemy.pelicula.pelicula.dto.GenreDTO;
import com.alkemy.pelicula.pelicula.entity.GenreEntity;
import com.alkemy.pelicula.pelicula.mapper.GenreMapper;
import com.alkemy.pelicula.pelicula.repository.GenreRepository;
import com.alkemy.pelicula.pelicula.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private GenreRepository genreRepository;

    public GenreDTO save(GenreDTO dto){
        GenreEntity entity= genreMapper.genreDTO2Entity(dto);
        GenreEntity entitySaved= genreRepository.save(entity);
        GenreDTO result = genreMapper.genreEntity2DTO(entitySaved);
        return  result;
    }
    public List<GenreDTO>getAllGenre(){
        List<GenreEntity> entities = genreRepository.findAll();
        List<GenreDTO> result= GenreMapper.genreEntityList2DTOList(entities);
        return result;

    }
}
