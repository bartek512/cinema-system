package cinema.system.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Cinema.findByAddress",
                query = " SELECT c FROM CinemaEntity c WHERE c.adress = :address"),
        @NamedQuery(name = "Cinema.getAllAuditorium",
                query = "SELECT a FROM AuditoriumEntity a JOIN a.cinema c WHERE c.id = :id")
}
)

@Entity
@Table(name = "CINEMA")
public class CinemaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cinema_name")
    private String name;

    @Column(name = "cinema_adress")
    private String adress;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "cinema")
    private Set<AuditoriumEntity> auditoriumList;

    public CinemaEntity() {
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<AuditoriumEntity> getAuditoriumSet() {
        return auditoriumList;
    }

    public void setAuditoriumSet(Set<AuditoriumEntity> auditoriumList) {
        this.auditoriumList = auditoriumList;
    }
}
