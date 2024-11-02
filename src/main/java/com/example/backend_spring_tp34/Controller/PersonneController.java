package com.example.backend_spring_tp34.Controller;

import com.example.backend_spring_tp34.DTO.PersonneRequest;
import com.example.backend_spring_tp34.Entities.Personne;
import com.example.backend_spring_tp34.Service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {
    private final PersonneService personneService;

    @Autowired
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER')")
    public List<Personne> getAllPersonnes() {
        return personneService.findAll();
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
        public Personne createPersonne(@RequestBody Personne personne) {
        return personneService.save(personne);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public Personne getPersonneById(@PathVariable Long id) {
        return personneService.findById(id);

    }
}
