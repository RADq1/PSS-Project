package pl.clinic.demo.front;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import pl.clinic.demo.entities.Users;
import pl.clinic.demo.entities.Visits;
import pl.clinic.demo.services.UserService;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Email;
import java.util.Optional;

@UIScope
@SpringComponent
@Route("register") //sciezka
public class Register extends VerticalLayout {

    @Autowired
    UserService userService;
    Button button;
    Button reservationButton;
    @PostConstruct
    private void init(){
        //menu główne
        //home
        Tab home = new Tab("Strona główna");
        Tab register = new Tab("Rejestracja");
        Tab aboutUs = new Tab("O nas");
        Tab login = new Tab("Logowanie");
        home.getElement().addEventListener("click", event -> {
            UI.getCurrent().getPage().setLocation("/");
        });
        register.getElement().addEventListener("click", event -> {
            UI.getCurrent().getPage().setLocation("/register");
        });
        aboutUs.getElement().addEventListener("click", event -> {
            UI.getCurrent().getPage().setLocation("/aboutUs");
        });
        login.getElement().addEventListener("click", event -> {
            UI.getCurrent().getPage().setLocation("/login");
        });
        Tabs tabs = new Tabs(home, register, aboutUs, login);

        add(tabs);

        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");
        TextField username = new TextField("Username");
        EmailField email = new EmailField("E-mail");
        PasswordField password = new PasswordField("Password");
//        PasswordField confirmPassword = new PasswordField("Confirm password");

        add(firstName,lastName,username,password, email); // confirmPassword


        button = new Button("Rezerwacja");
        button.addClickListener(c->{

                Optional emailToCheck = userService.checkEmail(email.getValue());
                Optional usernameToCheck = userService.checkLogin(username.getValue());
                //Sprawdzenie, czy podany email istnieje juz w bazie danych
            if(firstName.getValue() == null && lastName.getValue() == null && username.getValue() == null && password.getValue() == null && email.getValue() == null) {
                //System.out.println("Wszystkie pola są wypełnione");
                if (emailToCheck.isEmpty()) {
                    //Sprawdzenie, czy podany login(username) istnieje juz w bazie danych
                    if (usernameToCheck.isEmpty()) {
                        Users user = new Users(firstName.getValue(), lastName.getValue(), username.getValue(), password.getValue(), email.getValue());//String name, String surName, String login, String password, String email
                        userService.registerUser(user);
                        Notification.show("Witaj," + firstName.getValue() + "Poprawnie założono konto");
                    } else {
//                        System.out.println("Taki uzytkownik jest zajety");
                        Notification.show("Taki uzytkownik jest zajety");
                    }
                } else {
//                    System.out.println("Email juz istnieje");
                    Notification.show("Email juz istnieje");
                }
            }
            else{
                Notification.show("Wszystkie pola są obowiązkowe!");
            }
        });
        add(button);
    }

    }


