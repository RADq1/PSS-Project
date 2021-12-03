package pl.clinic.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.clinic.demo.entities.Pet;
import pl.clinic.demo.repo.PetRepo;

import java.util.List;
import java.util.Scanner;

@Service
public class PetService {
    @Autowired
    //private PetRepo petRepo;
    private static PetRepo petRepo;

    public static List<String> getGatunki() {
        return petRepo.allGatunki();
    }


//    @Override
//    public List<Pet> getGatunki() {
//        return petRepo.findAll();
//    }
}
