package com.example.backend_spring_tp34.Service;


import com.example.backend_spring_tp34.DAO.RendezVousRepository;
import com.example.backend_spring_tp34.Entities.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {
    private final RendezVousRepository rendezVousRepository;

    @Autowired
    public RendezVousService(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    public List<RendezVous> findAll() {
        return rendezVousRepository.findAll();
    }

    public RendezVous save(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    public Optional<RendezVous> findById(Long id) {
        return rendezVousRepository.findById(id);
    }
}
