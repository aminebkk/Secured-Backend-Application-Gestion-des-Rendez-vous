package com.example.backend_spring_tp34.DAO;

import com.example.backend_spring_tp34.Entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
