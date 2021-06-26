package cinema.system.dao;

import cinema.system.domain.ReservationEntity;
import cinema.system.domain.SeatEntity;

import java.util.List;

public interface SeatDao extends Dao<SeatEntity, Long> {

    List<ReservationEntity> getAllReservationsBySeatId(Long seatId);
}
