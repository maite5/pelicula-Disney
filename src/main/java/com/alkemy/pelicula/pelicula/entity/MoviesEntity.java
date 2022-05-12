package com.alkemy.pelicula.pelicula.entity;
import lombok.Getter;
import lombok.Setter;
//import net.bytebuddy.implementation.bind.annotation.This;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity

@Table(name= "movies")

@Getter

@Setter
@SQLDelete(sql = "UPDATE movie SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class MoviesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imageUrl;
    private String title;
    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern= "yyyy/MM/dd")
    private LocalDate fechaCreacion;
    private Long calification;

    @ManyToOne(fetch= FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name= "genre_id ", insertable = false, updatable = false)
    private GenreEntity genre;
    @Column(name= "genre_id", nullable = false)
    private  Long genreId;
    @ManyToMany(
            cascade= {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            } )
    @JoinTable(
            name= "actor_movies",
            joinColumns= @JoinColumn(name="movies_id"),
            inverseJoinColumns =@JoinColumn(name= "actor_id"))
         private Set<ActorEntity> actors = new HashSet<>();
    //@Override
    public boolean equals(Object obj) {
        if (obj == null)
                return false;
        if (getClass() != obj.getClass()) return false;
        final MoviesEntity other = (MoviesEntity) obj;
        return other.id == this.id;

    }
    //delete and remove actor
    //public void addMovies(MoviesEntity movies) {this.moviess.add(movies);}
    //public void removeMovies(MoviesEntity movies)  {this.moviess.remove(movies);}
    public void addActor(ActorEntity actor) {this.actors.add(actor);}
    public void removeActor(ActorEntity actor)  {this.actors.remove(actor);}

}
