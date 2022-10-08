package com.pbs.moviesmanager.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.pbs.moviesmanager.model.Movie;
import com.pbs.moviesmanager.model.request.MovieRequest;

public class MovieSpecification {

  public static Specification<Movie> toPredicate(MovieRequest request) {
    return (root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();
      if (request.getName() != null && !request.getName().isEmpty()) {
        predicates.add(
            criteriaBuilder.like(
                criteriaBuilder.lower(root.get("name")),
                "%" + request.getName().toLowerCase() + "%"));
      }

      if (request.getDirector() != null && !request.getDirector().isEmpty()) {
        predicates.add(
            criteriaBuilder.like(
                criteriaBuilder.lower(root.get("director")),
                "%" + request.getDirector().toLowerCase() + "%"));
      }

      if (request.getYear() != null && !request.getYear().isEmpty()) {
        predicates.add(criteriaBuilder.equal(root.get("year"), request.getYear()));
      }

      query.orderBy(criteriaBuilder.desc(root.get("name")));

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
  }
}
