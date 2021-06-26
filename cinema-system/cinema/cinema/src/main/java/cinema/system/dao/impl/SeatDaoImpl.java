package cinema.system.dao.impl;

import cinema.system.domain.ReservationEntity;
import cinema.system.domain.SeatEntity;
import cinema.system.dao.SeatDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatDaoImpl extends AbstractDao<SeatEntity, Long> implements SeatDao {
    @Override
    public List<ReservationEntity> getAllReservationsBySeatId(Long seatId) {
        List<ReservationEntity> filteredReservationsByDate = entityManager.createNamedQuery("Seats.findReservationsById", ReservationEntity.class)
                .setParameter("seatId", seatId).getResultList();
        return filteredReservationsByDate;
    }
}
