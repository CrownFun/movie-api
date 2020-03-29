package pl.filewicz.movieapi.service;

import pl.filewicz.movieapi.model.Movie;

import java.util.List;

public interface MovieService {

    void saveMovie(Movie movie);

    Movie getMovieByTitle(String title);

    List<Movie> getAllMovies();

}
