package com.pbs.moviesmanager.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbs.moviesmanager.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	public Page<Movie> findAll(Specification<Movie> spec, Pageable pageable);
	
    public List<Movie> findAll(Specification<Movie> spec);
	
}
