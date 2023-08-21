package com.lala.starter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String input;
    private String output;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    
    // New field
    private String status; // Example status (e.g., "Accepted", "Wrong Answer")

    // Constructors, getters, setters, etc.
}

