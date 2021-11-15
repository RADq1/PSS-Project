package pl.clinic.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.clinic.demo.entities.Veterinarians;

@Repository
public interface VeterinarianRepo extends JpaRepository<Veterinarians, Long> {
}
