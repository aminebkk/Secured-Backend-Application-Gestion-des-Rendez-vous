package com.example.backend_spring_tp34.Entities;

import com.example.backend_spring_tp34.Entities.Personne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private String location;
    private int duration;
    private String description;


    @ManyToOne
    @JoinColumn(name = "personne_id")
    @JsonBackReference
    private Personne personne;
}
