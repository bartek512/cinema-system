package cinema.system.service.impl;

import cinema.system.dao.AuditoriumDao;
import cinema.system.dao.SeatDao;
import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.SeatEntity;
import cinema.system.mappers.AuditoriumMapper;
import cinema.system.mappers.ReservationMapper;
import cinema.system.mappers.SeatMapper;
import cinema.system.service.SeatService;
import cinema.system.types.ReservationTO;
import cinema.system.types.SeatTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatDao seatRepository;

    @Autowired
    private AuditoriumDao auditoriumRepository;

    @Override
    public SeatTO getById(Long id) {
        return SeatMapper.toSeatTO(seatRepository.findOne(1L));
    }

    /**
     * Returns all reservations assigned to seat
     *
     * @param seatId to find assigned reservations
     * @return list of reservations
     */
    @Override
    public List<ReservationTO> getAllReservationsBySeatId(Long seatId) {
        return ReservationMapper.map2TOs(seatRepository.getAllReservationsBySeatId(seatId));
    }

    @Override
    public SeatTO save(SeatTO seat) {
        SeatEntity seatEntity = SeatMapper.toSeatEntity(seat);

        Long auditoriumId = seat.getAuditorium().getId();
        if (auditoriumId != null) {
            AuditoriumEntity auditoriumEntity = auditoriumRepository.findOne(auditoriumId);
            seatEntity.setAuditorium(auditoriumEntity);
        }
        return SeatMapper.toSeatTO(seatRepository.save(seatEntity));
    }

    @Override
    public SeatTO update(SeatTO seat) {
        checkIfSeatExist(seat);
        SeatEntity newSeat = seatRepository.findOne(seat.getId());
        newSeat.setId(seat.getId());
        newSeat.setAuditorium(AuditoriumMapper.toAuditoriumEntity(seat.getAuditorium()));
        newSeat.setSeatNumber(seat.getSeatNumber());
        newSeat.setSeatRow(seat.getSeatRow());
        newSeat.setSeatType(seat.getSeatType());
        SeatEntity updatedSeat = seatRepository.update(newSeat);
        return SeatMapper.toSeatTO(updatedSeat);
    }

    @Override
    public void deleteById(Long id) {
        seatRepository.delete(id);
    }

    private void checkIfSeatExist(SeatTO seat) {
        seatRepository.exists(seat.getAuditorium().getId());
    }

}
