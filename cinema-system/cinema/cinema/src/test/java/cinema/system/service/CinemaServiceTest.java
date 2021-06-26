package cinema.system.service;


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
public class CinemaServiceTest {

    @Autowired
    private ScreeningService screeningService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private AuditoriumService auditoriumService;

    @Test
    public void shouldReturnAllAuditories() {

        //when
        List<AuditoriumTO> auditories = cinemaService.getAllAuditories(1L);

        //then
        assertFalse(auditories.isEmpty());
        assertEquals(3, auditories.size());

        assertTrue(auditories.stream().anyMatch(b -> b.getId().equals(1L)));
    }

    @Test
    @Transactional
    public void deleteAuditoriumShouldDeleteScreeningSeatAndReservation() {

        //given
        CinemaTO cinemaTO = cinemaService.getById(1L);
        AuditoriumTO auditoriumTO = auditoriumService.getById(1L);
        ReservationTO reservationTO = reservationService.getById(1L);
        ScreeningTO screeningTO = screeningService.getById(1L);

        //when
        cinemaService.deleteById(1L);

        //then
        assertNotNull(cinemaTO);
        assertNotNull(auditoriumTO);
        assertNotNull(reservationTO);
        assertNotNull(screeningTO);
        assertNull(cinemaService.getById(1L));
        assertNull(auditoriumService.getById(1L));
        assertNotNull(movieService.getById(1L));
        assertNull(reservationService.getById(1L));
        assertNull(screeningService.getById(1L));
    }

    @Test
    @Transactional
    public void shouldReturnSavedCinema() {

        //given
        CinemaTO cinemaToSave = CinemaTO.builder().withAdress("Czekoladowa").withName("Helios Aleja").build();

        //when
        CinemaTO savedCinema = cinemaService.save(cinemaToSave);

        //then
        assertNotNull(savedCinema);
        assertEquals(cinemaToSave.getAdress(), savedCinema.getAdress());
        assertEquals(cinemaToSave.getName(), savedCinema.getName());
    }

    @Test
    @Transactional
    public void shouldReturnUpdatedCinema() {

        //given
        CinemaTO oldCinema = cinemaService.getById(2L);
        CinemaTO cinemaToSave = CinemaTO.builder().withId(2L).withAdress("Czekoladowa").withName("Helios Aleja").build();

        //when
        CinemaTO updatedCinema = cinemaService.update(cinemaToSave);

        //then
        assertNotNull(updatedCinema);
        assertEquals("Czekoladowa", updatedCinema.getAdress());
        assertEquals("Helios Aleja", updatedCinema.getName());
    }
}
