package com.lala.starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lala.starter.entities.Example;
import com.lala.starter.entities.Problem;
import com.lala.starter.entities.Submission;
import com.lala.starter.repo.SubmissionRepository;

import java.util.List;

import java.io.*;
import java.time.Duration;
import java.time.Instant;


@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private ProblemService problemService;

    public Submission submitCode(Submission submission) {
        // Save the submission to the database
        submission = submissionRepository.save(submission);

        // Evaluate the submission
        submission = evaluateSubmission(submission);

        return submission;
    }

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public Submission evaluateSubmission(Submission submission) {
        // Get associated problem for evaluation
        Problem problem = problemService.getProblemById(submission.getProblem().getId());

        // Get problem's examples for evaluation
        List<Example> examples = problem.getExamples();

        // Loop through examples to evaluate the submission
        for (Example example : examples) {
            String input = example.getInput();
            String expectedOutput = example.getOutput();

            // Run user's code and get the result
            SubmissionResult result = runUserCode(submission, input, problem);

            // Compare user's output with expected output
            if (result.getOutput().trim().equals(expectedOutput.trim())) {
                example.setStatus("Accepted");
            } else {
                example.setStatus("Wrong Answer");
            }
        }

        // Update submission's status based on example results
        submission.updateStatusBasedOnExamples(examples);

        // Save the evaluated submission
        return submissionRepository.save(submission);
    }

    private SubmissionResult runUserCode(Submission submission, String input, Problem problem) {
        String code = submission.getCode();
        String language = submission.getLanguage();
        String output = "";
        Long executionTimeMillis = 0L;
        Long memoryUsageBytes = 0L;

        try {
            // Create a temporary file to store the code
            File tempFile = File.createTempFile("code", "." + getFileExtension(language));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write(code);
            writer.close();

            // Record start time for execution time calculation
            Instant startTime = Instant.now();

            // Execute the user's code with the provided input
            ProcessBuilder processBuilder;
            if (language.equals("java")) {
                processBuilder = new ProcessBuilder("java", "-cp", ".", tempFile.getName());
            } else if (language.equals("python")) {
                processBuilder = new ProcessBuilder("python", tempFile.getName());
            } else {
                // Handle other languages
                throw new UnsupportedOperationException("Language not supported");
            }
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            BufferedWriter processWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            BufferedReader processReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Pass input to the process
            processWriter.write(input);
            processWriter.flush();
            processWriter.close();

            // Read output from the process
            String line;
            while ((line = processReader.readLine()) != null) {
                output += line + "\n";
            }

            process.waitFor(); // Wait for the process to finish

            // Record end time for execution time calculation
            Instant endTime = Instant.now();

            // Calculate execution time
            executionTimeMillis = Duration.between(startTime, endTime).toMillis();

            // Simulate memory usage
            memoryUsageBytes = 1024L * 1024L; // 1 MB (for example)

            // Clean up temporary file
            tempFile.delete();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error occurred while running code.", e);
        }

        return new SubmissionResult(output, executionTimeMillis, memoryUsageBytes);
    }

    private String getFileExtension(String language) {
        if (language.equals("java")) {
            return "java";
        } else if (language.equals("python")) {
            return "py";
        } else {
            // Handle other languages
            throw new UnsupportedOperationException("Language not supported");
        }
    }
}


class SubmissionResult {

    private String output;
    private Long executionTimeMillis;
    private Long memoryUsageBytes;

    public SubmissionResult(String output, Long executionTimeMillis, Long memoryUsageBytes) {
        this.output = output;
        this.executionTimeMillis = executionTimeMillis;
        this.memoryUsageBytes = memoryUsageBytes;
    }

    public String getOutput() {
        return output;
    }

    public Long getExecutionTimeMillis() {
        return executionTimeMillis;
    }

    public Long getMemoryUsageBytes() {
        return memoryUsageBytes;
    }
}
