package pl.clinic.demo.front;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import pl.clinic.demo.entities.Users;
import pl.clinic.demo.entities.Visits;
import pl.clinic.demo.services.ReservationService;
import pl.clinic.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@UIScope
@SpringComponent
@Route("login") //sciezka
public class LoginPage extends VerticalLayout {
    @Autowired
    ReservationService reservationService;

    Button button;
    DateTimePicker dateTimePicker = new DateTimePicker();

    ComboBox comboBox = new ComboBox<>("Gatunek");
    ComboBox chooseVet = new ComboBox<>("Weterynarz");

    @Autowired
    UserService userService;

    Button reservationButton = new Button("Zarezerwuj wizytę");
    Button btnLogin = new Button("Zaloguj się");
    Button logout = new Button("Wyloguj się");
    Button backButton = new Button("Cofnij się");
    Button historyButton = new Button("Historia wizyt pupila");
    Button editAcc = new Button("Edycja konta");

    //TODO ZAPIS USERA PO ZALOGOWANIU
    private Users user;
    public boolean isLogged;

    @PostConstruct
    private void init(){

        //TODO LOGOWANIE
        TextField username = new TextField("Username");
        PasswordField password = new PasswordField("Password");

//        System.out.println(isLogged);
        if(isLogged){
            add(logout, reservationButton, historyButton);
        }
        else{
            add(username, password);
        }

        //REZERWACJA WIZYTY DLA ZALOGOWANEGO
        //TODO WYBOR LEKARZA/DOKTORA DO KTOREGO CHCEMY ZAREZERWOWAC WIZYTE
        TextArea imie = new TextArea();
        imie.setLabel("Imię zwierzaka");
        imie.setMaxLength(15);

        TextArea opis = new TextArea();
        opis.setLabel("Przyczyna wizyty");
        opis.setMaxLength(100);
        opis.setValueChangeMode(ValueChangeMode.EAGER);
        opis.addValueChangeListener(e -> {
            e.getSource().setHelperText(e.getValue().length() + "/" + 100);
        });
        opis.setValue("Opisz krótko cel swojej wizyty (np. Kontrolna, Zabieg, Badanie USG)");

        comboBox.setItems("Pies", "Kot", "Papuga");

        dateTimePicker.setLabel("Wybierz datę wizyty");
        dateTimePicker.setStep(Duration.ofMinutes(20));
        dateTimePicker.setValue(LocalDateTime.of(2021, 12, 7, 12, 20, 0));
        button = new Button("Rezerwacja");

            button.addClickListener(c->{
                if(imie.getValue() == null && opis.getValue() == null && comboBox.getValue().toString() == null)
                {
                    Notification.show("Sprawdź wszystkie pola zanim zarezerwujesz wizytę!");
                    return;
                }
                else {
//                    System.out.println(dateTimePicker.getValue());
//                    System.out.println(imie.getValue());
//                    System.out.println(opis.getValue());
//                    System.out.println(comboBox.getValue().toString());
//                    System.out.println(user.getLogin());
                    Visits visits = new Visits(dateTimePicker.getValue(), imie.getValue(), opis.getValue(), comboBox.getValue().toString(), user);
                    reservationService.addReservationWithoutLogin(visits);
//                    System.out.println(visits);
                    Notification.show("Gratulacje, udalo sie zarezerwować wizytę!");
                }
            });
        //RESERVATION
        reservationButton.addClickListener(event -> {
            removeAll();
//            remove(imie, opis, dateTimePicker, comboBox, button, backButton);
            add(imie, opis, dateTimePicker, comboBox, button, backButton);
        });
        //LOGOUT
        logout.addClickListener(event -> {
            Notification.show("Pomyślnie wylogowano się");
            isLogged = false;
            removeAll();
            add(username, password, btnLogin);
        });
        //COFANIE
        backButton.addClickListener(event -> {
            removeAll();
            add(logout, reservationButton, historyButton);
        });
        //PANEL HISTORIA PUPILA
        historyButton.addClickListener(event -> {
            removeAll();
            add(logout, reservationButton, historyButton);

            H1 h1 = new H1("Historia wizyt Twojego zwierzaka/ów " + user.getName());

            //TODO Wyswietlanie zwierzaków pobranych z tabeli Visits
            List<Visits> visitsList = userService.findPetsForUser(user);
//            System.out.println(visitsList);

            Grid<Visits> grid = new Grid<>();
            grid.setItems(visitsList);
            grid.addColumn(Visits::getImie).setHeader("Imie psa");
            grid.addColumn(Visits::getDateTime).setHeader("Data oraz godzina wizyty");
            grid.addColumn(Visits::getGatunek).setHeader("Gatunek");
            grid.addColumn(Visits::getOpis).setHeader("Opis/Objawy");

            add(grid,h1,backButton);
        });

        //LOGOWANIE
        btnLogin.addClickListener(event -> {
            Optional usernameToCheck = userService.checkLogin(username.getValue());

            if(usernameToCheck.isPresent())
            {
                  Users userCheck = (Users) usernameToCheck.get(); //rzutowanie optionala na klase
//                System.out.println("Istnieje taki uzytkownik w bazie");
                if(userCheck.getPassword().equals(password.getValue()))
                {
                    Notification.show("Brawisssimo, jestes zalogowany!");
                    isLogged = true;
                    user = userCheck;
                    System.out.println(isLogged);
                    H3 userNameText = new H3("Witaj, " + user.getName());
                    //H3 h3 = new H3("Witaj " + userCheck.getName());
                    removeAll();
                    add(userNameText,logout, reservationButton, historyButton);
                    //TODO WIDOK ZALOGOWANEGO, NOWE FUNCKJE (Historia pupila, Wyloguj)
                }
                else
                {
                    Notification.show("Niepoprawne haslo");
                    //dla podanego uzytkownika haslo jest niepoprawne
                }
            }
            else
            {
                Notification.show("Niepoprawny login lub haslo");
                //nie istnieje taki uzytkownik
            }
        });
        add(btnLogin);

    }

}
