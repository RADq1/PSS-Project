package pl.clinic.demo.entities;

import org.hibernate.mapping.Join;

import javax.persistence.*;

@Entity
public class Visits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idVisit;

    //TODO - jaki zwierzak umówiony, na jaką datę i godzinę,

    @ManyToOne
    @JoinColumn(name = "user")
    private Users user;


    public Visits(Long idVisit) {
        this.idVisit = idVisit;
    }

    public Visits() {
    }

    public Long getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(Long idVisit) {
        this.idVisit = idVisit;
    }
}
