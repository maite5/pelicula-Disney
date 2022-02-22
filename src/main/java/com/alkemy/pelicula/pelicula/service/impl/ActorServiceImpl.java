package com.alkemy.pelicula.pelicula.service.impl;
import com.alkemy.pelicula.pelicula.dto.ActorBasicDTO;
import com.alkemy.pelicula.pelicula.dto.ActorDTO;
import com.alkemy.pelicula.pelicula.dto.ActorFiltersDTO;
import com.alkemy.pelicula.pelicula.entity.ActorEntity;
import com.alkemy.pelicula.pelicula.mapper.ActorMapper;
import com.alkemy.pelicula.pelicula.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.alkemy.pelicula.pelicula.service.ActorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{
    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private ActorRepository actorRepository;
    public ActorDTO save(ActorDTO dto){
        ActorEntity entity = actorMapper.actorDTO2Entity(dto);
        ActorEntity entitySaved = actorRepository.save(entity);
        ActorDTO result= actorMapper.actorEntity2DTO(entitySaved);
        return result;
    }
    @Override
    public List<ActorDTO> getAllActor(){
        List<ActorEntity> entities = this.actorRepository.findAll();
        List<ActorDTO> result = this.actorMapper.actorEntityList2DTOList(entities);

        return result;
    }
    //filtrar
        public List<ActorBasicDTO> getAll(){
        List<ActorEntity> entities= this.actorRepository.findAll();
        List<ActorBasicDTO> actorBasicDTOS= this.actorMapper.actorEntitySet2BasicDTOList(entities);
        return actorBasicDTOS;
    }
     //   public List<ActorDTO> getByFilters(String name, String imageUrl){
     //   ActorFiltersDTO filtersDTO = new ActorFiltersDTO(name, imageUrl);
        public List<ActorDTO> getByFilters(String name, String age, String title, String order){
        ActorFiltersDTO filtersDTO = new ActorFiltersDTO(name, age, title, order);
        List<ActorEntity> entities= this.actorRepository.findAll(this.actorSpecification.getByFilters(filtersDTO));
        List<ActorDTO> dtos = this.actorMapper.actorEntitySet2DTOList(entities, true);
        return dtos;
    }
        public ActorDTO save(ActorDTO actorDTO){
        ActorEntity entity= this.actorMapper.actorDTO2Entity(actorDTO);
        ActorEntity entitySaved= this.actorRepository.save(entity);
        ActorEntity result =this.actorMapper.actorEntity2DTO(entitySaved, false);
        return result;
    }
    }