package com.lala.starter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lala.starter.entities.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}