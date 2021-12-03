package pl.clinic.demo.front;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
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

        H3 h3 = new H3("Lekarze kliniki weterynaryjnej w Fordonie");
        add(h3);
        Image image = new Image("https://i.imgur.com/gtU3dRG.png","Doktor Adam");
        image.setMaxHeight("400px");
        image.setMaxWidth("400px");
        H5 h5 = new H5("lek. wet. Adam Krzysztof Gawryś | Specjalista chorób psów i kotów – Dermatologia / USG / Interna");
        add(image, h5);
        //https://i.imgur.com/iIaBW0F.gif
    }
}