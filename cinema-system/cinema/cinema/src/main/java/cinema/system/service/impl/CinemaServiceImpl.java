package cinema.system.service.impl;

import cinema.system.dao.CinemaDao;
import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.CinemaEntity;
import cinema.system.mappers.AuditoriumMapper;
import cinema.system.mappers.CinemaMapper;
import cinema.system.service.CinemaService;
import cinema.system.types.AuditoriumTO;
import cinema.system.types.CinemaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaDao cinemaRepository;

    /**
     * Returns all auditories assigned to cinema
     */
    @Override
    public List<AuditoriumTO> getAllAuditories(Long cinemaId) {
        List<AuditoriumEntity> auditories = cinemaRepository.getAllAuditorium(cinemaId);
        return AuditoriumMapper.map2TOs(auditories);
    }

    @Override
    public CinemaTO getById(Long id) {
        CinemaEntity cinemaById = cinemaRepository.findOne(id);
        return CinemaMapper.toCinemaTo(cinemaById);
    }

    @Override
    public CinemaTO save(CinemaTO cinemaTO) {
        CinemaEntity entityToSave = cinemaRepository.save(CinemaMapper.toCinemaEntity(cinemaTO));
        return CinemaMapper.toCinemaTo(entityToSave);
    }

    @Override
    public CinemaTO update(CinemaTO cinemaTO) {
        CinemaEntity newCinema = cinemaRepository.findOne(cinemaTO.getId());

        newCinema.setId(cinemaTO.getId());
        newCinema.setName(cinemaTO.getName());
        newCinema.setAdress(cinemaTO.getAdress());

        CinemaEntity updatedCinema = cinemaRepository.update(newCinema);

        return CinemaMapper.toCinemaTo(updatedCinema);
    }

    @Override
    public void deleteById(Long id) {
        cinemaRepository.delete(id);
    }

}
