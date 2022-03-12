package com.alkemy.pelicula.pelicula.dto;

import java.time.LocalDate;
import  lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class MovieFiltersDTO {
  /*  Deberá permitir buscar por título, y filtrar por género. Además, permitir ordenar los resultados por
    fecha de creación de forma ascendiente o descendiente. */
    private Long id;
 //   private String imageUrl;
    private String title;
    private LocalDate fechaCreacion;
   // private Long calification;
    private String order;
    private String genre;
    public MovieFiltersDTO(String title, LocalDate fechaCreacion, String order, String genre) {
        this.title = title;
        //   this.imageUrl = imageUrl;
        this.fechaCreacion= fechaCreacion;
        this.order= order;
        this.genre= genre;
    }
    public boolean isASC() {
        return this.order.compareToIgnoreCase("ASC")==0;
    }
    public boolean isDESC() {
        return this.order.compareToIgnoreCase("DESC")==0;
    }
}
