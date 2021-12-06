package pl.clinic.demo.front;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;

@UIScope
@SpringComponent
@Route("aboutUs") //sciezka
public class AboutUs extends VerticalLayout {

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

        //TODO OPIS LEKARZY, LECZNICY WETERYNARYJNEJ ITP.
        //TODO KONTAKT
        //Sekcja Adama
        Accordion accordion = new Accordion();

        Span name = new Span("lek. wet. Adam Krzysztof Gawryś");
        Span email = new Span("adagaw@wp.pl");
        Span specialization = new Span("Specjalista chorób psów i kotów – Dermatologia / USG / Interna");
        Image image = new Image("https://i.imgur.com/gtU3dRG.png","Doktor Adam");
        image.setMaxHeight("400px");
        image.setMaxWidth("400px");

        VerticalLayout adamLayout = new VerticalLayout(name, email,specialization,image);
        adamLayout.setSpacing(false);
        adamLayout.setPadding(false);

        accordion.add("lek. wet. Adam Krzysztof Gawryś", adamLayout);
        add(accordion);

        //Sekcja Roberta
        Accordion accordion1 = new Accordion();

        Span name1 = new Span("lek. wet. Robert Głośnicki");
        Span email1 = new Span("robglo@wp.pl");
        Span specialization1 = new Span("Specjalista chorób psów i kotów – Patomorfolog / Operacje zabiegowe");
        Image robert  = new Image("https://i.imgur.com/0waVci8.jpg", "Doktorek Robert");
        robert.setMaxHeight("400px");
        robert.setMaxWidth("400px");
        VerticalLayout robertLayout = new VerticalLayout(name1, email1,specialization1, robert);
        robertLayout.setSpacing(false);
        robertLayout.setPadding(false);

        accordion1.add("lek. wet. Robert Głośnicki", robertLayout);
        add(accordion1);
        //Kontakt
        Accordion kontakt = new Accordion();

        Span name2 = new Span("Klinika weterynaryjna w Fordonie");
        Span email2 = new Span("fordonWet@gmail.com");
        Span phone = new Span("997-400-300");
        Span adress = new Span("Ul. Fordońska 431");
        Span hours = new Span("Pon-Pt 9:00 - 21:00");
        Span attention = new Span("Uwaga! W przypadku bardzo i tylko bardzo poważnych problemów dzwonić na numer telefonu 24H!");
        Span phone24h = new Span("898-628-912");
        VerticalLayout contactLayout = new VerticalLayout(name2, email2, phone, adress, hours);
        HorizontalLayout contactLayout2 = new HorizontalLayout(attention, phone24h);
        adamLayout.setSpacing(false);
        adamLayout.setPadding(false);

        kontakt.add("Kontakt", contactLayout);
        kontakt.add("Pilny kontakt", contactLayout2);
        add(kontakt);
    }
}