package cinema.system.types;

import cinema.system.domain.enumerations.BookingType;
import cinema.system.domain.enumerations.ReservationStatus;

import java.time.LocalDate;
import java.util.Set;

public class ReservationTO {

    private Long id;

    private BookingType bookingType;

    private Double price;

    private ReservationStatus status;

    private ScreeningTO screening;

    private CustomerTO customer;

    private AuditoriumTO auditorium;

    private Set<SeatTO> seats;

    private LocalDate createdDate;

    public ReservationTO(Long id, BookingType bookingType, Double price, ReservationStatus status, ScreeningTO screening, CustomerTO customer, AuditoriumTO auditorium, Set<SeatTO> seats, LocalDate createdDate) {
        this.id = id;
        this.bookingType = bookingType;
        this.price = price;
        this.status = status;
        this.screening = screening;
        this.customer = customer;
        this.auditorium = auditorium;
        this.seats = seats;
        this.createdDate = createdDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
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

    public ScreeningTO getScreening() {
        return screening;
    }

    public void setScreening(ScreeningTO screening) {
        this.screening = screening;
    }

    public CustomerTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerTO customer) {
        this.customer = customer;
    }

    public AuditoriumTO getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(AuditoriumTO auditorium) {
        this.auditorium = auditorium;
    }

    public Set<SeatTO> getSeats() {
        return seats;
    }

    public void setSeats(Set<SeatTO> seats) {
        this.seats = seats;
    }

    public static ReservationTOBuilder builder() {
        return new ReservationTOBuilder();
    }


    public static final class ReservationTOBuilder {
        private Long id;
        private BookingType bookingType;
        private Double price;
        private ReservationStatus status;
        private ScreeningTO screening;
        private CustomerTO customer;
        private AuditoriumTO auditorium;
        private Set<SeatTO> seats;
        private LocalDate createdDate;

        public ReservationTOBuilder() {
        }

        public ReservationTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ReservationTOBuilder withCreatedDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public ReservationTOBuilder withBookingType(BookingType bookingType) {
            this.bookingType = bookingType;
            return this;
        }

        public ReservationTOBuilder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public ReservationTOBuilder withStatus(ReservationStatus status) {
            this.status = status;
            return this;
        }

        public ReservationTOBuilder withScreening(ScreeningTO screening) {
            this.screening = screening;
            return this;
        }

        public ReservationTOBuilder withCustomer(CustomerTO customer) {
            this.customer = customer;
            return this;
        }

        public ReservationTOBuilder withAuditorium(AuditoriumTO auditorium) {
            this.auditorium = auditorium;
            return this;
        }

        public ReservationTOBuilder withSeats(Set<SeatTO> seats) {
            this.seats = seats;
            return this;
        }

        public ReservationTO build() {
            return new ReservationTO(id, bookingType, price, status, screening, customer, auditorium, seats, createdDate);
        }

        }
    }

