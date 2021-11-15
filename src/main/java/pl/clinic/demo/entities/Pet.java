package pl.clinic.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPet;

    @Column
    String name;
    @Column
    LocalDate dateOfBirth;

    public Pet() {
    }

    public Pet(Long idPet, String name, LocalDate dateOfBirth) {
        this.idPet = idPet;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

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
