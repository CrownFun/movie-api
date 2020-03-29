package pl.filewicz.movieapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.filewicz.movieapi.model.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    Movie findByTitle(String title);

    @Override
    List<Movie> findAll();
}
