package cinema.system.service;

import cinema.system.types.MovieTO;
import cinema.system.types.ReservationTO;

import java.util.List;

public interface MovieService {

    List<ReservationTO> getAllReservations(Long movieId);

    MovieTO getById(Long id);

    MovieTO save(MovieTO  movie);

    MovieTO update(MovieTO  movie);

    void deleteById(Long id);

}
