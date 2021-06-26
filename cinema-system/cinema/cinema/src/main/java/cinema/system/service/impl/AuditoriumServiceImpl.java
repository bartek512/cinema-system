package cinema.system.service.impl;

import cinema.system.dao.AuditoriumDao;
import cinema.system.dao.CinemaDao;
import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.CinemaEntity;
import cinema.system.domain.ReservationEntity;
import cinema.system.mappers.AuditoriumMapper;
import cinema.system.mappers.CinemaMapper;
import cinema.system.mappers.ReservationMapper;
import cinema.system.service.AuditoriumService;
import cinema.system.types.AuditoriumTO;
import cinema.system.types.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuditoriumServiceImpl implements AuditoriumService {


    @Autowired
    AuditoriumDao auditoriumRepository;

    @Autowired
    CinemaDao cinemaRepository;

    @Override
    public List<ReservationTO> getAllReservations(Long id) {
        List<ReservationEntity> reservatoins = auditoriumRepository.getAllReservations(id);
        return ReservationMapper.map2TOs(reservatoins);
    }

    @Override
    public AuditoriumTO getById(Long id) {
        return AuditoriumMapper.toAuditoriumTO(auditoriumRepository.findOne(id));
    }


    @Override
    public void deleteById(Long id) {
        auditoriumRepository.delete(id);
    }

    @Override
    public AuditoriumTO saveAuditorium(AuditoriumTO auditoriumTO) {
        AuditoriumEntity auditoriumEntity = AuditoriumMapper.toAuditoriumEntity(auditoriumTO);

        Long cinemaId = auditoriumTO.getCinema().getId();
        if (cinemaId != null) {
            CinemaEntity cinema = cinemaRepository.findOne(cinemaId);
            auditoriumEntity.setCinema(cinema);
        }
        return AuditoriumMapper.toAuditoriumTO(auditoriumRepository.save(auditoriumEntity));
    }

    @Override
    public AuditoriumTO update(AuditoriumTO auditorium) {
        checkIfCinemaExist(auditorium);
        AuditoriumEntity newAuditorium = auditoriumRepository.findOne(auditorium.getId());
        newAuditorium.setId(auditorium.getId());
        newAuditorium.setAuditoriumNumber(auditorium.getAuditoriumNumber());
        newAuditorium.setAuditoriumType(auditorium.getAuditoriumType());
        newAuditorium.setCinema(CinemaMapper.toCinemaEntity(auditorium.getCinema()));
        AuditoriumEntity updatedAuditorium = auditoriumRepository.update(newAuditorium);
        return AuditoriumMapper.toAuditoriumTO(updatedAuditorium);
    }

    private void checkIfCinemaExist(AuditoriumTO auditorium) {
        cinemaRepository.exists(auditorium.getCinema().getId());
    }

}
