package com.lala.starter.execption;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lala.starter.dtos.ErrorResponse;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CompilationErrorException.class)
    public ResponseEntity<ErrorResponse> handleCompilationError(CompilationErrorException ex) {
        // Create and return an appropriate error response
        ErrorResponse errorResponse = new ErrorResponse("Compilation Error: " + ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeErrorException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeError(RuntimeErrorException ex) {
        // Create and return an appropriate error response
        ErrorResponse errorResponse = new ErrorResponse("Runtime Error: " + ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Add more specific exception handlers as needed
}


 class CompilationErrorException extends RuntimeException {
    public CompilationErrorException(String message) {
        super(message);
    }
}

 class RuntimeErrorException extends RuntimeException {
    public RuntimeErrorException(String message) {
        super(message);
    }
}