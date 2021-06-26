package cinema.system.dao;

import cinema.system.domain.MovieEntity;
import cinema.system.domain.ReservationEntity;

import java.util.List;

public interface MovieDao extends Dao<MovieEntity, Long>{

    List<ReservationEntity> getAllReservations(Long id);

}
