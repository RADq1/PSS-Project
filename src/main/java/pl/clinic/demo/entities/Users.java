package pl.clinic.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;

    @Column
    String name;
    @Column
    String surName;
    @Column
    String login;
    @Column
    String password;
    @Column
    String email;

    //RELACJE
    @OneToMany
    private List<Visits> visitsList;
    //Jeden uzytkownik moze miec wiele wizyt, a jedna wizyta
    //moze byc przypisana do jednego uzytkownika
    public Users() {
    }

    public Users(Long idUser, String name, String surName, String login, String password, String email) {
        this.idUser = idUser;
        this.name = name;
        this.surName = surName;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
