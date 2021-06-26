package cinema.system.dao;

import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.ReservationEntity;

import java.util.List;

public interface AuditoriumDao extends Dao<AuditoriumEntity, Long> {

    List<ReservationEntity> getAllReservations(Long id);

}
