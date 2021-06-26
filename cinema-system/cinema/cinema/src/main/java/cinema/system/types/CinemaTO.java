package cinema.system.types;

public class CinemaTO {

    private Long id;

    private String name;

    private String adress;

    public CinemaTO(Long id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public static CinemaTOBuilder builder() {
        return new CinemaTOBuilder();
    }


    public static final class CinemaTOBuilder {
        private Long id;
        private String name;
        private String adress;

        public CinemaTOBuilder() {
        }

        public CinemaTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CinemaTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CinemaTOBuilder withAdress(String adress) {
            this.adress = adress;
            return this;
        }

        public CinemaTO build() {
            return new CinemaTO(id, name, adress);
        }
    }
}
