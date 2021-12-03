package pl.clinic.demo.front;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDateTime;

@UIScope
@SpringComponent
@Route("") //sciezka
public class Home extends VerticalLayout{

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

            //przekierowanie do rezerwacji
            reservationButton = new Button("Rezerwacja wizyty bez rejestracji");
            reservationButton.addClickListener(c->{
                UI.getCurrent().getPage().setLocation("/reservation");
            });
            add(reservationButton);
        }
    }
