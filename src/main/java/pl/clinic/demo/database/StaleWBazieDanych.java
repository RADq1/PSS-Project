package pl.clinic.demo.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.clinic.demo.entities.Veterinarians;
import pl.clinic.demo.repo.VeterinarianRepo;

@Configuration
public class StaleWBazieDanych {

    @Bean
    CommandLineRunner addRecords(VeterinarianRepo veterinarianRepo)
    {
        return args -> {
//            veterinarianRepo.save(new Veterinarians("Robert", "Głośnicki", "Neurologia"));
//            veterinarianRepo.save(new Veterinarians("Dawid", "Kleina", "Dermatologia"));
//            veterinarianRepo.save(new Veterinarians("Adam", "Gawryś", "Okulistyka"));
        };
    }

}
