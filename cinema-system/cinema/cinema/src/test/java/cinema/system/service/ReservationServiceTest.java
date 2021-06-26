package cinema.system.service;


import cinema.system.domain.enumerations.BookingType;
import com.capgemini.types.*;
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
public class ReservationServiceTest {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ScreeningService screeningService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private AuditoriumService auditoriumService;


    @Test
    public void shouldReturnReservationByCriteriaTitle() {

        //given
        SearchCriteria criteria = SearchCriteria.builder().withMovieTitle("American Pie").build();

        //when
        List<ReservationTO> resultList = reservationService.findReservationByCriteria(criteria);

        //then
        assertEquals(14, resultList.size());
        assertTrue(resultList.stream().anyMatch(b -> b.getScreening().getMovie().getTitle().equals(criteria.getMovieTitle())));
    }

    @Test
    public void shouldReturnReservationByTitleAndAuditoriumId() {

        //given
        SearchCriteria criteria = SearchCriteria.builder().withMovieTitle("Toy Story").withAuditoriumId(1L).build();

        //when
        List<ReservationTO> resultList = reservationService.findReservationByCriteria(criteria);

        //then
        assertEquals(6, resultList.size());

        assertTrue(resultList.stream().anyMatch(b -> b.getScreening().getMovie().getTitle().equals(criteria.getMovieTitle())));
        assertTrue(resultList.stream().anyMatch(b -> b.getScreening().getAuditorium().getId().equals(criteria.getAuditoriumId())));
    }

    @Test
    public void shouldReturnReservationByCriteriaSeatNumber() {

        //given
        SearchCriteria criteria = SearchCriteria.builder().withSeatNumber(1).build();

        //when
        List<ReservationTO> resultList = reservationService.findReservationByCriteria(criteria);

        //then
        assertEquals(23, resultList.size());

        assertTrue(resultList.stream().anyMatch(b -> b.getSeats().iterator().next().getSeatNumber().equals(criteria.getSeatNumber())));
    }

    @Test
    public void shouldReturnReservationByCriteriaSeatRowAndNumber() {

        //given
        SearchCriteria criteria = SearchCriteria.builder().withSeatRow("a").withSeatNumber(1).build();

        //when
        List<ReservationTO> resultList = reservationService.findReservationByCriteria(criteria);

        //then
        assertEquals(7, resultList.size());

        assertTrue(resultList.stream().anyMatch(b -> b.getSeats().iterator().next().getSeatNumber().equals(criteria.getSeatNumber())));
        assertTrue(resultList.stream().anyMatch(b -> b.getSeats().iterator().next().getSeatRow().equals(criteria.getSeatRow())));
    }

    @Test
    public void shouldReturnReservationByCriteriaWithStartAndEndDate() {

        //given
        LocalDate startDate = LocalDate.of(2021, 06, 10);
        LocalDate endDate = LocalDate.of(2021, 06, 20);
        SearchCriteria criteria = SearchCriteria.builder().withStartDate(startDate).withEndDate(endDate).build();

        //when
        List<ReservationTO> resultList = reservationService.findReservationByCriteria(criteria);

        //then
        assertEquals(6, resultList.size());

        assertTrue(resultList.stream().anyMatch(b -> b.getCreatedDate().isAfter(startDate)));
        assertTrue(resultList.stream().anyMatch(b -> b.getCreatedDate().isBefore(endDate)));
    }


    @Test
    public void shouldReturnListOfReservationsWithOnlyStartDate() {

        //given
        LocalDate startDate = LocalDate.of(2021, 06, 9);
        SearchCriteria criteria = SearchCriteria.builder().withStartDate(startDate).build();

        //when
        List<ReservationTO> resultList = reservationService.findReservationByCriteria(criteria);

        //then
        assertEquals(6, resultList.size());
        assertTrue(resultList.stream().anyMatch(b -> b.getCreatedDate().isAfter(startDate)));
    }

    @Test
    public void shouldReturnListOfReservationsWithOnlyEndDate() {

        //given
        LocalDate endDate = LocalDate.of(2021, 06, 15);
        SearchCriteria criteria = SearchCriteria.builder().withEndDate(endDate).build();

        //when
        List<ReservationTO> resultList = reservationService.findReservationByCriteria(criteria);

        //then
        assertEquals(21, resultList.size());
        assertTrue(resultList.stream().anyMatch(b -> b.getCreatedDate().isBefore(endDate)));
    }

