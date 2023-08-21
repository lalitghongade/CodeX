package com.lala.starter.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    private String code;
    private String language;
    private String status;
    private String output;

 // New fields
    private LocalDateTime submissionTime;
    private Long executionTime; // Execution time in milliseconds
    private Long memoryUsage;   // Memory usage in bytes

    // Constructors, getters, setters, etc.
     // Update submission status based on example results
     public void updateStatusBasedOnExamples(List<Example> examples) {
        // Iterate through examples and determine the overall submission status
        boolean allExamplesAccepted = true;
        for (Example example : examples) {
            if (!example.getStatus().equals("Accepted")) {
                allExamplesAccepted = false;
                break;
            }
        }

        if (allExamplesAccepted) {
            this.status = "Accepted";
        } else {
            this.status = "Wrong Answer";
        }
    }
}

