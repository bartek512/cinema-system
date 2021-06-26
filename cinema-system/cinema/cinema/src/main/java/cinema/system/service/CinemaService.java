package cinema.system.service;

import cinema.system.types.AuditoriumTO;
import cinema.system.types.CinemaTO;

import java.util.List;

public interface CinemaService {

    List<AuditoriumTO> getAllAuditories(Long cinemaId);

    CinemaTO getById(Long id);

    CinemaTO save(CinemaTO cinemaTO);

    CinemaTO update(CinemaTO cinemaTO);

    void deleteById(Long id);

}
