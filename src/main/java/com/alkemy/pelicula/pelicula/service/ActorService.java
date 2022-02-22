package com.alkemy.pelicula.pelicula.service;
import com.alkemy.pelicula.pelicula.dto.ActorDTO;
import java.util.List;
public interface ActorService {
    //public ActorDTO save(ActorDTO dto){
        //save actors
       // System.out.println("SAVE ACTOR");
       // return dto;
      //  ActorDTO save(ActorDTO dto);
       // List<ActorDTO> getAllActor();
    ActorDTO getDetailsById(Long id);
    List<ActorBasicDTO> getAll();
    List<ActorDTO> getByFilters(String name, String imageUrl, String width, String history);
    ActorDTO save(ActorDTO actorDTO);
    ActorDTO update(Long id, ActorDTO actor);
    void addMovie(Long id, Long idMovie);
    void delete(Long id);
    void removeMovie(Long id,Long idMovie);
    }

