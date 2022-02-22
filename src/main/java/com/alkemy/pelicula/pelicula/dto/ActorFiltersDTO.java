package com.alkemy.pelicula.pelicula.dto;

import  lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service     //here search
public class ActorFiltersDTO {
    private String name;
  //  private String imageUrl;
    private String age;
    private String order;
    public ActorFiltersDTO(String name, String age, String title, String order) {
        this.name = name;
     //   this.imageUrl = imageUrl;
        this.age= age;
        this.title= title;
        this.order= order;
    }
    public boolean isASC() {
        return this.order.compareToIgnoreCase("ASC")==0;
    }
    public boolean isDESC() {
        return this.order.compareToIgnoreCase("DESC")==0;
    }
}