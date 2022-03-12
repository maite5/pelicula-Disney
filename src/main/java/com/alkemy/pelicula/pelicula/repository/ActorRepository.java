package com.alkemy.pelicula.pelicula.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.alkemy.pelicula.pelicula.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long>, JpaSpecificationExecutor<ActorEntity> {
    List<ActorEntity> findAll(Specification<ActorEntity> spec);
}
