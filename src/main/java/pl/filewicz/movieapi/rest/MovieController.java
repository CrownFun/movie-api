package pl.filewicz.movieapi.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filewicz.movieapi.model.Movie;
import pl.filewicz.movieapi.service.MovieServiceImpl;

import java.util.List;

@RestController
@RequestMapping("api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieServiceImpl movieService;

    @PostMapping("/movie")
    public ResponseEntity<Void> saveMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Movie> getRoomByName(@PathVariable("title") String title) {
        Movie movieByTitle = movieService.getMovieByTitle(title);

        return ResponseEntity.ok(movieByTitle);
    }

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        System.out.println("Metoda z api");
        return movieService.getAllMovies();
    }

    @GetMapping("/test")
    public String hello() {
        return "Hello Worold";
    }

}
