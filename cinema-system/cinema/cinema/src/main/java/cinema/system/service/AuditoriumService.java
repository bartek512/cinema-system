package cinema.system.service;

import cinema.system.types.AuditoriumTO;
import cinema.system.types.ReservationTO;

import java.util.List;

public interface AuditoriumService {
    List<ReservationTO> getAllReservations(Long id);

    AuditoriumTO getById(Long id);

    void deleteById(Long id);

    AuditoriumTO saveAuditorium(AuditoriumTO auditoriumTO);

    AuditoriumTO update(AuditoriumTO auditorium);
}