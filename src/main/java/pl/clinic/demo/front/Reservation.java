package pl.clinic.demo.front;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import pl.clinic.demo.entities.Pet;
import pl.clinic.demo.services.PetService;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@UIScope
@SpringComponent
@Route("reservation") //sciezka
public class Reservation extends VerticalLayout {
    LocalDateTime date;
    String time;
    Button button;
    DateTimePicker dateTimePicker = new DateTimePicker();

    ComboBox comboBox = new ComboBox<>("Gatunek");

    @PostConstruct
    private void init(){

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

        dateTimePicker.setLabel("Wybierz datę wizyty");
        dateTimePicker.setStep(Duration.ofMinutes(20));
        dateTimePicker.setValue(LocalDateTime.of(2020, 6, 12, 12, 20, 0));
        add(dateTimePicker);
        button = new Button("Rezerwacja");
        button.addClickListener(c->{
            UI.getCurrent().getPage().setLocation("/done");
        });

        add(button);
        dateTimePicker.getTimePlaceholder();
        time = dateTimePicker.getTimePlaceholder();
    }
}
