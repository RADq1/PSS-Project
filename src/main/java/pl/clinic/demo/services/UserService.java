package pl.clinic.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.clinic.demo.entities.Users;
import pl.clinic.demo.entities.Visits;
import pl.clinic.demo.repo.UserRepo;
import pl.clinic.demo.repo.VisitRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    @Autowired
    private final VisitRepo visitRepo;

    public UserService(UserRepo userRepo, VisitRepo visitRepo) {
        this.userRepo = userRepo;
        this.visitRepo = visitRepo;
    }

    public void registerUser(Users users){
        System.out.println("rejestracja");
        userRepo.save(users);
    }

    public Optional<Users> checkEmail(String email)
    {
        return userRepo.findByEmail(email);
    }
    public Optional<Users> checkLogin(String login)
    {
        return userRepo.findByLogin(login);
    }

    public List<Visits> findPetsForUser(Users user){
        return visitRepo.findByUser(user);
    }


}
