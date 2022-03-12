package com.alkemy.pelicula.pelicula.repository;
import com.alkemy.pelicula.pelicula.entity.MoviesEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MovieRepository extends JpaRepository<MoviesEntity, Long>, JpaSpecificationExecutor<MoviesEntity> {

    List<MoviesEntity> findAll(Specification<MoviesEntity> spec);
}
