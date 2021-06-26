package cinema.system.service;


import cinema.system.types.AuditoriumTO;
import cinema.system.types.MovieTO;
import cinema.system.types.ReservationTO;
import cinema.system.types.ScreeningTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScreeningServiceTest {


    @Autowired
    private ScreeningService screeningService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private MovieService movieService;


    @Test
    public void shouldReturnAllReservationsForThisScreening() {

        //when
        List<ReservationTO> reservations = screeningService.getAllReservations(1L);

        //then
        assertFalse(reservations.isEmpty());
        assertEquals(4, reservations.size());

        assertTrue(reservations.stream().anyMatch(b -> b.getScreening().getId().equals(1L)));
    }

    @Test
    public void shouldReturnEmptyListWhenScreeningDoesntHaveAnyReservations() {

        //when
        List<ReservationTO> reservations = screeningService.getAllReservations(4L);

        //then
        assertTrue(reservations.isEmpty());
    }

    @Test
    public void shouldReturnEmptyListWhenScreeningDoesntExist() {

        //when
        List<ReservationTO> reservations = screeningService.getAllReservations(25L);

        //then
        assertTrue(reservations.isEmpty());
    }


    @Test
    @Transactional
    public void shouldDeleteReservationAfterScreeningDeleting() {

        //when
        screeningService.deleteById(1L);

        //then
        assertNotNull(auditoriumService.getById(1L));
        assertNull(reservationService.getById(1L));
    }


    @Test
    public void shouldReturn1ScreeningWithOver10ReservationsCancelled() {

        //when
        List<ScreeningTO> resultList = screeningService.findScreeningsWithOver10Cancelled();

        //then
        assertEquals(2, resultList.size());
    }

    @Test
    @Transactional
    public void shouldReturnSavedScreening() {

        //given
        MovieTO movie = movieService.getById(1L);
        AuditoriumTO auditorium = auditoriumService.getById(1L);
        ScreeningTO screeningTO = ScreeningTO.builder().withDate(LocalDate.now()).withMovie(movie).withAuditorium(auditorium)/*.withReservations(null)*/.build();

        //when
        ScreeningTO savedScreening = screeningService.save(screeningTO);

        //then
        assertNotNull(savedScreening);
        assertEquals(LocalDate.now(), savedScreening.getDate());
        assertEquals(auditorium.getSeats(), savedScreening.getAuditorium().getSeats());
        assertEquals(auditorium.getAuditoriumNumber(), savedScreening.getAuditorium().getAuditoriumNumber());
    }

    @Test(expected = RuntimeException.class)
    @Transactional
    public void shouldReturnExteptionWhenTryToSaveScreeningWithoutMovie() {

        //given
        AuditoriumTO auditorium = auditoriumService.getById(1L);
        ScreeningTO screeningTO = ScreeningTO.builder().withId(12L).withDate(LocalDate.now()).withMovie(null).withAuditorium(auditorium)/*.withReservations(null)*/.build();

        //when
        ScreeningTO savedScreening = screeningService.save(screeningTO);
    }

    @Test(expected = RuntimeException.class)
    @Transactional
    public void shouldReturnExteptionWhenTryToSaveScreeningWithoutAuditorium() {

        //given
        MovieTO movie = movieService.getById(1L);
        ScreeningTO screeningTO = ScreeningTO.builder().withId(12L).withDate(LocalDate.now()).withMovie(movie).withAuditorium(null)/*.withReservations(null)*/.build();

        //when
        ScreeningTO savedScreening = screeningService.save(screeningTO);
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldReturnExteptionWhenTryToSaveScreeningWithoutAuditoriumAndMovie() {

        //given
        ScreeningTO screeningTO = ScreeningTO.builder().withId(12L).withDate(LocalDate.now()).withMovie(null).withAuditorium(null)/*.withReservations(null)*/.build();

        //when
        ScreeningTO savedScreening = screeningService.save(screeningTO);
    }

    @Transactional
    @Test
    public void shouldReturnUpdatedScreening() {

        //given
        MovieTO movie = movieService.getById(1L);
        AuditoriumTO auditorium = auditoriumService.getById(1L);
        ScreeningTO screeningTOtoUpdate = ScreeningTO.builder().withId(1L).withMovie(movie)
               .withAuditorium(auditorium).withDate(LocalDate.now()).build();

        //when
        ScreeningTO updatedScreening = screeningService.update(screeningTOtoUpdate);

        //then
        assertNotNull(auditorium);
        assertNotNull(movie);
        assertNotNull(updatedScreening);
        assertEquals(auditorium.getAuditoriumNumber(), updatedScreening.getAuditorium().getAuditoriumNumber());
        assertEquals(movie.getTitle(), updatedScreening.getMovie().getTitle());
        assertEquals(LocalDate.now(), updatedScreening.getDate());
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryToUpdateScreeningWithoutMovie() {

        //given
        AuditoriumTO auditorium = auditoriumService.getById(1L);
        ScreeningTO screeningTOtoUpdate = ScreeningTO.builder().withId(1L).withMovie(null)
               .withAuditorium(auditorium).withDate(LocalDate.now()).build();

        //when
        ScreeningTO updatedScreening = screeningService.update(screeningTOtoUpdate);
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryToUpdateScreeningWithoutAuditorium() {

        //given
        MovieTO movie = movieService.getById(1L);
        ScreeningTO screeningTOtoUpdate = ScreeningTO.builder().withId(1L).withMovie(movie)
               .withAuditorium(null).withDate(LocalDate.now()).build();

        //when
        ScreeningTO updatedScreening = screeningService.update(screeningTOtoUpdate);
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryToUpdateScreeningWithoutAuditoriumAndMovie() {

        //given
        ScreeningTO screeningTOtoUpdate = ScreeningTO.builder().withId(1L).withMovie(null)
               .withAuditorium(null).withDate(LocalDate.now()).build();

        //when
        ScreeningTO updatedScreening = screeningService.update(screeningTOtoUpdate);
    }

    @Transactional
    @Test
    public void shouldRemoveScreeningById() {

        //given
        ScreeningTO screeningTO = screeningService.getById(1L);

        //when
        screeningService.deleteById(1L);

        //then
        assertNotNull(screeningTO);
        assertNull(screeningService.getById(1L));
    }
}
