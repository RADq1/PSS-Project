package pl.clinic.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.clinic.demo.entities.Pet;

@Repository
public interface PetRepo extends JpaRepository<Pet, Long> {
}
