package pl.clinic.demo.entities;

//import pl.clinic.demo.enums.Gatunki;

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
//    @Enumerated(EnumType.STRING)
//    @Column
//    Gatunki gatunki;
    @Column
    String gatunki;

    public Pet() {
    }

    public String getGatunki() {
        return gatunki;
    }

    public void setGatunki(String gatunki) {
        this.gatunki = gatunki;
    }

    public Pet(Long idPet, String name, LocalDate dateOfBirth, String gatunki) {
        this.idPet = idPet;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gatunki = gatunki;
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
