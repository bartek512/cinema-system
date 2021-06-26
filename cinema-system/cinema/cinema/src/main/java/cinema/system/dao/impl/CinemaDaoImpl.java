package cinema.system.dao.impl;

import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.CinemaEntity;
import cinema.system.dao.CinemaDao;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CinemaDaoImpl extends AbstractDao<CinemaEntity, Long> implements CinemaDao {

    @Override
    public CinemaEntity findCinemaByAddress(String address) {
        TypedQuery<CinemaEntity> query = entityManager.createNamedQuery("Cinema.findByAddress", CinemaEntity.class);
        query.setParameter("address", address);
        return query.getSingleResult();
    }

    @Override
    public List<AuditoriumEntity> getAllAuditorium(Long id) {
        List<AuditoriumEntity> resultList = entityManager.createNamedQuery("Cinema.getAllAuditorium", AuditoriumEntity.class).setParameter("id", id)
                .getResultList();
        return resultList;
    }
}
