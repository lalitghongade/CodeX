package com.lala.starter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lala.starter.entities.Problem;
import com.lala.starter.service.ProblemAdminService;

@RestController
@RequestMapping("/admin/problems")
public class ProblemAdminController {

    @Autowired
    private ProblemAdminService problemAdminService;

    @PostMapping
    public ResponseEntity<Problem> addProblem(@RequestBody Problem problem) {
        Problem addedProblem = problemAdminService.addProblem(problem);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProblem);
    }

    @GetMapping
    public ResponseEntity<List<Problem>> getAllProblems() {
        List<Problem> problems = problemAdminService.getAllProblems();
        return ResponseEntity.ok(problems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Problem> getProblem(@PathVariable Long id) {
        Problem problem = problemAdminService.getProblemById(id);
        return ResponseEntity.ok(problem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Problem> updateProblem(@PathVariable Long id, @RequestBody Problem updatedProblem) {
        Problem problem = problemAdminService.updateProblem(id, updatedProblem);
        return ResponseEntity.ok(problem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProblem(@PathVariable Long id) {
        problemAdminService.deleteProblem(id);
        return ResponseEntity.noContent().build();
    }
}
