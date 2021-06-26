package cinema.system.service;

import cinema.system.domain.enumerations.AuditoriumType;
import com.capgemini.types.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditoriumServiceTest {

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private ScreeningService screeningService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private SeatService seatService;


    @Test
    public void shouldReturnAllReservationsForThisAuditorium() {

        //   when
        List<ReservationTO> reservations = auditoriumService.getAllReservations(1L);

        //  then
        assertFalse(reservations.isEmpty());
        assertEquals(34, reservations.size());

        assertTrue(reservations.stream().anyMatch(b -> b.getId().equals(1L)));
    }

    @Test
    public void shouldReturnEmptyListForAuditoriumWithoutReservations() {

        //   when
        List<ReservationTO> reservations = auditoriumService.getAllReservations(2L);

        //  then
        assertTrue(reservations.isEmpty());
        assertEquals(0, reservations.size());
    }

    @Test
    public void shouldReturnEmptyListForAuditoriumWhichNotExists() {

        //   when
        List<ReservationTO> reservations = auditoriumService.getAllReservations(12L);

        //  then
        assertTrue(reservations.isEmpty());
        assertEquals(0, reservations.size());
    }

    @Transactional
    @Test
    public void shouldReturnSavedAuditorium() {

        //given
        CinemaTO cinema = cinemaService.getById(1L);
        AuditoriumTO auditorium = AuditoriumTO.builder().withAuditoriumNumber(66).withAuditoriumType(AuditoriumType.TYPE_3D)
                .withSeats(null).withReservations(null).withScreeningList(null).withCinema(cinema).build();

        //when
        AuditoriumTO savedAuditorium = auditoriumService.saveAuditorium(auditorium);

        //then
        assertNotNull(savedAuditorium);
        assertEquals("Nowe Horyzonty", savedAuditorium.getCinema().getName());
        assertEquals(cinema.getId(), savedAuditorium.getCinema().getId());
    }

    @Test(expected = RuntimeException.class)
    public void shouldReturnExteptionWhenTryToSaveAuditoriumWithoutCinema() {

        //given
        AuditoriumTO auditorium = AuditoriumTO.builder().withId(40L).withAuditoriumNumber(66).withAuditoriumType(AuditoriumType.TYPE_3D)
                .withSeats(null).withReservations(null).withScreeningList(null).build();

        //when
        AuditoriumTO savedAuditorium = auditoriumService.saveAuditorium(auditorium);
    }

    @Transactional
    @Test
    public void shouldReturnUpdatedAuditorium() {

        //given
        CinemaTO cinema = CinemaTO.builder().withAdress("Hallera").withName("Kino").withId(34L).build();
        AuditoriumTO oldAuditorium = auditoriumService.getById(1L);
        AuditoriumTO auditoriumToUpdate = AuditoriumTO.builder().withId(1L).withAuditoriumNumber(1).withAuditoriumType(AuditoriumType.TYPE_3D)
                .withSeats(null).withReservations(null).withScreeningList(null).withCinema(cinema).build();

        //when
        AuditoriumTO updatedAudtorium = auditoriumService.update(auditoriumToUpdate);

        //then
        assertNotNull(oldAuditorium);
        assertNotNull(updatedAudtorium);
        assertEquals(oldAuditorium.getAuditoriumNumber(), updatedAudtorium.getAuditoriumNumber());
        assertEquals(AuditoriumType.TYPE_2D.name(), oldAuditorium.getAuditoriumType().name());
        assertEquals(auditoriumToUpdate.getAuditoriumType().name(), updatedAudtorium.getAuditoriumType().name());
    }


    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryToUpdateAuditoriumWithoutCinema() {

        //given
        AuditoriumTO auditoriumToUpdate = AuditoriumTO.builder().withId(1L).withAuditoriumNumber(1).withAuditoriumType(AuditoriumType.TYPE_3D)
                .withSeats(null).withReservations(null).withScreeningList(null).withCinema(null).build();

        //when
        AuditoriumTO updatedAudtorium = auditoriumService.update(auditoriumToUpdate);
    }

    @Transactional
    @Test
    public void shouldRemoveAuditoriumById() {

        //given
        AuditoriumTO auditoriumToDelete = auditoriumService.getById(1L);

        //when
        auditoriumService.deleteById(1L);

        //then
        assertNotNull(auditoriumToDelete);
        assertNull(auditoriumService.getById(1L));
    }

    @Test
    @Transactional
    public void deleteAuditoriumShouldDeleteScreeningSeatAndReservation() {

        //given
        ReservationTO reservationToCheck = reservationService.getById(1L);
        ScreeningTO screeningToCheck = screeningService.getById(1L);
        SeatTO seatToCheck = seatService.getById(1L);

        //when
        auditoriumService.deleteById(1L);

        //then
        assertNotNull(reservationToCheck);
        assertNotNull(screeningToCheck);
        assertNotNull(seatToCheck);
        assertNotNull(cinemaService.getById(1L));
        assertNotNull(movieService.getById(1L));
        assertNull(reservationService.getById(1L));
        assertNull(screeningService.getById(1L));
        assertNull(seatService.getById(1L));
    }
}

