package com.example.backend_spring_tp34.Controller;


import com.example.backend_spring_tp34.DTO.RendezVousRequest;
import com.example.backend_spring_tp34.Entities.Personne;
import com.example.backend_spring_tp34.Entities.RendezVous;
import com.example.backend_spring_tp34.Service.PersonneService;
import com.example.backend_spring_tp34.Service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<RendezVous> getAllRendezVous() {
        return rendezVousService.findAll();
    }

    @PostMapping("/add")
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
    public ResponseEntity<RendezVous> getRendezVousById(@PathVariable Long id) {
        return rendezVousService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
