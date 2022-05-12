package com.alkemy.pelicula.pelicula.repository;

import com.alkemy.pelicula.pelicula.entity.GenreEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Long>, JpaSpecificationExecutor<GenreEntity> {
    List<GenreEntity> findAll(Specification<GenreEntity> spec);
}


