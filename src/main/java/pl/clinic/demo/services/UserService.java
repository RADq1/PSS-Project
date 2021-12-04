package pl.clinic.demo.services;

import org.springframework.stereotype.Service;
import pl.clinic.demo.entities.Users;
import pl.clinic.demo.repo.UserRepo;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
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
}
