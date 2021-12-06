package pl.clinic.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.clinic.demo.entities.Visits;
import pl.clinic.demo.repo.VisitRepo;

@Service
public class ReservationService {

    private final VisitRepo visitRepo;

    public ReservationService(VisitRepo visitRepo) {
        this.visitRepo = visitRepo;
    }

    public void addReservationWithoutLogin(Visits visits){
        System.out.println("rezerwacja");
        visitRepo.save(visits);
    }

//    public void addReservationWithLogin(Visits visits){
//        System.out.println("rezerwacja");
//        visitRepo.save(visits);
//    }
}
