package cinema.system.types;

import cinema.system.domain.ReservationEntity;
import cinema.system.domain.enumerations.SeatType;

import java.util.Set;

public class SeatTO {

    private Long id;

    private Integer seatNumber;

    private String seatRow;

    private SeatType seatType;

    private AuditoriumTO auditorium;

    public SeatTO(Long id, Integer seatNumber, String seatRow, SeatType seatType, AuditoriumTO auditorium) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.seatRow = seatRow;
        this.seatType = seatType;
        this.auditorium = auditorium;
    }

    public Long getId() {
        return id;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public AuditoriumTO getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(AuditoriumTO auditorium) {
        this.auditorium = auditorium;
    }


    public static SeatTOBuilder builder() {
        return new SeatTOBuilder();
    }

    public static final class SeatTOBuilder {
        private Long id;
        private Integer seatNumber;
        private String seatRow;
        private SeatType seatType;
        private AuditoriumTO auditorium;
        private Set<ReservationEntity> reservations;

        public SeatTOBuilder() {
        }

        public SeatTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SeatTOBuilder withSeatNumber(Integer seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public SeatTOBuilder withSeatRow(String seatRow) {
            this.seatRow = seatRow;
            return this;
        }

        public SeatTOBuilder withSeatType(SeatType seatType) {
            this.seatType = seatType;
            return this;
        }

        public SeatTOBuilder withAuditorium(AuditoriumTO auditorium) {
            this.auditorium = auditorium;
            return this;
        }

        public SeatTOBuilder withReservations(Set<ReservationEntity> reservations) {
            this.reservations = reservations;
            return this;
        }

        public SeatTO build() {
            checkBeforeBuild(auditorium);
            return new SeatTO(id, seatNumber, seatRow, seatType, auditorium/*, reservations*/);
        }

        private void checkBeforeBuild(AuditoriumTO auditorium) {
            if (auditorium == null) {
                throw new RuntimeException("Incorrect auditorium to be created");
            }
        }
    }
}
