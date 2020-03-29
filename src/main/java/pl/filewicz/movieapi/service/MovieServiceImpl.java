package pl.filewicz.movieapi.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.filewicz.movieapi.model.Genre;
import pl.filewicz.movieapi.model.Movie;
import pl.filewicz.movieapi.model.Status;
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
        movieRepository.save(new Movie("Predator",1987,"John Mctiernan",8.6, Genre.ACTION,300330, Status.OBEJRZANY));
        movieRepository.save(new Movie("Terminator",1984,"James Cameron",7.9,Genre.ACTION,37000, Status.DO_OBEJRZENIA));
        movieRepository.save(new Movie("Shawshank Redemption",1995,"Frank Darabont",8.8,Genre.DRAMA,3000, Status.OBEJRZANY));
        movieRepository.save(new Movie("Cast Away",2001,"Robert Zemeckis",7.4,Genre.ACTION,300910, Status.OBEJRZANY));
    }

}
