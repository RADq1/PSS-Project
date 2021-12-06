package pl.clinic.demo.front;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import pl.clinic.demo.entities.Users;
import pl.clinic.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.Optional;

@UIScope
@SpringComponent
@Route("login") //sciezka
public class LoginPage extends VerticalLayout {

    @Autowired
    UserService userService;
    Button reservationButton;
    private Users user;
    private boolean isLogged = false;
    @PostConstruct
    private void init(){

        //TODO LOGOWANIE
        TextField username = new TextField("Username");
        TextField password = new TextField("Password");

        add(username, password);

        Button btnLogin = new Button("Zaloguj się");

        Button reservation = new Button("Zarezerwuj wizytę");

        Button logout = new Button("Wyloguj się");
        logout.addClickListener(event -> {
            Notification.show("Pomyślnie wylogowano się");
            isLogged = false;
            remove(logout);
        });

        btnLogin.addClickListener(event -> {
            Optional usernameToCheck = userService.checkLogin(username.getValue());
//            Optional passwordToCheck = userService.checkPassword(password.getValue());

            if(usernameToCheck.isPresent())
            {
                Users userCheck = (Users) usernameToCheck.get(); //rzutowanie optionala na klase
//                System.out.println("Istnieje taki uzytkownik w bazie");
                if(userCheck.getPassword().equals(password.getValue()))
                {
                    Notification.show("Brawisssimo, jestes zalogowany!");
                    isLogged = true;
                    removeAll();
                    add(logout);
                    //TODO boolean logged
                    //TODO WIDOK ZALOGOWANEGO, NOWE FUNCKJE (Historia pupila, dodaj zwierzaka moze, Wyloguj)
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
