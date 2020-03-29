package pl.filewicz.movieapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDto {

    private String title;
    private int year;
    private String director;
    private double ocena;
    private String status;



}
