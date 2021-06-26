package cinema.system.dao.impl;

import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.ReservationEntity;
import cinema.system.dao.AuditoriumDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuditoriumDaoImpl extends AbstractDao<AuditoriumEntity, Long> implements AuditoriumDao {

    @Override
    public List<ReservationEntity> getAllReservations(Long id) {
        List<ReservationEntity> reservations = entityManager.createNamedQuery("Auditorium.getAllReservations", ReservationEntity.class)
                .setParameter("id", id).getResultList();
        return reservations;
    }
}
