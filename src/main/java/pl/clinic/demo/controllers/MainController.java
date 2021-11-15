package pl.clinic.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String get() {
        return "home";
    }
    @GetMapping("/adam")
    public String lek1() {return "adam";}

    @GetMapping("/register")
    public String register() {return "register";}

    @GetMapping("/reservation")
    public String reservation() {return "reservation";}
}
