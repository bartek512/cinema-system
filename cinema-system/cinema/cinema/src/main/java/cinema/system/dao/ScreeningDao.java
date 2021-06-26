package cinema.system.dao;

import cinema.system.domain.ReservationEntity;
import cinema.system.domain.ScreeningEntity;

import java.util.List;

public interface ScreeningDao extends Dao<ScreeningEntity, Long> {

    List<ReservationEntity> getAllReservations(Long id);

    List<ScreeningEntity> findReservationsWithOver10Cancelled();

}