    @Test
    public void shouldReturnListOfReservationsWithAllParameters() {

        //given
        LocalDate endDate = LocalDate.of(2021, 04, 15);
        LocalDate startDate = LocalDate.of(2021, 04, 9);
        SearchCriteria criteria = SearchCriteria.builder().withAuditoriumId(1L).withEndDate(endDate)
                .withStartDate(startDate).withMovieTitle("straszny film")
                .withSeatNumber(3)
                .withSeatRow("c").build();


        //when
        List<ReservationTO> resultList = reservationService.findReservationByCriteria(criteria);

        //then
        assertEquals(1, resultList.size());

        assertTrue(resultList.stream().anyMatch(b -> b.getCreatedDate().isAfter(startDate)));
        assertTrue(resultList.stream().anyMatch(b -> b.getCreatedDate().isBefore(endDate)));

        assertTrue(resultList.stream().anyMatch(b -> b.getSeats().iterator().next().getSeatNumber().equals(criteria.getSeatNumber())));
        assertTrue(resultList.stream().anyMatch(b -> b.getSeats().iterator().next().getSeatRow().equals(criteria.getSeatRow())));

        assertTrue(resultList.stream().anyMatch(b -> b.getAuditorium().getId().equals(criteria.getAuditoriumId())));
        assertTrue(resultList.stream().anyMatch(b -> b.getScreening().getMovie().getTitle().equals(criteria.getMovieTitle())));
    }

    @Test
    public void shouldReturnListOfReservationsWithNoDates() {

        //when
        List<ReservationTO> resultList = reservationService.findReservationsBetweenDates();

        //then
        assertEquals(34, resultList.size());
    }

    @Test
    public void shouldReturnListOfReservationsWithTwoDates() {

        //given
        LocalDate endDate = LocalDate.of(2021, 04, 15);
        LocalDate startDate = LocalDate.of(2021, 04, 9);

        //when
        List<ReservationTO> resultList = reservationService.findReservationsBetweenDates(startDate, endDate);

        //then
        assertEquals(1, resultList.size());
    }


    @Test
    public void shouldReturnEmptyListWhenGetWrongDates() {

        //given
        LocalDate startDate = LocalDate.of(2021, 06, 18);

        //when
        List<ReservationTO> resultList = reservationService.findReservationsBetweenDates(startDate);

        //then
        assertTrue(resultList.isEmpty());
    }

