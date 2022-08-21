package com.pbs.moviesmanager.constants;

import java.util.Arrays;
import java.util.List;

public final class EndpointConstant {
	
	public static final String MOVIES_PATH = "/movies";

	public static final String GET_ALL_MOVIES_PATH = "/getAllMovies";
	public static final String GET_MOVIE_PATH = "/getMovie/{id}";
	public static final String GET_MOVIE_CREATE_EDIT = "/getViewCreateEditMovie";
	public static final String CREATE_MOVIE_PATH = "/createMovie";
	public static final String EDIT_MOVIE_PATH = "/editMovie";
	public static final String DELETE_MOVIE_PATH = "/deleteMovie";
	public static final String EXPORT_MOVIES_EXCEL = "/export/excel";

	public static final String PARAM_ID_PATH = "id";
	public static final String PARAM_MOVIES = "movies";
	public static final String PARAM_MOVIE = "movie";
	
	public static final String TITLE_MOVIES_EXCEL = "Movies";
	public static final List<String> HEADER_EXPORT_EXCEL_MOVIE = Arrays.asList("Name", "Year");
	public static final String DATA_EXPORT_EXCEL_MOVIE = "name, year";
	
	public static final String VIEW_LIST_MOVIES = "listMovies";
	public static final String VIEW_CREATE_EDIT_MOVIE = "createEditMovie";
	
	private EndpointConstant() {
		throw new UnsupportedOperationException();
	}
}
