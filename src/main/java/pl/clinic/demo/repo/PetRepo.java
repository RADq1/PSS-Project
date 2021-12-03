package pl.clinic.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.clinic.demo.entities.Pet;

import java.util.List;

@Repository
public interface PetRepo extends JpaRepository<Pet, Long> {

    @Query(value = "SELECT gatunki FROM Pet", nativeQuery = true)
    List<String> allGatunki ();
}
