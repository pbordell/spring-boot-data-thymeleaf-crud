package com.pbs.moviesmanager.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pbs.moviesmanager.dto.MovieDTO;
import com.pbs.moviesmanager.model.Movie;

@Mapper(componentModel = "spring")
public interface MovieMapper {

	Movie fromDTO(MovieDTO source);

	MovieDTO toDTO(Movie source);

	List<MovieDTO> toListDTO(List<Movie> source);

}