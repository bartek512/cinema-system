package cinema.system.dao;

import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.CinemaEntity;

import java.util.List;

public interface CinemaDao extends Dao<CinemaEntity, Long> {

    CinemaEntity findCinemaByAddress(String address);

    List<AuditoriumEntity> getAllAuditorium(Long id);

}
