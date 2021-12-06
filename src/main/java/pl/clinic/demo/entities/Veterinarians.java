package pl.clinic.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Veterinarians {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idVeterinarian;

    @Column
    String name;
    @Column
    String surName;
    @Column
    String specialty;
    @Column
    String password;

    @OneToMany
    private List<Visits> visitsList;

    public List<Visits> getVisitsList() {
        return visitsList;
    }

    public void setVisitsList(List<Visits> visitsList) {
        this.visitsList = visitsList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Veterinarians(String name, String surName, String specialty) {
        this.name = name;
        this.surName = surName;
        this.specialty = specialty;
    }

    public Veterinarians() {
    }

    public Long getIdVeterinarian() {
        return idVeterinarian;
    }

    public void setIdVeterinarian(Long idVeterinarian) {
        this.idVeterinarian = idVeterinarian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return name;
    }
}
