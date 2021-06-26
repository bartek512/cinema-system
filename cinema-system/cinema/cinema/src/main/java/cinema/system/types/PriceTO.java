package cinema.system.types;

import cinema.system.domain.enumerations.AuditoriumType;
import cinema.system.domain.enumerations.SeatType;
import cinema.system.domain.enumerations.WeekDay;

import java.time.LocalDate;

public class PriceTO {

    private Long id;

    private AuditoriumType auditoriumType;

    private Double price;

    private SeatType seatType;

    private LocalDate validFrom;

    private LocalDate validUntil;

    private WeekDay weekDay;

    public PriceTO(Long id, AuditoriumType auditoriumType, Double price, SeatType seatType, LocalDate validFrom, LocalDate validUntil, WeekDay weekDay) {
        this.id = id;
        this.auditoriumType = auditoriumType;
        this.price = price;
        this.seatType = seatType;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.weekDay = weekDay;
    }

    public Long getId() {
        return id;
    }

    public AuditoriumType getAuditoriumType() {
        return auditoriumType;
    }

    public void setAuditoriumType(AuditoriumType auditoriumType) {
        this.auditoriumType = auditoriumType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public PriceTOBuilder builder() {
        return new PriceTOBuilder();
    }


    public static final class PriceTOBuilder {
        private Long id;
        private AuditoriumType auditoriumType;
        private Double price;
        private SeatType seatType;
        private LocalDate validFrom;
        private LocalDate validUntil;
        private WeekDay weekDay;

        public PriceTOBuilder() {
        }

        public PriceTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PriceTOBuilder withAuditoriumType(AuditoriumType auditoriumType) {
            this.auditoriumType = auditoriumType;
            return this;
        }

        public PriceTOBuilder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public PriceTOBuilder withSeatType(SeatType seatType) {
            this.seatType = seatType;
            return this;
        }

        public PriceTOBuilder withValidFrom(LocalDate validFrom) {
            this.validFrom = validFrom;
            return this;
        }

        public PriceTOBuilder withValidUntil(LocalDate validUntil) {
            this.validUntil = validUntil;
            return this;
        }

        public PriceTOBuilder withWeekDay(WeekDay weekDay) {
            this.weekDay = weekDay;
            return this;
        }

        public PriceTO build() {
            return new PriceTO(id, auditoriumType, price, seatType, validFrom, validUntil, weekDay);
        }
    }
}
