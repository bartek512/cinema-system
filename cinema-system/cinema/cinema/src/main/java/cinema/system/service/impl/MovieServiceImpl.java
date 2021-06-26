package cinema.system.service.impl;

import cinema.system.dao.MovieDao;
import cinema.system.domain.MovieEntity;
import cinema.system.domain.ReservationEntity;
import cinema.system.mappers.MovieMapper;
import cinema.system.mappers.ReservationMapper;
import cinema.system.mappers.ScreeningMapper;
import cinema.system.service.MovieService;
import cinema.system.types.MovieTO;
import cinema.system.types.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieRepository;

    /**
     * Returns all reservations assigned to specified movie
     */
    @Override
    public List<ReservationTO> getAllReservations(Long movieId) {

        List<ReservationEntity> reservatoins = movieRepository.getAllReservations(movieId);
        return ReservationMapper.map2TOs(reservatoins);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.delete(id);
    }

    @Override
    public MovieTO getById(Long id) {
        return MovieMapper.toMovieTO(movieRepository.findOne(id));
    }

    @Override
    public MovieTO save(MovieTO movie) {
        MovieEntity entityToSave = movieRepository.save(MovieMapper.toMovieEntity(movie));
        return MovieMapper.toMovieTO(entityToSave);
    }

    @Override
    public MovieTO update(MovieTO movieTO) {
        MovieEntity newMovie = movieRepository.update(MovieMapper.toMovieEntity(movieTO));

        newMovie.setId(movieTO.getId());
        newMovie.setAgeCategory(movieTO.getAgeCategory());
        newMovie.setAvailableFrom(movieTO.getAvailableFrom());
        newMovie.setAvailableUntil(movieTO.getAvailableUntil());
        newMovie.setTitle(movieTO.getTitle());
        newMovie.setMovieCategory(movieTO.getMovieCategory());
        newMovie.setYear(movieTO.getYear());
        newMovie.setScreeningSet(ScreeningMapper.map2Entities(movieTO.getScreenings()));

        MovieEntity updatedMovie = movieRepository.update(newMovie);

        return MovieMapper.toMovieTO(updatedMovie);
    }
}
