package cinema.system.domain;

import cinema.system.domain.enumerations.BookingType;
import cinema.system.domain.enumerations.ReservationStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Reservations.getAllReservationsInSpecifiedData",
                query = "SELECT r FROM ReservationEntity r WHERE (:startDate is null or r.cratedDate >= :startDate) and (:endDate is null or r.cratedDate <= :endDate)"),
}
)
@Entity
@Table(name = "RESERVATION")
public class ReservationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "booking_type")
    @Enumerated(EnumType.STRING)
    private BookingType bookingType;

    @Column(name = "price")
    private Double price;

    @Column(name = "reservation_status")
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @Column(name = "created_date")
    private LocalDate cratedDate;

    @NotNull
    @ManyToOne
    private ScreeningEntity screening;

    @ManyToOne
    private CustomerEntity customer;

    @NotNull
    @ManyToOne
    private AuditoriumEntity auditorium;

    @NotNull
    @ManyToMany
    @JoinTable(
            name = "SEAT_TO_RESERVATION",
            joinColumns = {@JoinColumn(name = "RESERVATION_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "SEAT_ID", nullable = false)}
    )
    private Set<SeatEntity> seats;

    public ReservationEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCratedDate() {
        return cratedDate;
    }

    public void setCratedDate(LocalDate cratedDate) {
        this.cratedDate = cratedDate;
    }

    public Long getId() {
        return id;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public ScreeningEntity getScreening() {
        return screening;
    }

    public void setScreening(ScreeningEntity screening) {
        this.screening = screening;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public AuditoriumEntity getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(AuditoriumEntity auditorium) {
        this.auditorium = auditorium;
    }

    public Set<SeatEntity> getSeats() {
        return seats;
    }

    public void setSeats(Set<SeatEntity> seats) {
        this.seats = seats;
    }
}
