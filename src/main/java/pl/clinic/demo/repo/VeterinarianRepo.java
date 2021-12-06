package pl.clinic.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.clinic.demo.entities.Veterinarians;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeterinarianRepo extends JpaRepository<Veterinarians, Long> {

    @Query(value = "select * from veterinarians", nativeQuery = true)
    List<Veterinarians> nameVet();


}
