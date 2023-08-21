package com.lala.starter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lala.starter.entities.Problem;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
}