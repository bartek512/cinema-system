package cinema.system.domain;

import cinema.system.domain.enumerations.AuditoriumType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Auditorium.getAllReservations",
                query = "SELECT r FROM ReservationEntity r JOIN r.auditorium a WHERE a.id = :id")
}
)
@Entity
@Table(name = "AUDITORIUM")
public class AuditoriumEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "auditorium_number")
    Integer auditoriumNumber;

    @Column(name = "auditorium_type")
    @Enumerated(EnumType.STRING)
    private AuditoriumType auditoriumType;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "auditorium")
    private Set<SeatEntity> seats;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "auditorium")
    private Set<ScreeningEntity> screeningSet;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CinemaEntity cinema;

    @OneToMany(mappedBy = "auditorium")
    private Set<ReservationEntity> reservations;


    public AuditoriumEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ScreeningEntity> getScreeningSet() {
        return screeningSet;
    }

    public void setScreeningSet(Set<ScreeningEntity> screeningList) {
        this.screeningSet = screeningList;
    }

    public Long getId() {
        return id;
    }


    public Set<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(Set<ReservationEntity> reservations) {
        this.reservations = reservations;
    }

    public CinemaEntity getCinema() {
        return cinema;
    }

    public void setCinema(CinemaEntity cinema) {
        this.cinema = cinema;
    }

    public Integer getAuditoriumNumber() {
        return auditoriumNumber;
    }

    public void setAuditoriumNumber(Integer auditoriumNumber) {
        this.auditoriumNumber = auditoriumNumber;
    }

    public AuditoriumType getAuditoriumType() {
        return auditoriumType;
    }

    public void setAuditoriumType(AuditoriumType auditoriumType) {
        this.auditoriumType = auditoriumType;
    }

    public Set<SeatEntity> getSeats() {
        return seats;
    }

    public void setSeats(Set<SeatEntity> seats) {
        this.seats = seats;
    }
}
