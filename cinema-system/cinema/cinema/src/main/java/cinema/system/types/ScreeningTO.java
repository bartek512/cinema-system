package cinema.system.types;

import java.time.LocalDate;

public class ScreeningTO {

    private Long id;

    private LocalDate date;

    private AuditoriumTO auditorium;

    private MovieTO movie;

    public ScreeningTO(Long id, LocalDate date, AuditoriumTO auditorium, MovieTO movie) {
        this.id = id;
        this.date = date;
        this.auditorium = auditorium;
        this.movie = movie;
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

    public AuditoriumTO getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(AuditoriumTO auditorium) {
        this.auditorium = auditorium;
    }

    public MovieTO getMovie() {
        return movie;
    }

    public void setMovie(MovieTO movie) {
        this.movie = movie;
    }

    public static ScreeningTOBuilder builder() {
        return new ScreeningTOBuilder();
    }


    public static final class ScreeningTOBuilder {
        private Long id;
        private LocalDate date;
        private AuditoriumTO auditorium;
        private MovieTO movie;

        public ScreeningTOBuilder() {
        }

        public ScreeningTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ScreeningTOBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public ScreeningTOBuilder withAuditorium(AuditoriumTO auditorium) {
            this.auditorium = auditorium;
            return this;
        }

        public ScreeningTOBuilder withMovie(MovieTO movie) {
            this.movie = movie;
            return this;
        }

        public ScreeningTO build() {
            checkBeforeBuild();
            return new ScreeningTO(id, date, auditorium, movie/*, reservations*/);
        }

        private void checkBeforeBuild() {
            if (movie == null || auditorium == null) {
                throw new RuntimeException("Incorrect movie or auditorium to be created");
            }
        }
    }
}
