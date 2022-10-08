package com.pbs.moviesmanager.repository;

import com.pbs.moviesmanager.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

  Page<Movie> findAll(Specification<Movie> spec, Pageable pageable);

  Movie findByName(String name);
}
