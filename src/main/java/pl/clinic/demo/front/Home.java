package pl.clinic.demo.front;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.html.Image;
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
            Tab panelAdmin = new Tab("Panel admin");
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
            panelAdmin.getElement().addEventListener("click", event -> {
                UI.getCurrent().getPage().setLocation("/panelAdmin");
            });

            Tabs tabs = new Tabs(home, register, aboutUs, login, panelAdmin);
            add(tabs);
            Image image = new Image("https://static.oferteo.pl/images/portfolio/4656059/orig/615rijvc8v7-106706554-3251271181591909-2256940885905921326-o.jpg", "klinika");
            //przekierowanie do rezerwacji
            image.setMaxHeight("400px");
            image.setMaxWidth("400px");

            reservationButton = new Button("Rezerwacja wizyty bez rejestracji");
            reservationButton.addClickListener(c->{
                UI.getCurrent().getPage().setLocation("/reservation");
            });
            add(image, reservationButton);


        }
    }