    @Transactional
    @Test
    public void shouldReturnSavedReservation() {

        //given
        ScreeningTO screeningTO = screeningService.getById(1L);
        SeatTO seatTO = seatService.getById(1L);
        Set<SeatTO> seats = new HashSet<>();
        seats.add(seatTO);
        AuditoriumTO auditoriumTO = auditoriumService.getById(1L);
        ReservationTO reservationToSave = ReservationTO.builder().withAuditorium(auditoriumTO).withCustomer(null).withScreening(screeningTO)
                .withBookingType(BookingType.ONLINE).withSeats(seats).withPrice(45d).withCreatedDate(LocalDate.now()).build();

        //when
        ReservationTO savedReservation = reservationService.save(reservationToSave);

        //then
        assertNotNull(savedReservation);
        assertEquals(screeningTO.getMovie().getTitle(), savedReservation.getScreening().getMovie().getTitle());
        assertEquals(auditoriumTO.getId(), savedReservation.getAuditorium().getId());
        assertEquals(screeningTO.getId(), savedReservation.getScreening().getId());
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldReturnExteptionWhenTryToSaveReservationWithouAuditorium() {

        //given
        AuditoriumTO auditoriumTO = auditoriumService.getById(1L);
        SeatTO seatTO = seatService.getById(1L);
        Set<SeatTO> seats = new HashSet<>();
        ReservationTO reservationToSave = ReservationTO.builder().withAuditorium(auditoriumTO).withCustomer(null).withId(3L).withScreening(null)
                .withBookingType(BookingType.ONLINE).withSeats(seats).withPrice(45d).withCreatedDate(LocalDate.now()).build();

        //when
        ReservationTO savedReservation = reservationService.save(reservationToSave);
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldReturnExteptionWhenTryToSaveReservationWithoutScreening() {

        //given
        ScreeningTO screeningTO = screeningService.getById(1L);
        SeatTO seatTO = seatService.getById(1L);
        Set<SeatTO> seats = new HashSet<>();
        ReservationTO reservationToSave = ReservationTO.builder().withAuditorium(null).withCustomer(null).withId(3L).withScreening(screeningTO)
                .withBookingType(BookingType.ONLINE).withSeats(seats).withPrice(45d).withCreatedDate(LocalDate.now()).build();

        //when
        ReservationTO savedReservation = reservationService.save(reservationToSave);

    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldReturnExteptionWhenTryToSaveReservationWithoutSeats() {

        //given
        AuditoriumTO auditoriumTO = auditoriumService.getById(1L);
        ScreeningTO screeningTO = screeningService.getById(1L);
        ReservationTO reservationToSave = ReservationTO.builder().withAuditorium(auditoriumTO).withCustomer(null).withId(3L).withScreening(screeningTO)
                .withBookingType(BookingType.ONLINE).withSeats(null).withPrice(45d).withCreatedDate(LocalDate.now()).build();

        //when
        ReservationTO savedReservation = reservationService.save(reservationToSave);
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldReturnExteptionWhenTryToSaveReservationWithoutSeatsScreaningAndAuditorium() {

        //given
        ReservationTO reservationToSave = ReservationTO.builder().withAuditorium(null).withCustomer(null).withId(3L).withScreening(null)
                .withBookingType(BookingType.ONLINE).withSeats(null).withPrice(45d).withCreatedDate(LocalDate.now()).build();

        //when
        ReservationTO savedReservation = reservationService.save(reservationToSave);
    }

    @Test
    @Transactional
    public void shouldReturnUpdatedReservation() {

        //given
        ScreeningTO screeningTO = screeningService.getById(1L);
        AuditoriumTO auditoriumTO = auditoriumService.getById(1L);
        SeatTO seatTO = seatService.getById(1L);
        Set<SeatTO> seats = new HashSet<>();
        seats.add(seatTO);
        ReservationTO oldReservation = reservationService.getById(1L);
        ReservationTO reservationToUpdate = ReservationTO.builder().withAuditorium(auditoriumTO).withCustomer(null).withId(1L).withScreening(screeningTO)
                .withBookingType(BookingType.ONLINE).withSeats(seats).withPrice(45d).withCreatedDate(LocalDate.now()).build();

        //when
        ReservationTO updatedReservation = reservationService.update(reservationToUpdate);

        //then
        assertNotNull(oldReservation);
        assertNotNull(updatedReservation);
        assertEquals(oldReservation.getId(), updatedReservation.getId());
        assertEquals(oldReservation.getAuditorium().getAuditoriumNumber(), updatedReservation.getAuditorium().getAuditoriumNumber());
        assertEquals(LocalDate.now(), updatedReservation.getScreening().getDate());
        assertEquals(screeningTO.getMovie().getTitle(), updatedReservation.getScreening().getMovie().getTitle());
        assertEquals(Double.valueOf(45), updatedReservation.getPrice());
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryToUpdateReservationWithoutScreening() {

        //given
        SeatTO seatTO = seatService.getById(1L);
        Set<SeatTO> seats = new HashSet<>();
        seats.add(seatTO);
        AuditoriumTO auditoriumTO = auditoriumService.getById(1L);
        ReservationTO reservationToUpdate = ReservationTO.builder().withAuditorium(auditoriumTO).withCustomer(null).withId(1L).withScreening(null)
                .withBookingType(BookingType.ONLINE).withSeats(seats).withPrice(45d).withCreatedDate(LocalDate.now()).build();

        //when
        ReservationTO updatedReservation = reservationService.update(reservationToUpdate);
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryToUpdateReservationWithoutAuditorium() {

        //given
        SeatTO seatTO = seatService.getById(1L);
        Set<SeatTO> seats = new HashSet<>();
        seats.add(seatTO);
        ScreeningTO screeningTO = screeningService.getById(1L);
        ReservationTO reservationToUpdate = ReservationTO.builder().withAuditorium(null).withCustomer(null).withId(1L).withScreening(screeningTO)
                .withBookingType(BookingType.ONLINE).withSeats(seats).withPrice(45d).withCreatedDate(LocalDate.now()).build();

        //when
        ReservationTO updatedReservation = reservationService.update(reservationToUpdate);
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryToUpdateReservationWithoutSeats() {

        //given
        AuditoriumTO auditoriumTO = auditoriumService.getById(1L);
        ScreeningTO screeningTO = screeningService.getById(1L);
        ReservationTO reservationToUpdate = ReservationTO.builder().withAuditorium(auditoriumTO).withCustomer(null).withId(1L).withScreening(screeningTO)
                .withBookingType(BookingType.ONLINE).withSeats(null).withPrice(45d).withCreatedDate(LocalDate.now()).build();

        //when
        ReservationTO updatedReservation = reservationService.update(reservationToUpdate);
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryToUpdateReservationWithoutSeatsAndAuditorium() {

        //given
        ScreeningTO screeningTO = screeningService.getById(1L);
        ReservationTO reservationToUpdate = ReservationTO.builder().withAuditorium(null).withCustomer(null).withId(1L).withScreening(screeningTO)
                .withBookingType(BookingType.ONLINE).withSeats(null).withPrice(45d).withCreatedDate(LocalDate.now()).build();

        //when
        ReservationTO updatedReservation = reservationService.update(reservationToUpdate);
    }

    @Transactional
    @Test
    public void shouldDeleteReservationById() {

        //given
        ReservationTO reservationToDelete = reservationService.getById(1L);

        //when
        reservationService.deleteById(1L);

        //then
        assertNotNull(reservationToDelete);
        assertNull(reservationService.getById(1L));
    }
}
