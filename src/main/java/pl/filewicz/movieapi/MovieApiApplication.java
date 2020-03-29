package pl.filewicz.movieapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.filewicz.mapper.MovieMapper;
import pl.filewicz.movieapi.model.Movie;
import pl.filewicz.movieapi.model.MovieDto;
import pl.filewicz.movieapi.model.Status;

@SpringBootApplication
public class MovieApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);

		Movie movie = new Movie("Predator",1987,"John Mctiernan",8.6,Status.DO_OBEJRZENIA);
		MovieDto movieDto = MovieMapper.INSTANCE.movieToMovieDto(movie);

		System.out.println(movieDto);

	}

}
