package pl.clinic.demo.entities;

import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Visits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idVisit;
    
    //TODO - jaki zwierzak umówiony, na jaką datę i godzinę,

    //relacja do psa
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "visits")
    private Set<Pet> pets;

    //relacja do weterynarza
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "visit")
    private Set<Veterinarians> veterinarians;


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
