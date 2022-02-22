package com.alkemy.pelicula.pelicula.repository;

import com.alkemy.pelicula.pelicula.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<ActorEntity, Long > {

}
