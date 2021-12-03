package pl.clinic.demo.front;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;
@UIScope
@SpringComponent
@Route("register") //sciezka
public class Register extends VerticalLayout {

    Button reservationButton;
    @PostConstruct
    private void init(){
        //menu główne
        //home
        Tab home = new Tab("Strona główna");
        Tab register = new Tab("Rejestracja");
        Tab aboutUs = new Tab("O nas");
        home.getElement().addEventListener("click", event -> {
            UI.getCurrent().getPage().setLocation("/");
        });
        register.getElement().addEventListener("click", event -> {
            UI.getCurrent().getPage().setLocation("/register");
        });
        aboutUs.getElement().addEventListener("click", event -> {
            UI.getCurrent().getPage().setLocation("/aboutUs");
        });

        Tabs tabs = new Tabs(home, register, aboutUs);
        add(tabs);
        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");
        TextField username = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        PasswordField confirmPassword = new PasswordField("Confirm password");

        add(firstName,lastName,username,password,confirmPassword);
    }

    }


