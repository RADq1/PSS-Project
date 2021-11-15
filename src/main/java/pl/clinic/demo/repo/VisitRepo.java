package pl.clinic.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.clinic.demo.entities.Visits;


@Repository
public interface VisitRepo extends JpaRepository<Visits, Long> {

}
