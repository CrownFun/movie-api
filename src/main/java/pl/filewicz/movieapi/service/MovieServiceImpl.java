package pl.filewicz.movieapi.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.filewicz.movieapi.model.Movie;
import pl.filewicz.movieapi.repository.MovieRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Movie getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        Movie movie = new Movie("Home Alone",1994,"Chris Columbus",7.6);
        movieRepository.save(movie);
        movieRepository.save(new Movie("Predator",1987,"John Mctiernan",8.6));
        movieRepository.save(new Movie("Terminator",1984,"James Cameron",7.9));
        movieRepository.save(new Movie("Shawshank Redemption",1995,"Frank Darabont",8.8));
        movieRepository.save(new Movie("Cast Away",2001,"Robert Zemeckis",7.4));
        System.out.println(movie.getTitle());
    }

}
