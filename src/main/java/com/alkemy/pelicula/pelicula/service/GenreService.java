package com.alkemy.pelicula.pelicula.service;

import com.alkemy.pelicula.pelicula.dto.GenreDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {
    //public GenreService save(GenreDTO dto){
        //save all genre
     //   System.out.println("save genre");
    //    return dto;
  //  } //lo q viene lo coloco el 4/14/2022
    GenreDTO save(GenreDTO dto);
    List<GenreDTO> getAllGenre();

}
