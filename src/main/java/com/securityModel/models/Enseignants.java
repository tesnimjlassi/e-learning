package com.securityModel.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "enseignants")
public class Enseignants extends User{
    private String CV;
    @OneToMany(mappedBy = "enseignant",cascade = CascadeType.ALL)
    private  List<Chat>chats;

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    @OneToMany(mappedBy = "enseignant",cascade = CascadeType.ALL)
    private List<Cours>cours;

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }
}
