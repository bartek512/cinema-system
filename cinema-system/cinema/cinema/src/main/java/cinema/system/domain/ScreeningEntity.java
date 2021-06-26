package cinema.system.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Screening.getAllReservations",
                query = "SELECT r FROM ReservationEntity r JOIN r.screening s WHERE s.id = :id"),
        @NamedQuery(name = "Screening.findAllScreeningsWithOver10ReservationsCancelled",
                query = "SELECT s FROM ScreeningEntity s WHERE (SELECT COUNT(r) FROM ReservationEntity  r WHERE r.status = 'CANCELLED' AND r.screening = s) > 10")
}
)
@Entity
@Table(name = "SCREENING")
public class ScreeningEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "screening_date")
    private LocalDate date;

    @ManyToOne
    private AuditoriumEntity auditorium;

    @NotNull
    @ManyToOne
    private MovieEntity movie;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "screening")
    private Set<ReservationEntity> reservations;

    public ScreeningEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AuditoriumEntity getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(AuditoriumEntity auditorium) {
        this.auditorium = auditorium;
    }

    public MovieEntity getMovie() {
        return movie;
    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public Set<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(Set<ReservationEntity> reservations) {
        this.reservations = reservations;
    }
}
