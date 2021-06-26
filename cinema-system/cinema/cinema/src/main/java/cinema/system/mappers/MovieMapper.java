package cinema.system.mappers;

import cinema.system.domain.MovieEntity;
import cinema.system.types.MovieTO;
import cinema.system.types.MovieTO.MovieTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class MovieMapper {

    public static MovieTO toMovieTO(MovieEntity movieEntity) {
        if (movieEntity == null)
            return null;

        return new MovieTOBuilder().withId(movieEntity.getId()).withTitle(movieEntity.getTitle()).withAgeCategory(movieEntity.getAgeCategory())
                .withAvailableFrom(movieEntity.getAvailableFrom()).withAvailableUntil(movieEntity.getAvailableUntil())
                .withYear(movieEntity.getYear()).withMovieCategory(movieEntity.getMovieCategory()).build();
    }

    public static MovieEntity toMovieEntity(MovieTO movieTO) {
        if (movieTO == null)
            return null;
        MovieEntity movie = new MovieEntity();
        movie.setId(movieTO.getId());
        movie.setTitle(movieTO.getTitle());
        movie.setMovieCategory(movieTO.getMovieCategory());
        movie.setAgeCategory(movieTO.getAgeCategory());
        movie.setYear(movieTO.getYear());
        movie.setAvailableFrom(movieTO.getAvailableFrom());
        movie.setAvailableUntil(movieTO.getAvailableUntil());
        return movie;
    }

    public static List<MovieTO> map2TOs(List<MovieEntity> movieEntities) {
        return movieEntities.stream().map(MovieMapper::toMovieTO).collect(Collectors.toList());
    }

    public static List<MovieEntity> map2Entities(List<MovieTO> movieTOs) {
        return movieTOs.stream().map(MovieMapper::toMovieEntity).collect(Collectors.toList());
    }
}
