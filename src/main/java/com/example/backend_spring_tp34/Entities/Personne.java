package com.example.backend_spring_tp34.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "personne")
    @JsonManagedReference
    private List<RendezVous> rendezVous;
}
