package pl.filewicz.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import pl.filewicz.movieapi.model.Movie;
import pl.filewicz.movieapi.model.MovieDto;
import pl.filewicz.movieapi.model.Status;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(source = "rate", target = "ocena")
    @Mapping(source = "status",target = "status",qualifiedByName = "statusConvert")
    MovieDto movieToMovieDto(Movie movie);

    @Named("statusConvert")
    public static String statusConvert(Status status) {


        switch (status) {
            case DO_OBEJRZENIA:
                return "OK";
            case OBEJRZANY:
                return "lipa";
            default:
                return "guj";

        }

    }

}
