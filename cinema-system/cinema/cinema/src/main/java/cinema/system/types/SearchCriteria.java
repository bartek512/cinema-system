package cinema.system.types;

import java.time.LocalDate;

public class SearchCriteria {


    private Long auditoriumId;
    private Integer seatNumber;
    private String seatRow;
    private LocalDate startDate;
    private LocalDate endDate;
    private String movieTitle;

    public Long getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(Long auditoriumId) {
        this.auditoriumId = auditoriumId;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public static SearchCriteriaBuilder builder() {
        return new SearchCriteriaBuilder();
    }

    public static final class SearchCriteriaBuilder {
        private Long auditoriumId;
        private Integer seatNumber;
        private String seatRow;
        private LocalDate startDate;
        private LocalDate endDate;
        private String movieTitle;

        private SearchCriteriaBuilder() {
        }

        public SearchCriteriaBuilder withAuditoriumId(Long auditoriumId) {
            this.auditoriumId = auditoriumId;
            return this;
        }

        public SearchCriteriaBuilder withSeatNumber(Integer seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public SearchCriteriaBuilder withSeatRow(String seatRow) {
            this.seatRow = seatRow;
            return this;
        }

        public SearchCriteriaBuilder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public SearchCriteriaBuilder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public SearchCriteriaBuilder withMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
            return this;
        }

        public SearchCriteria build() {
            SearchCriteria searchCriteria = new SearchCriteria();
            searchCriteria.setAuditoriumId(auditoriumId);
            searchCriteria.setSeatNumber(seatNumber);
            searchCriteria.setSeatRow(seatRow);
            searchCriteria.setStartDate(startDate);
            searchCriteria.setEndDate(endDate);
            searchCriteria.setMovieTitle(movieTitle);
            return searchCriteria;
        }
    }
}
