package cinema.system.service.impl;

import cinema.system.dao.MovieDao;
import cinema.system.dao.ScreeningDao;
import cinema.system.domain.MovieEntity;
import cinema.system.domain.ReservationEntity;
import cinema.system.domain.ScreeningEntity;
import cinema.system.mappers.AuditoriumMapper;
import cinema.system.mappers.MovieMapper;
import cinema.system.mappers.ReservationMapper;
import cinema.system.mappers.ScreeningMapper;
import cinema.system.service.ScreeningService;
import cinema.system.types.ReservationTO;
import cinema.system.types.ScreeningTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScreeningServiceImpl implements ScreeningService {

    @Autowired
    private ScreeningDao screeningRepository;

    @Autowired
    private MovieDao movieRepositoty;

    /**
     * Returns all reservations assigned to screening
     *
     * @param screeningId to find assigned reservations
     * @return list of reservations
     */
    @Override
    public List<ReservationTO> getAllReservations(Long screeningId) {
        List<ReservationEntity> reservatoins = screeningRepository.getAllReservations(screeningId);
        return ReservationMapper.map2TOs(reservatoins);
    }

    /**
     * Returns screening with over 10 reservations cancelled
     *
     * @return list of screenings
     */
    @Override
    public List<ScreeningTO> findScreeningsWithOver10Cancelled() {
        List<ScreeningEntity> screenings = screeningRepository.findReservationsWithOver10Cancelled();
        return ScreeningMapper.map2TOs(screenings);
    }

    @Override
    public ScreeningTO getById(Long id) {
        return ScreeningMapper.toScreeningTO(screeningRepository.findOne(id));
    }

    @Override
    public void deleteById(Long id) {
        screeningRepository.delete(id);
    }

    @Override
    public ScreeningTO save(ScreeningTO screeningTO) {
        ScreeningEntity screeningEntity = ScreeningMapper.toScreeningEntity(screeningTO);

        Long movieId = screeningTO.getMovie().getId();
        if (movieId != null) {
            MovieEntity movie = movieRepositoty.findOne(movieId);
            screeningEntity.setMovie(movie);
        }
        return ScreeningMapper.toScreeningTO(screeningRepository.save(screeningEntity));
    }

    @Override
    public ScreeningTO update(ScreeningTO screeningTO) {
        checkIfAudotoriumExists(screeningTO);
        checkIfMovieExists(screeningTO);
        ScreeningEntity newScreening = screeningRepository.findOne(screeningTO.getId());
        newScreening.setId(screeningTO.getId());
        newScreening.setMovie(MovieMapper.toMovieEntity(screeningTO.getMovie()));
        newScreening.setAuditorium(AuditoriumMapper.toAuditoriumEntity(screeningTO.getAuditorium()));
        newScreening.setDate(screeningTO.getDate());
        ScreeningEntity updatedScrening = screeningRepository.update(newScreening);
        return ScreeningMapper.toScreeningTO(updatedScrening);
    }

    private void checkIfMovieExists(ScreeningTO screeningTO) {
        screeningRepository.exists(screeningTO.getMovie().getId());
    }

    private void checkIfAudotoriumExists(ScreeningTO screeningTO) {
        screeningRepository.exists(screeningTO.getAuditorium().getId());
    }
}
