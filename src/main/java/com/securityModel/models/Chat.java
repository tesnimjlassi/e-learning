package com.securityModel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "chats")

public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;
    String date;
    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    @JsonIgnore
    private Enseignants enseignants;

    public Enseignants getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Enseignants enseignants) {
        this.enseignants = enseignants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
