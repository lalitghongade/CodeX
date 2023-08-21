package com.lala.starter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lala.starter.entities.Problem;
import com.lala.starter.execption.ResourceNotFoundException;
import com.lala.starter.repo.ProblemRepository;

@Service
public class ProblemAdminService {

    @Autowired
    private ProblemRepository problemRepository;

    public Problem addProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    public Problem getProblemById(Long id) {
        return problemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Problem not found with id: " + id));
    }

    public Problem updateProblem(Long id, Problem updatedProblem) {
        Problem existingProblem = getProblemById(id);
        // Update existingProblem fields with values from updatedProblem
        // For example: existingProblem.setTitle(updatedProblem.getTitle());
        // You can also add validation or processing here
        return problemRepository.save(existingProblem);
    }

    public void deleteProblem(Long id) {
        Problem existingProblem = getProblemById(id);
        problemRepository.delete(existingProblem);
    }
}
