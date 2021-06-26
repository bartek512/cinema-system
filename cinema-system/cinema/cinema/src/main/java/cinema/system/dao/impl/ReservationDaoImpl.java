package cinema.system.dao.impl;

import cinema.system.types.SearchCriteria;
import cinema.system.dao.ReservationDao;
import com.capgemini.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ReservationDaoImpl extends AbstractDao<ReservationEntity, Long> implements ReservationDao {

    @Override
    public List<ReservationEntity> findReservationByCriteria(SearchCriteria criteria) {

        CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ReservationEntity> criteriaQuery = queryBuilder.createQuery(ReservationEntity.class);
        Root<ReservationEntity> rootQuery = criteriaQuery.from(ReservationEntity.class);
        List<Predicate> predicateList = new ArrayList<>();

        Join<ReservationEntity, AuditoriumEntity> reservationAuditorium = rootQuery.join("auditorium");
        Join<ReservationEntity, SeatEntity> reservationSeat = rootQuery.join("seats");
        Join<ReservationEntity, ScreeningEntity> reservationScreening = rootQuery.join("screening");
        Join<ScreeningEntity, MovieEntity> reservationMovie = reservationScreening.join("movie");

        if (criteria.getAuditoriumId() != null) {
            Predicate auditoriumPredicate = queryBuilder.equal(reservationAuditorium.get("id"), criteria.getAuditoriumId());
            predicateList.add(auditoriumPredicate);
        }
        if (criteria.getSeatRow() != null) {
            Predicate seatRowPredicate = queryBuilder.equal(reservationSeat.get("seatRow"), criteria.getSeatRow());
            predicateList.add(seatRowPredicate);
        }
        if (criteria.getSeatNumber() != null) {
            Predicate seatRowPredicate = queryBuilder.equal(reservationSeat.get("seatNumber"), criteria.getSeatNumber());
            predicateList.add(seatRowPredicate);
        }
        if (criteria.getMovieTitle() != null) {
            Predicate moviePredicate = queryBuilder.equal(reservationMovie.get("title"), criteria.getMovieTitle());
            predicateList.add(moviePredicate);
        }
        if (criteria.getStartDate() != null && criteria.getEndDate() != null) {
            Predicate datePredicate = queryBuilder.between(rootQuery.get("cratedDate"), criteria.getStartDate(), criteria.getEndDate());
            predicateList.add(datePredicate);
        }
        if (criteria.getStartDate() != null && criteria.getEndDate() == null) {
            Predicate datePredicate = queryBuilder.greaterThan(rootQuery.get("cratedDate"), criteria.getStartDate());
            predicateList.add(datePredicate);
        }
        if (criteria.getStartDate() == null && criteria.getEndDate() != null) {
            Predicate datePredicate = queryBuilder.lessThan(rootQuery.get("cratedDate"), criteria.getEndDate());
            predicateList.add(datePredicate);
        }

        Predicate[] predicateArray = predicateList.toArray(Predicate[]::new);
        criteriaQuery.select(rootQuery).where(predicateArray).distinct(true);
        TypedQuery<ReservationEntity> typedQuery = entityManager.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }

    @Override
    public List<ReservationEntity> findReservationsBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<ReservationEntity> filteredReservationsByDate = entityManager.createNamedQuery("Reservations.getAllReservationsInSpecifiedData", ReservationEntity.class)
                .setParameter("startDate", startDate).setParameter("endDate", endDate).getResultList();
        return filteredReservationsByDate;
    }

    @Override
    public List<ReservationEntity> findReservationsBetweenDates(LocalDate startDate) {
        LocalDate endDate = LocalDate.now();
        List<ReservationEntity> filteredReservationsByDate = entityManager.createNamedQuery("Reservations.getAllReservationsInSpecifiedData", ReservationEntity.class)
                .setParameter("startDate", startDate).setParameter("endDate", endDate).getResultList();
        return filteredReservationsByDate;
    }

    @Override
    public List<ReservationEntity> findReservationsBetweenDates() {
        List<ReservationEntity> filteredReservationsByDate = entityManager.createNamedQuery("Reservations.getAllReservationsInSpecifiedData", ReservationEntity.class)
                .setParameter("startDate", null).setParameter("endDate", null).getResultList();
        return filteredReservationsByDate;
    }
}
