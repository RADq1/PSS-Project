package pl.clinic.demo.front;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;

@UIScope
@SpringComponent
@Route("panelAdmin") //sciezka
public class PanelAdmin {

    @PostConstruct
    private void init() {
        H1 h1 = new H1("Panel admina, logowanie oraz akceptacja wizyt");
        //TODO LOGOWANIE DLA WETERYNARZA, AKCEPTACJA WIZYT DLA DANEGO WETERYNARZA
    }
}
