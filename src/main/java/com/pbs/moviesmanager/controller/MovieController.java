package com.pbs.moviesmanager.controller;

import com.google.common.base.Optional;
import com.pbs.moviesmanager.constants.EndpointConstant;
import com.pbs.moviesmanager.dto.MovieDTO;
import com.pbs.moviesmanager.mapper.MovieMapper;
import com.pbs.moviesmanager.model.Movie;
import com.pbs.moviesmanager.model.request.MovieRequest;
import com.pbs.moviesmanager.service.MovieService;
import org.jxls.template.SimpleExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(EndpointConstant.MOVIES_PATH)
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieMapper movieMapper;
	
	@GetMapping(path = EndpointConstant.GET_ALL_MOVIES_PATH)
	public String getAllMovies(@PageableDefault(page = 0, size = 5, sort = "name") Pageable pageable,
			@ModelAttribute MovieRequest movieRequest, Model model) {
		Page<Movie> page = movieService.findAllMovies(movieRequest, pageable);
		model.addAttribute("movieRequest", movieRequest);
		model.addAttribute("page", page);

		return EndpointConstant.VIEW_LIST_MOVIES;
	}
	
	@GetMapping(path = EndpointConstant.GET_MOVIE_CREATE_EDIT)
	public String viewCreateMovies(@RequestParam(required = false) Long id, Model model) {
		if (id != null) {
			Movie result = movieService.getMovieById(id);
			model.addAttribute(EndpointConstant.PARAM_MOVIE, movieMapper.toDTO(result));
		} else {
			model.addAttribute(EndpointConstant.PARAM_MOVIE, new MovieDTO());
		}
		return EndpointConstant.VIEW_CREATE_EDIT_MOVIE;
	}
	
	@PostMapping(path = EndpointConstant.CREATE_MOVIE_PATH)
	public String createMovie(@Valid @ModelAttribute MovieDTO movieDTO) {
		movieService.createMovie(movieMapper.fromDTO(movieDTO));
        return "redirect:" + EndpointConstant.MOVIES_PATH + EndpointConstant.GET_ALL_MOVIES_PATH;
	}
	
	@PutMapping(path = EndpointConstant.EDIT_MOVIE_PATH)
	public String editMovie(@Valid @RequestParam Long id, @ModelAttribute MovieDTO movieDTO) {
		if (movieService.getMovieById(id) != null)
			movieService.updateMovie(movieMapper.fromDTO(movieDTO));
        return "redirect:" + EndpointConstant.MOVIES_PATH + EndpointConstant.GET_ALL_MOVIES_PATH;
	}
	
	@DeleteMapping(path = EndpointConstant.DELETE_MOVIE_PATH)
	public String deleteMovie(@RequestParam Long id) {
		movieService.deleteMovie(id);
        return "redirect:" + EndpointConstant.MOVIES_PATH + EndpointConstant.GET_ALL_MOVIES_PATH;
	}
	
	@GetMapping(path = EndpointConstant.EXPORT_MOVIES_EXCEL)
	public void export(HttpServletResponse response) throws IOException {
		List<Movie> listJobs = movieService.getAllMovies();

		response.addHeader("Content-disposition", "attachment; filename=Jobs_" + LocalDateTime.now() + ".xls");
		response.setContentType("application/vnd.ms-excel");
		new SimpleExporter().gridExport(EndpointConstant.HEADER_EXPORT_EXCEL_MOVIE, listJobs,
				EndpointConstant.DATA_EXPORT_EXCEL_MOVIE, response.getOutputStream());
		response.flushBuffer();

	}

	@GetMapping("/image")
	@ResponseBody
	public void showImage(@Param("id") Long id, HttpServletResponse response)
			throws IOException {

		Movie movie = movieService.getMovieById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
		response.getOutputStream().write(movie.getCover());
		response.getOutputStream().close();
	}

}
