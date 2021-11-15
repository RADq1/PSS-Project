package pl.clinic.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.clinic.demo.entities.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
}
