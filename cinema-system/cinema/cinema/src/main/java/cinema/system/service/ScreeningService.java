package cinema.system.service;

import cinema.system.types.ReservationTO;
import cinema.system.types.ScreeningTO;

import java.util.List;

public interface ScreeningService {

    List<ReservationTO> getAllReservations(Long screeningId);

    List<ScreeningTO> findScreeningsWithOver10Cancelled();

    ScreeningTO getById(Long id);

    void deleteById(Long id);

    ScreeningTO save(ScreeningTO screeningTO);

    ScreeningTO update(ScreeningTO screeningTO);

}
