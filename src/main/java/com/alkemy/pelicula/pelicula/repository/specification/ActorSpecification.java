package com.alkemy.pelicula.pelicula.repository.specification;

import antlr.StringUtils;
import com.alkemy.pelicula.pelicula.dto.ActorFiltersDTO;
import com.alkemy.pelicula.pelicula.entity.ActorEntity;
import com.alkemy.pelicula.pelicula.entity.MoviesEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import java.util.regex.Pattern;
@Component
public class ActorSpecification {
    public Specification<ActorEntity> getByFilters(ActorFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denomination")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"));
            }

            //    public Specification<ActorEntity> getByFilters(ActorFiltersDTO filtersDTO){
            //     return (root, query, criteriaBuilder) ->{
            //        List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(filtersDTO.getAge())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denomination")),
                                "%" + filtersDTO.getAge().toLowerCase() + "%"));
            }
            /*
            if (StringUtils.hasLength(filtersDTO.getfechaCreacion())){
                /// todo reuse this in a function
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(filtersDTO.getFechaCreacion(), formatter);
                predicates.add(
                        criteriaBuilder.equal(root.<>get("fechaCreacion"), date)
                );
            } */
            if (!CollectionUtils.isEmpty(filtersDTO.getTitle())) {
                Join<MoviesEntity, ActorEntity> join = root.join("movie", JoinType.INNER);
                Expression<String> titleId = join.get("id");
                predicates.add(titleId.in(filtersDTO.getTitle()));
            }
            //remove duplicates
            query.distinct(true);

            //ordr resolving
            String orderByField = "denomination"; //denominacion
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))

            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}