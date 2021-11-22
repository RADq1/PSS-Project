package pl.clinic.demo.entities;

import org.apache.catalina.User;
import pl.clinic.demo.enums.Pets;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPet;

    @Column
    String name;
    @Column
    LocalDate dateOfBirth;
    @Column
    Pets pets;

    public Pet() {
    }

    public Pet(Long idPet, String name, LocalDate dateOfBirth) {
        this.idPet = idPet;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    //Relacja z users
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "petsList")
    //private List<Users> usersList = new ArrayList<>();
    private Set<Users> users;

    //Relacja z visits
    @ManyToOne
    @JoinColumn(name="visitList")
    private Visits visits;



    public Long getIdPet() {
        return idPet;
    }

    public void setIdPet(Long idPet) {
        this.idPet = idPet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
