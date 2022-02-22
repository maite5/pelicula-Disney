package com.alkemy.pelicula.pelicula.entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="actor")
@Getter
@Setter
@SQLDelete(sql= "UPDATE actor delete = true WHERE id=?")
@Where(clause= "delete=false")
public class ActorEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE)
    private Long id;
    private String imageUrl;
    private String name;
    private String age;
    private Float weight;
    private String history;
    private boolean deleted= Boolean.FALSE;
    @ManyToMany(mappedBy="actors", cascade=CascadeType.ALL)
    private List<MoviesEntity> moviess= new ArrayList<>();

    //delete and remove movies
    public void addMovies(MoviesEntity movies) {this.moviess.add(movies);}
    public void removeMovies(MoviesEntity movies)  {this.moviess.remove(movies);}
}
