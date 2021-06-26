package cinema.system.types;

import cinema.system.domain.enumerations.AgeCategory;
import cinema.system.domain.enumerations.MovieCategory;

import java.time.LocalDate;
import java.util.Set;

public class MovieTO {

    private Long id;

    private AgeCategory ageCategory;

    private LocalDate availableFrom;

    private LocalDate availableUntil;

    private MovieCategory movieCategory;

    private String title;

    private Integer year;

    private Set<ScreeningTO> screenings;

    public MovieTO(AgeCategory ageCategory, LocalDate availableFrom, LocalDate availableUntil, MovieCategory movieCategory, String title, Integer year, Set<ScreeningTO> screenings) {
        this.ageCategory = ageCategory;
        this.availableFrom = availableFrom;
        this.availableUntil = availableUntil;
        this.movieCategory = movieCategory;
        this.title = title;
        this.year = year;
        this.screenings = screenings;
    }

    public Set<ScreeningTO> getScreenings() {
        return screenings;
    }

    public void setScreenings(Set<ScreeningTO> screenings) {
        this.screenings = screenings;
    }

    public Long getId() {
        return id;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public LocalDate getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalDate availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalDate getAvailableUntil() {
        return availableUntil;
    }

    public void setAvailableUntil(LocalDate availableUntil) {
        this.availableUntil = availableUntil;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public static MovieTOBuilder builder() {
        return new MovieTOBuilder();
    }


    public static final class MovieTOBuilder {
        private Long id;
        private AgeCategory ageCategory;
        private LocalDate availableFrom;
        private LocalDate availableUntil;
        private MovieCategory movieCategory;
        private String title;
        private Integer year;
        private Set<ScreeningTO> screenings;

        public MovieTOBuilder() {
        }


        public MovieTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public MovieTOBuilder withAgeCategory(AgeCategory ageCategory) {
            this.ageCategory = ageCategory;
            return this;
        }

        public MovieTOBuilder withAvailableFrom(LocalDate availableFrom) {
            this.availableFrom = availableFrom;
            return this;
        }

        public MovieTOBuilder withAvailableUntil(LocalDate availableUntil) {
            this.availableUntil = availableUntil;
            return this;
        }

        public MovieTOBuilder withMovieCategory(MovieCategory movieCategory) {
            this.movieCategory = movieCategory;
            return this;
        }

        public MovieTOBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieTOBuilder withYear(Integer year) {
            this.year = year;
            return this;
        }

        public MovieTOBuilder withScreenings(Set<ScreeningTO> screenings) {
            this.screenings = screenings;
            return this;
        }

        public MovieTO build() {
            MovieTO movieTO = new MovieTO(ageCategory, availableFrom, availableUntil, movieCategory, title, year, screenings);
            movieTO.id = this.id;
            return movieTO;
        }
    }
}

