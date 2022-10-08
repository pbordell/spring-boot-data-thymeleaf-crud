package com.pbs.moviesmanager.mapper;

import java.io.IOException;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;

import com.pbs.moviesmanager.dto.MovieDTO;
import com.pbs.moviesmanager.model.Movie;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MovieMapper {

	@AfterMapping
	default void outMappingsDTO(@MappingTarget Movie target, MovieDTO source) throws IOException {
		if (source.getCoverMultipart() != null) {
			target.setCover(source.getCoverMultipart().getBytes());
		} else {
			target.setCover(null);
		}
	}

	Movie fromDTO(MovieDTO source) throws IOException;

	MovieDTO toDTO(Movie source);

	List<MovieDTO> toListDTO(List<Movie> source);

}