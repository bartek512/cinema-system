package cinema.system.service;


import cinema.system.domain.enumerations.AgeCategory;
import cinema.system.domain.enumerations.MovieCategory;
import cinema.system.domain.enumerations.ReservationStatus;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ScreeningService screeningService;

    @Autowired
    private ReservationService reservationService;


    @Test
    public void shouldReturnAllReservationsForThisScreening() {

        //when
        List<ReservationTO> reservations = movieService.getAllReservations(1L);

        //then
        assertFalse(reservations.isEmpty());
        assertEquals(4, reservations.size());
        assertEquals(ReservationStatus.CANCELLED.name(), reservations.get(0).getStatus().name());
    }

    @Test
    @Transactional
    public void shouldDeleteScreeningAfterMovieDeleting() {

        //given
        ScreeningTO screening = screeningService.getById(1L);
        ReservationTO reservation = reservationService.getById(1L);

        //when
        movieService.deleteById(1L);

        //then
        assertNotNull(screening);
        assertNotNull(reservation);
        assertNull(screeningService.getById(1L));
        assertNull(reservationService.getById(1L));
    }

    @Test
    @Transactional
    public void shouldReturnMovieAfterSaving() {

        //given
        Set<ScreeningTO> screenings = new HashSet<>();
        screenings.add(screeningService.getById(1L));

        MovieTO movieToSave = MovieTO.builder().withMovieCategory(MovieCategory.COMEDY).withAgeCategory(AgeCategory.ADULT)
                .withAvailableFrom(LocalDate.of(2021, 7, 15)).withAvailableUntil(null).withYear(2019)
                .withScreenings(null).withTitle("mocno smieszny film").build();

        //when
        MovieTO savedMovie = movieService.save(movieToSave);

        //then
        assertNotNull(savedMovie);
        assertEquals(movieToSave.getTitle(), savedMovie.getTitle());
        assertEquals(movieToSave.getScreenings(), savedMovie.getScreenings());
    }

    @Test
    @Transactional
    public void shouldReturnUpdateedMovie() {

        //given
        Set<ScreeningTO> screenings = new HashSet<>();
        screenings.add(screeningService.getById(6L));
        MovieTO oldMovie = movieService.getById(5L);
        MovieTO movieToUpdate = MovieTO.builder().withId(1L).withMovieCategory(oldMovie.getMovieCategory()).withAgeCategory(oldMovie.getAgeCategory())
                .withAvailableFrom(LocalDate.of(2021, 7, 15)).withAvailableUntil(null).withYear(2019)
                .withScreenings(screenings).withTitle("mega smieszny film").build();

        //when
        MovieTO updatedMovie = movieService.update(movieToUpdate);

        //then
        assertNotNull(updatedMovie);
        assertEquals(movieToUpdate.getTitle(), updatedMovie.getTitle());
    }

    @Test
    @Transactional
    public void shouldDeleteMovieById() {

        //given
        MovieTO movieToDelete = movieService.getById(1L);

        //when
        movieService.deleteById(1L);

        //then
        assertNotNull(movieToDelete);
        assertNull(movieService.getById(1L));
    }
}
