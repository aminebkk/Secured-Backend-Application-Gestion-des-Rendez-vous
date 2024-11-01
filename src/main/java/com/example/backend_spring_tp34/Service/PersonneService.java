package com.example.backend_spring_tp34.Service;


import com.example.backend_spring_tp34.DAO.PersonneRepository;
import com.example.backend_spring_tp34.Entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {
    private final PersonneRepository personneRepository;

    @Autowired
    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public List<Personne> findAll() {
        return personneRepository.findAll();
    }

    public Personne save(Personne personne) {
        return personneRepository.save(personne);
    }

    public Personne findById(Long id) {
        return personneRepository.findById(id).get();
    }
}
