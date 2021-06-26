package cinema.system.dao.impl;

import cinema.system.domain.ReservationEntity;
import cinema.system.domain.ScreeningEntity;
import cinema.system.dao.ScreeningDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScreeningDaoImpl extends AbstractDao<ScreeningEntity, Long> implements ScreeningDao {
    @Override
    public List<ReservationEntity> getAllReservations(Long id) {
        List<ReservationEntity> reservations = entityManager.createNamedQuery("Screening.getAllReservations", ReservationEntity.class)
                .setParameter("id", id).getResultList();
        return reservations;
    }

    @Override
    public List<ScreeningEntity> findReservationsWithOver10Cancelled() {
        List<ScreeningEntity> screenings = entityManager.createNamedQuery("Screening.findAllScreeningsWithOver10ReservationsCancelled", ScreeningEntity.class)
                .getResultList();
        return screenings;
    }
}
