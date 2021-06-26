package cinema.system.service;


import cinema.system.domain.enumerations.AuditoriumType;
import cinema.system.domain.enumerations.SeatType;
import cinema.system.types.AuditoriumTO;
import cinema.system.types.ReservationTO;
import cinema.system.types.SeatTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeatServiceTest {

    @Autowired
    private SeatService seatService;

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private CinemaService cinemaService;


    @Test
    public void shouldReturnReservationList() {

        //when
        List<ReservationTO> reservations = seatService.getAllReservationsBySeatId(1L);

        //then
        assertEquals(1, reservations.size());
        assertEquals(Long.valueOf(1), reservations.get(0).getId());
    }


    @Test
    public void shouldReturnEmptyListForSeatWithoutReservations() {

        //given
        List<ReservationTO> reservations = new ArrayList<>();

        //   when
        reservations = seatService.getAllReservationsBySeatId(123L);
        //  then
        assertTrue(reservations.isEmpty());
        assertEquals(0, reservations.size());
    }

    @Test
    public void shouldReturnEmptyListForSeatWhichDoesntExists() {

        //given
        List<ReservationTO> reservations = new ArrayList<>();

        //   when
        reservations = seatService.getAllReservationsBySeatId(46L);
        //  then
        assertTrue(reservations.isEmpty());
        assertEquals(0, reservations.size());
    }

    @Transactional
    @Test
    public void shouldReturnSavedSeat() {

        //given
        AuditoriumTO auditorium = auditoriumService.getById(1L);
        SeatTO seat = SeatTO.builder().withSeatNumber(43).withSeatRow("K")
                .withSeatType(SeatType.COMMON_SEAT).withAuditorium(auditorium).withReservations(null).build();
        //when
        SeatTO savedSeat = seatService.save(seat);

        //then
        assertNotNull(savedSeat);
        assertEquals(seat.getSeatType(), savedSeat.getSeatType());
        assertEquals(auditorium.getId(), savedSeat.getAuditorium().getId());
    }

    @Test(expected = RuntimeException.class)
    public void shouldReturnExteptionWhenTryToSaveSeatWithoutAuditorium() {

        //given
        SeatTO seat = SeatTO.builder().withId(10L).withSeatNumber(43).withSeatRow("K")
                .withSeatType(SeatType.COMMON_SEAT).withAuditorium(null).withReservations(null).build();

        //when
        SeatTO savedSeat = seatService.save(seat);
    }

    @Transactional
    @Test
    public void shouldReturnUpdatedSeat() {

        //given
        AuditoriumTO auditorium = AuditoriumTO.builder().withId(40L).withAuditoriumNumber(66).withAuditoriumType(AuditoriumType.TYPE_3D)
                .withSeats(null).withReservations(null).withScreeningList(null).withCinema(cinemaService.getById(1L)).build();
        SeatTO oldSeat = seatService.getById(1L);
        SeatTO seatToUpdate = SeatTO.builder().withId(1L).withSeatNumber(1).withSeatRow("K")
                .withSeatType(SeatType.VIP_SEAT).withAuditorium(auditorium).withReservations(null).build();

        //when
        SeatTO updatedseat = seatService.update(seatToUpdate);

        //then
        assertNotNull(oldSeat);
        assertNotNull(updatedseat);
        assertEquals(oldSeat.getSeatNumber(), updatedseat.getSeatNumber());
        assertEquals(SeatType.COMMON_SEAT, oldSeat.getSeatType());
        assertEquals(seatToUpdate.getSeatType(), updatedseat.getSeatType());
    }

    @Transactional
    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryToUpdateSeatWithoutAuditorium() {

        //given
        SeatTO seatToUpdate = SeatTO.builder().withId(1L).withSeatNumber(1).withSeatRow("K")
                .withSeatType(SeatType.VIP_SEAT).withAuditorium(null).withReservations(null).build();

        //when
        SeatTO updatedseat = seatService.update(seatToUpdate);
    }

    @Transactional
    @Test
    public void shouldRemoveSeatById() {
        //given
        SeatTO seatToDelete = seatService.getById(1L);

        //when
        seatService.deleteById(1L);

        //then
        assertNotNull(seatToDelete);
        assertNull(seatService.getById(1L));
    }
}
