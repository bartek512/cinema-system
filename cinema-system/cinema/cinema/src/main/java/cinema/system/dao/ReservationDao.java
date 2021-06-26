package cinema.system.dao;

import cinema.system.domain.ReservationEntity;
import cinema.system.types.SearchCriteria;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDao extends Dao<ReservationEntity, Long> {

    List<ReservationEntity> findReservationByCriteria(SearchCriteria criteria);

    List<ReservationEntity> findReservationsBetweenDates(LocalDate startDate, LocalDate endDate);

    List<ReservationEntity> findReservationsBetweenDates(LocalDate startDate);

    List<ReservationEntity> findReservationsBetweenDates();

}


