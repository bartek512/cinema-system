package cinema.system.dao.impl;

import cinema.system.domain.MovieEntity;
import cinema.system.domain.ReservationEntity;
import cinema.system.dao.MovieDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl extends AbstractDao<MovieEntity, Long> implements MovieDao {
    @Override
    public List<ReservationEntity> getAllReservations(Long id) {
            List<ReservationEntity> reservations = entityManager.createNamedQuery("Movie.getAllReservations", ReservationEntity.class)
                    .setParameter("id", id).getResultList();
            return reservations;
    }
}
