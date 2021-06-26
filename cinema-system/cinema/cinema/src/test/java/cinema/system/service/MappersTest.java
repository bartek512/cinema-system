package cinema.system.service;

import cinema.system.dao.AuditoriumDao;
import cinema.system.dao.CinemaDao;
import cinema.system.dao.MovieDao;
import cinema.system.dao.ReservationDao;
import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.CinemaEntity;
import cinema.system.domain.MovieEntity;
import cinema.system.domain.ReservationEntity;
import cinema.system.mappers.AuditoriumMapper;
import cinema.system.mappers.CinemaMapper;
import cinema.system.mappers.MovieMapper;
import cinema.system.mappers.ReservationMapper;
import cinema.system.types.AuditoriumTO;
import cinema.system.types.CinemaTO;
import cinema.system.types.MovieTO;
import cinema.system.types.ReservationTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MappersTest {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private CinemaDao cinemaRepository;

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private AuditoriumDao auditoriumRepository;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieDao movieRepository;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationDao reservationRepository;

    @Test
    public void toCinemaEntityTest() {

        //given
        CinemaTO cinemaTO = cinemaService.getById(1L);

        //when
        CinemaEntity cinemaEntity = CinemaMapper.toCinemaEntity(cinemaTO);

        //then
        assertEquals(cinemaEntity.getId(), cinemaTO.getId());
        assertEquals(cinemaEntity.getName(), cinemaTO.getName());
        assertEquals(cinemaEntity.getAdress(), cinemaTO.getAdress());
    }

    @Test
    public void toCinemaTOTest() {

        //given
        CinemaEntity cinemaEntity = cinemaRepository.findOne(1L);

        //when
        CinemaTO cinemaTO = CinemaMapper.toCinemaTo(cinemaEntity);

        //then
        assertEquals(cinemaEntity.getId(), cinemaTO.getId());
        assertEquals(cinemaEntity.getName(), cinemaTO.getName());
        assertEquals(cinemaEntity.getAdress(), cinemaTO.getAdress());
    }


    @Test
    public void toAuditoriumEntityTest() {

        //given
        AuditoriumTO auditoriumTO = auditoriumService.getById(1L);

        //when
        AuditoriumEntity auditoriumEntity = AuditoriumMapper.toAuditoriumEntity(auditoriumTO);

        //then
        assertEquals(auditoriumTO.getId(), auditoriumEntity.getId());
        assertEquals(auditoriumTO.getAuditoriumNumber(), auditoriumEntity.getAuditoriumNumber());
        assertEquals(auditoriumTO.getAuditoriumType(), auditoriumEntity.getAuditoriumType());
    }

    @Test
    public void toAuditoriumTOTest() {

        //given
        AuditoriumEntity auditoriumEntity = auditoriumRepository.findOne(1L);

        //when
        AuditoriumTO auditoriumTO = AuditoriumMapper.toAuditoriumTO(auditoriumEntity);

        //then
        assertEquals(auditoriumTO.getId(), auditoriumEntity.getId());
        assertEquals(auditoriumTO.getAuditoriumNumber(), auditoriumEntity.getAuditoriumNumber());
        assertEquals(auditoriumTO.getAuditoriumType(), auditoriumEntity.getAuditoriumType());
    }

    @Test
    public void toMovieEntityTest() {

        //given
        MovieTO movieTo = movieService.getById(1L);

        //when
        MovieEntity movieEntity = MovieMapper.toMovieEntity(movieTo);

        //then
        assertEquals(movieTo.getId(), movieEntity.getId());
        assertEquals(movieTo.getTitle(), movieEntity.getTitle());
        assertEquals(movieTo.getMovieCategory(), movieEntity.getMovieCategory());
        assertEquals(movieTo.getAgeCategory(), movieEntity.getAgeCategory());
        assertEquals(movieTo.getAvailableFrom(), movieEntity.getAvailableFrom());
        assertEquals(movieTo.getAvailableUntil(), movieEntity.getAvailableUntil());
    }

    @Test
    public void toMovieTOTest() {

        //given
        MovieEntity movieEntity = movieRepository.findOne(1L);

        //when
        MovieTO movieTO = MovieMapper.toMovieTO(movieEntity);

        //then
        assertEquals(movieTO.getId(), movieEntity.getId());
        assertEquals(movieTO.getTitle(), movieEntity.getTitle());
        assertEquals(movieTO.getMovieCategory(), movieEntity.getMovieCategory());
        assertEquals(movieTO.getAgeCategory(), movieEntity.getAgeCategory());
        assertEquals(movieTO.getAvailableFrom(), movieEntity.getAvailableFrom());
        assertEquals(movieTO.getAvailableUntil(), movieEntity.getAvailableUntil());
    }

    @Test
    public void toReservationEntityTest() {

        //given
        ReservationTO reservationTO = reservationService.getById(1L);

        //when
        ReservationEntity reservationEntity = ReservationMapper.toReservationEntity(reservationTO);

        //then
        assertEquals(reservationTO.getId(), reservationEntity.getId());
        assertEquals(reservationTO.getCreatedDate(), reservationEntity.getCratedDate());
        assertEquals(reservationTO.getBookingType(), reservationEntity.getBookingType());
        assertEquals(reservationTO.getStatus(), reservationEntity.getStatus());
    }
}
