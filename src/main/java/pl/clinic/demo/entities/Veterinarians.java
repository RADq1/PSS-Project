package pl.clinic.demo.entities;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name="visit")
    private Visits visit;

    public Veterinarians(Long id, String name, String surName, String specialty) {
        this.idVeterinarian = id;
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
}
