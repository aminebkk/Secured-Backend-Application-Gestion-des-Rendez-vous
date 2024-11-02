package com.example.backend_spring_tp34.Controller;


import com.example.backend_spring_tp34.DTO.RendezVousRequest;
import com.example.backend_spring_tp34.Entities.Personne;
import com.example.backend_spring_tp34.Entities.RendezVous;
import com.example.backend_spring_tp34.Service.PersonneService;
import com.example.backend_spring_tp34.Service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendezvous")
public class RendezVousController {
    private final RendezVousService rendezVousService;
    private final PersonneService personneService;

    @Autowired
    public RendezVousController(RendezVousService rendezVousService , PersonneService personneService) {
        this.rendezVousService = rendezVousService;
        this.personneService = personneService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<RendezVous> getAllRendezVous() {
        return rendezVousService.findAll();
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER')")
    public RendezVous createRendezVous(@RequestBody RendezVousRequest rendezVous) {
        Personne p = personneService.findById(rendezVous.getPersonId());
        RendezVous r = new RendezVous();
        r.setDuration(rendezVous.getDuration());
        r.setDate(rendezVous.getDate());
        r.setDescription(rendezVous.getDescription());
        r.setLocation(rendezVous.getLocation());
        r.setDuration(rendezVous.getDuration());
        r.setPersonne(p);
        return rendezVousService.save(r);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RendezVous> getRendezVousById(@PathVariable Long id) {
        return rendezVousService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<RendezVous> updateRendezVous(@PathVariable Long id, @RequestBody RendezVousRequest rendezVousRequest) {
        return rendezVousService.findById(id).map(existingRendezVous -> {
            existingRendezVous.setDuration(rendezVousRequest.getDuration());
            existingRendezVous.setDate(rendezVousRequest.getDate());
            existingRendezVous.setDescription(rendezVousRequest.getDescription());
            existingRendezVous.setLocation(rendezVousRequest.getLocation());
            Personne p = personneService.findById(rendezVousRequest.getPersonId());
            existingRendezVous.setPersonne(p);
            RendezVous updatedRendezVous = rendezVousService.save(existingRendezVous);
            return ResponseEntity.ok(updatedRendezVous);
        }).orElse(ResponseEntity.notFound().build());
    }
}
