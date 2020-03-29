package pl.filewicz.movieapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int year;
    private String director;
    private double rate;
    private Status status;

    public Movie(String title, int year, String director, double rate) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rate = rate;
    }

    public Movie(String title, int year, String director, double rate, Status status) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rate = rate;
        this.status = status;
    }
}
