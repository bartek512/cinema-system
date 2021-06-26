package cinema.system.domain;

import cinema.system.domain.enumerations.MovieCategory;
import cinema.system.domain.enumerations.AgeCategory;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Movie.getAllReservations",
                query = "SELECT r FROM MovieEntity m JOIN m.screeningSet s JOIN s.reservations r WHERE m.id = :id")
}
)
@Entity
@Table(name = "MOVIE")
public class MovieEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "age_category")
    @Enumerated(EnumType.STRING)
    private AgeCategory ageCategory;

    @Column(name = "available_from")
    private LocalDate availableFrom;

    @Column(name = "available_until")
    private LocalDate availableUntil;

    @Column(name = "movie_category")
    @Enumerated(EnumType.STRING)
    private MovieCategory movieCategory;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private Integer year;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "movie")
    private Set<ScreeningEntity> screeningSet;

    public MovieEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ScreeningEntity> getScreeningSet() {
        return screeningSet;
    }

    public void setScreeningSet(Set<ScreeningEntity> screeningSet) {
        this.screeningSet = screeningSet;
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
}
