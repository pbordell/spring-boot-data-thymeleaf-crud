package com.pbs.moviesmanager.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pbs.moviesmanager.model.Movie;
import com.pbs.moviesmanager.model.request.MovieRequest;

public interface MovieService {

  Movie getMovieById(Long movieId);

  List<Movie> getAllMovies();
  
  Page<Movie> findAllMovies(MovieRequest movieRequest, Pageable pageable);
  
  Movie createMovie(Movie movie);
  
  Movie updateMovie(Movie movie);
  
  void deleteMovie(Long movieId);
  
}
