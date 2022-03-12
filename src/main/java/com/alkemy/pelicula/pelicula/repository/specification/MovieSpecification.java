package com.alkemy.pelicula.pelicula.repository.specification;
import antlr.StringUtils;
import com.alkemy.pelicula.pelicula.dto.MovieFiltersDTO;
import com.alkemy.pelicula.pelicula.entity.ActorEntity;
import com.alkemy.pelicula.pelicula.entity.MoviesEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import java.time.format.DateTimeFormatter;
public class MovieSpecification {
     //imageUrl, title, fechaCreacion,calification
    public Specification<MoviesEntity> getByFilters(MovieFiltersDTO filtersDTO){
        return (root, query, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
           /* if (StringUtils.hasLength(filtersDTO.getImageUrl())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                             "%" + filtersDTO.getImageUrl().toLowerCase() + "%") );
            }*/

            if (StringUtils.hasLength(filtersDTO.getTitle())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),
                                 "%" + filtersDTO.getTitle().toLowerCase() + "%") );
            }

            if (StringUtils.hasLength(filtersDTO.getFechaCreacion())){
                /// todo reuse this in a function
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(filtersDTO.getFechaCreacion(), formatter);
                predicates.add(
                        criteriaBuilder.equal(root.<LocalDate>get("fechaCreacion"), date)
                );
            }/*
            if (!CollectionUtils.isEmpty(filtersDTO.getTitle())){
                Join<ActorEntity, MoviesEntity> join = root.join("actor", JoinType.INNER);
                Expression<String> movies_Id = join.get("id");
                predicates.add(movies_Id.in(filtersDTO.getTitle()));
            }
            if (!CollectionUtils.isEmpty(filtersDTO.getName())){
                Join<ActorEntity, MoviesEntity> join = root.join("actor", JoinType.INNER);
                Expression<String> actor_id = join.get("id");
                predicates.add(actor_id.in(filtersDTO.getName()));
            } */

            //remove duplicates
            query.distinct(true);
        //}
        //ordr resolving
        String orderByField = "fechaCreacion"; //denominacion
        query.orderBy(
                filtersDTO.isASC()?
                        criteriaBuilder.asc(root.get(orderByField)):
                        criteriaBuilder.desc(root.get(orderByField))

        );
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
}
     }

