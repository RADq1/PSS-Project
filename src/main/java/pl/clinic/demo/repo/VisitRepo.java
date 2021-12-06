package pl.clinic.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.clinic.demo.entities.Users;
import pl.clinic.demo.entities.Veterinarians;
import pl.clinic.demo.entities.Visits;

import java.util.List;
import java.util.Optional;


@Repository
public interface VisitRepo extends JpaRepository<Visits, Long> {

    List<Visits> findByUser(Users user);
//    List<Visits> findByVeterinarian(Veterinarians veterinarians);
}
