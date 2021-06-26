package cinema.system.service.impl;

import cinema.system.dao.AuditoriumDao;
import cinema.system.dao.ReservationDao;
import cinema.system.dao.ScreeningDao;
import cinema.system.dao.SeatDao;
import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.ReservationEntity;
import cinema.system.domain.ScreeningEntity;
import cinema.system.domain.SeatEntity;
import com.capgemini.mappers.*;
import cinema.system.service.ReservationService;
import cinema.system.types.ReservationTO;
import cinema.system.types.SearchCriteria;
import cinema.system.types.SeatTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationRepository;

    @Autowired
    private ScreeningDao screeningRepository;

    @Autowired
    private AuditoriumDao auditoriumRepository;

    @Autowired
    private SeatDao seatRepository;

    @Override
    public ReservationTO getById(Long id) {
        return ReservationMapper.toReservationTO(reservationRepository.findOne(id));
    }

    /**
     * Returns all reservations matching to specified fields in SearchCriteria object
     *
     * @param criteria object with specified params to filter reservations
     * @return list of reservations
     */
    @Override
    public List<ReservationTO> findReservationByCriteria(SearchCriteria criteria) {
        return ReservationMapper.map2TOs(reservationRepository.findReservationByCriteria(criteria));
    }

    /**
     * Returns list of reservations between params
     */
    @Override
    public List<ReservationTO> findReservationsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return ReservationMapper.map2TOs(reservationRepository.findReservationsBetweenDates(startDate, endDate));
    }

    /**
     * Returns list of params between param and current date
     */
    @Override
    public List<ReservationTO> findReservationsBetweenDates(LocalDate startDate) {
        return ReservationMapper.map2TOs(reservationRepository.findReservationsBetweenDates(startDate));
    }

    /**
     * Returns all reservations
     */
    @Override
    public List<ReservationTO> findReservationsBetweenDates() {
        return ReservationMapper.map2TOs(reservationRepository.findReservationsBetweenDates());
    }

    @Override
    public ReservationTO save(ReservationTO reservationTO) {
        ReservationEntity reservationEntity = ReservationMapper.toReservationEntity(reservationTO);

        Long screeningId = reservationTO.getScreening().getId();
        Long auditoriumId = reservationTO.getAuditorium().getId();
        boolean hasSeats = reservationTO.getSeats().isEmpty();
        if (screeningId != null) {
            ScreeningEntity screening = screeningRepository.findOne(screeningId);
            reservationEntity.setScreening(screening);
        }

        if (auditoriumId != null) {
            AuditoriumEntity auditorium = auditoriumRepository.findOne(screeningId);
            reservationEntity.setAuditorium(auditorium);
        }
        if (!hasSeats) {
            Set<SeatEntity> seats = SeatMapper.map2Entities(reservationTO.getSeats());
            reservationEntity.setSeats(seats);
        }

        return ReservationMapper.toReservationTO(reservationRepository.save(reservationEntity));
    }

    @Override
    public ReservationTO update(ReservationTO reservationTO) {
        checkIfSeatsExist(reservationTO);
        checkIfAuditoriumsExist(reservationTO);
        checkIfScreeningsExist(reservationTO);
        ReservationEntity newReservation = reservationRepository.findOne(reservationTO.getId());
        newReservation.setId(reservationTO.getId());
        newReservation.setSeats(SeatMapper.map2Entities(reservationTO.getSeats()));
        newReservation.setAuditorium(AuditoriumMapper.toAuditoriumEntity(reservationTO.getAuditorium()));
        newReservation.setScreening(ScreeningMapper.toScreeningEntity(reservationTO.getScreening()));
        newReservation.setCratedDate(reservationTO.getCreatedDate());
        newReservation.setCustomer(CustomerMapper.toCustomerEntity(reservationTO.getCustomer()));
        newReservation.setBookingType(reservationTO.getBookingType());
        newReservation.setPrice(reservationTO.getPrice());
        newReservation.setStatus(reservationTO.getStatus());
        ReservationEntity updatedReservation = reservationRepository.update(newReservation);
        return ReservationMapper.toReservationTO(updatedReservation);
    }

    private void checkIfScreeningsExist(ReservationTO reservationTO) {
        reservationRepository.exists(reservationTO.getScreening().getId());
    }

    private void checkIfAuditoriumsExist(ReservationTO reservationTO) {
        reservationRepository.exists(reservationTO.getAuditorium().getId());

    }

    private void checkIfSeatsExist(ReservationTO reservationTO) {

        for (SeatTO seat : reservationTO.getSeats()) {
            seatRepository.exists(seat.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.delete(id);
    }

}
