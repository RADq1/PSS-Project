package pl.clinic.demo.front;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import pl.clinic.demo.entities.Pet;
import pl.clinic.demo.entities.Veterinarians;
import pl.clinic.demo.entities.Visits;
import pl.clinic.demo.services.ReservationService;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@UIScope
@SpringComponent
@Route("reservation") //sciezka
public class Reservation extends VerticalLayout {

    @Autowired
    ReservationService reservationService;

    LocalDateTime date;
    String time;
    Button button;
    DateTimePicker dateTimePicker = new DateTimePicker();

    ComboBox comboBox = new ComboBox<>("Gatunek");
    ComboBox chooseVet = new ComboBox<>("Weterynarz");

    @PostConstruct
    private void init(){
        //TODO WYBOR LEKARZA/DOKTORA DO KTOREGO CHCEMY ZAREZERWOWAC WIZYTE
        TextArea imie = new TextArea();
        imie.setLabel("Imię zwierzaka");
        imie.setMaxLength(15);
        add(imie);

        TextArea opis = new TextArea();
        opis.setLabel("Przyczyna wizyty");
        add(opis);
        opis.setMaxLength(100);
        opis.setValueChangeMode(ValueChangeMode.EAGER);
        opis.addValueChangeListener(e -> {
            e.getSource().setHelperText(e.getValue().length() + "/" + 100);
        });
        opis.setValue("Opisz krótko cel swojej wizyty (np. Kontrolna, Zabieg, Badanie USG)");

        comboBox.setItems("Pies", "Kot", "Papuga");
        add(comboBox);
        //wyciagniecie z bazy imiona weterynarzy

        chooseVet.setItems(reservationService.nameVet());
        add(chooseVet);



        dateTimePicker.setLabel("Wybierz datę wizyty");
        dateTimePicker.setStep(Duration.ofMinutes(20));
        dateTimePicker.setValue(LocalDateTime.of(2021, 12, 7, 12, 20, 0));
        dateTimePicker.setMin(LocalDateTime.of(2021,12, 7, 12, 0, 0));
        add(dateTimePicker);
        button = new Button("Rezerwacja");
            button.addClickListener(c->{
                if(imie.getValue() == null && opis.getValue() == null && comboBox.getValue().toString() == null)
                {
                    Notification.show("Sprawdź wszystkie pola zanim zarezerwujesz wizytę!");
                    return;
                }
                else {
                    Visits visits = new Visits(dateTimePicker.getValue(), imie.getValue(), opis.getValue(), comboBox.getValue().toString(), (Veterinarians) chooseVet.getValue());
                    reservationService.addReservationWithoutLogin(visits);
                    Notification.show("Gratulacje, udalo sie zarezerwować wizytę!");
                    UI.getCurrent().getPage().setLocation("/");
                }
            });

        add(button);

    }
}
