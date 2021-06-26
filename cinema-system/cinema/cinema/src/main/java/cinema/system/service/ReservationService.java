package cinema.system.service;

import cinema.system.types.ReservationTO;
import cinema.system.types.SearchCriteria;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    ReservationTO getById(Long id);

    List<ReservationTO> findReservationByCriteria(SearchCriteria criteria);

    List<ReservationTO> findReservationsBetweenDates(LocalDate startDate, LocalDate endDate);

    List<ReservationTO> findReservationsBetweenDates(LocalDate startDate);

    List<ReservationTO> findReservationsBetweenDates();

    ReservationTO save(ReservationTO reservationTO);

    ReservationTO update(ReservationTO reservationTO);

    void deleteById(Long id);

}
