package cinema.system.service;

import cinema.system.types.ReservationTO;
import cinema.system.types.SeatTO;

import java.util.List;

public interface SeatService {

    SeatTO getById(Long id);

    List<ReservationTO> getAllReservationsBySeatId(Long seatId);

    SeatTO save(SeatTO seat);

    SeatTO update(SeatTO seat);

    void deleteById(Long id);

}
