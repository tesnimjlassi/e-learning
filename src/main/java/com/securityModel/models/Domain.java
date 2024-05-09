package com.securityModel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "domains")
public class Domain  {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            Long id;
String name ;
String description;

@ManyToOne
    @JoinColumn(name = "category_id")
@JsonIgnore
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
