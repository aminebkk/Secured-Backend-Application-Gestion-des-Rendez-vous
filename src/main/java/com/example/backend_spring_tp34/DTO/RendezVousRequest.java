package com.example.backend_spring_tp34.DTO;

import com.example.backend_spring_tp34.Entities.Personne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

public class RendezVousRequest {

    @Temporal(TemporalType.DATE)
    private Date date;
    private String location;
    private int duration;
    private String description;
    private Long personId;
    private Personne personne;

   public RendezVousRequest() {}

    public String getDescription() {
        return description;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
