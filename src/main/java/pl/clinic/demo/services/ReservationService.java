package pl.clinic.demo.services;

import org.springframework.stereotype.Service;
import pl.clinic.demo.entities.Users;
import pl.clinic.demo.entities.Veterinarians;
import pl.clinic.demo.entities.Visits;
import pl.clinic.demo.repo.VeterinarianRepo;
import pl.clinic.demo.repo.VisitRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final VisitRepo visitRepo;

    private final VeterinarianRepo veterinariansVeterinarianRepo;


    public ReservationService(VisitRepo visitRepo, VeterinarianRepo veterinariansVeterinarianRepo) {
        this.visitRepo = visitRepo;
        this.veterinariansVeterinarianRepo = veterinariansVeterinarianRepo;
    }

    public void addReservationWithoutLogin(Visits visits){
        System.out.println("rezerwacja");
        visitRepo.save(visits);
    }

    public List<Veterinarians> nameVet(){
        return veterinariansVeterinarianRepo.nameVet();
    }




}
