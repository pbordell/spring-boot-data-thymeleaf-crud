package com.pbs.moviesmanager.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pbs.moviesmanager.model.Movie;
import com.pbs.moviesmanager.model.request.MovieRequest;
import com.pbs.moviesmanager.repository.MovieRepository;
import com.pbs.moviesmanager.service.MovieService;
import com.pbs.moviesmanager.specification.MovieSpecification;

@Transactional
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie getMovieById(Long movieId) {
		return movieRepository.getOne(movieId);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}
	
	@Override
	public Page<Movie> findAllMovies(MovieRequest movieRequest, Pageable pageable) {
		if (movieRequest == null) {
			movieRequest = new MovieRequest();
		}
		return movieRepository.findAll(MovieSpecification.toPredicate(movieRequest), pageable);
	}

	@Override
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public void deleteMovie(Long movieId) {
		movieRepository.deleteById(movieId);
	}
}
