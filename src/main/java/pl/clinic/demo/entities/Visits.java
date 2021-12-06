package pl.clinic.demo.entities;

import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Visits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idVisit;

    @Column
    LocalDateTime dateTime;
    @Column
    String imie;
    @Column
    String opis;
    @Column
    String gatunek;

    @ManyToOne
    @JoinColumn(name = "user")
    private Users user;

    public Veterinarians getVet() {
        return vet;
    }

    public void setVet(Veterinarians vet) {
        this.vet = vet;
    }

    @ManyToOne
    @JoinColumn(name = "vet")
    private Veterinarians vet;

    public Visits(Long idVisit, LocalDateTime dateTime, String imie, String opis, String gatunek) {
        this.idVisit = idVisit;
        this.dateTime = dateTime;
        this.imie = imie;
        this.opis = opis;
        this.gatunek = gatunek;
    }

//    //konstruktor do rejestracji wizyt bez rejestracji konta
//    public Visits(LocalDateTime dateTime, String imie, String opis, String gatunek) {
//        this.dateTime = dateTime;
//        this.imie = imie;
//        this.opis = opis;
//        this.gatunek = gatunek;
//    }
//
//    //konstruktor do rejestracji wizyt po zalogowaniu
//    //Visits visits = new Visits(dateTimePicker.getValue(), imie.getValue(), opis.getValue(), comboBox.getValue().toString(), user);
//    public Visits(LocalDateTime dateTime, String imie, String opis, String gatunek, Users user) {
//        this.dateTime = dateTime;
//        this.imie = imie;
//        this.opis = opis;
//        this.gatunek = gatunek;
//        this.user = user;
//    }

    //konstruktor do rejestracji wizyt bez rejestracji konta
    public Visits(LocalDateTime dateTime, String imie, String opis, String gatunek, Veterinarians vet) {
        this.dateTime = dateTime;
        this.imie = imie;
        this.opis = opis;
        this.gatunek = gatunek;
        this.vet = vet;
    }

    //konstruktor do rejestracji wizyt po zalogowaniu
    //Visits visits = new Visits(dateTimePicker.getValue(), imie.getValue(), opis.getValue(), comboBox.getValue().toString(), user);
    public Visits(LocalDateTime dateTime, String imie, String opis, String gatunek,Veterinarians vet, Users user) {
        this.dateTime = dateTime;
        this.imie = imie;
        this.opis = opis;
        this.gatunek = gatunek;
        this.user = user;
        this.vet = vet;
    }




    public Visits() {
    }

    public Long getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(Long idVisit) {
        this.idVisit = idVisit;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Visits{" +
                "idVisit=" + idVisit +
                ", dateTime=" + dateTime +
                ", imie='" + imie + '\'' +
                ", opis='" + opis + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", user=" + user +
                '}';
    }
}
