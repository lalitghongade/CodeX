package com.lala.starter.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String difficulty;
    private String fullStatement;
    private String constraints;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "problem")
    private List<Example> examples;

    @ManyToMany
    @JoinTable(
        name = "problem_tags",
        joinColumns = @JoinColumn(name = "problem_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

     // New fields
     private String status; // Overall problem status (e.g., "Solved", "Unsolved")

    // Constructors, getters, setters, etc.
}
