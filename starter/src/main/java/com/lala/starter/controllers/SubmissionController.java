package com.lala.starter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lala.starter.entities.Submission;
import com.lala.starter.service.SubmissionService;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PostMapping
    public Submission submitCode(@RequestBody Submission submission) {
        return submissionService.submitCode(submission);
    }

    @GetMapping
    public List<Submission> getAllSubmissions() {
        return submissionService.getAllSubmissions();
    }
}

