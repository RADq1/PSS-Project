package pl.clinic.demo.front;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@UIScope
@SpringComponent
@Route("cos") //sciezka
public class Home extends VerticalLayout{

        LocalDateTime date;
        String time;
        Button button;
        DateTimePicker dateTimePicker = new DateTimePicker();
        @PostConstruct
        private void init(){
            dateTimePicker.setLabel("Meeting date and time");
            add(dateTimePicker);
            button = new Button("klik");
            add(button);
            dateTimePicker.getTimePlaceholder();
            time = dateTimePicker.getTimePlaceholder();
        }
    }
