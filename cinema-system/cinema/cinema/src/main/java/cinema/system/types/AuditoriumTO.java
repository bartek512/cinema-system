package cinema.system.types;

import cinema.system.domain.ReservationEntity;
import cinema.system.domain.ScreeningEntity;
import cinema.system.domain.SeatEntity;
import cinema.system.domain.enumerations.AuditoriumType;

import java.util.Set;

public class AuditoriumTO {

    private Long id;

    Integer auditoriumNumber;

    private AuditoriumType auditoriumType;

    private Set<SeatEntity> seats;

    private Set<ScreeningEntity> screeningSet;

    private CinemaTO cinema;

   // private Set<ReservationEntity> reservations;

    public AuditoriumTO(Long id, Integer auditoriumNumber, AuditoriumType auditoriumType, Set<SeatEntity> seats, Set<ScreeningEntity> screeningSet, CinemaTO cinema/* Set<ReservationEntity> reservations*/) {
        this.id = id;
        this.auditoriumNumber = auditoriumNumber;
        this.auditoriumType = auditoriumType;
        this.seats = seats;
        this.screeningSet = screeningSet;
        this.cinema = cinema;
   //     this.reservations = reservations;
    }

    public AuditoriumTO() {
    }

    public Long getId() {
        return id;
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

    public Set<ScreeningEntity> getScreeningSet() {
        return screeningSet;
    }

    public void setScreeningSet(Set<ScreeningEntity> screeningSet) {
        this.screeningSet = screeningSet;
    }

    public CinemaTO getCinema() {
        return cinema;
    }

    public void setCinema(CinemaTO cinema) {
        this.cinema = cinema;
    }

//    public Set<ReservationEntity> getReservations() {
//        return reservations;
//    }
//
//    public void setReservations(Set<ReservationEntity> reservations) {
//        this.reservations = reservations;
//    }

    public static AuditoriumTOBuilder builder() {
        return new AuditoriumTOBuilder();
    }


    public static final class AuditoriumTOBuilder {
        private Integer auditoriumNumber;
        private Long id;
        private AuditoriumType auditoriumType;
        private Set<SeatEntity> seats;
        private Set<ScreeningEntity> screeningList;
        private CinemaTO cinema;
        private Set<ReservationEntity> reservations;

        public AuditoriumTOBuilder() {
        }

        public AuditoriumTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AuditoriumTOBuilder withAuditoriumNumber(Integer auditoriumNumber) {
            this.auditoriumNumber = auditoriumNumber;
            return this;
        }

        public AuditoriumTOBuilder withAuditoriumType(AuditoriumType auditoriumType) {
            this.auditoriumType = auditoriumType;
            return this;
        }

        public AuditoriumTOBuilder withSeats(Set<SeatEntity> seats) {
            this.seats = seats;
            return this;
        }

        public AuditoriumTOBuilder withScreeningList(Set<ScreeningEntity> screeningList) {
            this.screeningList = screeningList;
            return this;
        }

        public AuditoriumTOBuilder withCinema(CinemaTO cinema) {
            this.cinema = cinema;
            return this;
        }

        public AuditoriumTOBuilder withReservations(Set<ReservationEntity> reservations) {
            this.reservations = reservations;
            return this;
        }

        public AuditoriumTO build() {
            checkBeforeBuild();
            return new AuditoriumTO(id, auditoriumNumber, auditoriumType, seats, screeningList, cinema /*reservations*/);
        }

        private void checkBeforeBuild() {
            if (cinema == null) {
                throw new RuntimeException("Incorrect cinema to be created");
            }
        }
    }
}
