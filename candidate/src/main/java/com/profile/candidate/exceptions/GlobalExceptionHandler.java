package com.profile.candidate.exceptions;

import com.profile.candidate.dto.CandidateResponseDto;
import com.profile.candidate.dto.InterviewResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle CandidateNotFoundException
    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<CandidateResponseDto> handleCandidateNotFoundException(CandidateNotFoundException ex) {
        CandidateResponseDto response = new CandidateResponseDto(
                ex.getMessage(), // Custom exception message
                null,
                null,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // HTTP 404
    }

    // Handle CandidateAlreadyExistsException
    @ExceptionHandler(CandidateAlreadyExistsException.class)
    public ResponseEntity<CandidateResponseDto> handleCandidateAlreadyExistsException(CandidateAlreadyExistsException ex) {
        CandidateResponseDto response = new CandidateResponseDto(
                ex.getMessage(), // Custom exception message
                null,
                null,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.CONFLICT); // HTTP 409
    }

    // Handle all other unchecked exceptions (generic fallback)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CandidateResponseDto> handleRuntimeException(RuntimeException ex) {
        CandidateResponseDto response = new CandidateResponseDto(
                "Internal server error occurred", // Generic error message
                null,
                null,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); // HTTP 500
    }

    // Handle validation errors for method argument validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InterviewResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();

        // Build error details
        Map<String, String> errorDetails = new HashMap<>();
        result.getFieldErrors().forEach(error -> errorDetails.put(error.getField(), error.getDefaultMessage()));

        // Build response DTO with error details
        InterviewResponseDto responseDto = new InterviewResponseDto();
        responseDto.setMessage("Validation failed");
//        responseDto.setCandidateId(null);  // Default value for error cases
        responseDto.setEmployeeId(null);  // Default value for error cases
        responseDto.setZoomLink(null);
        responseDto.setInterviewDateTime(null);
        responseDto.setDuration(null);

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    // Handle generic exceptions and respond with InterviewResponseDto
    @ExceptionHandler(Exception.class)
    public ResponseEntity<InterviewResponseDto> handleGenericException(Exception ex) {
        InterviewResponseDto responseDto = new InterviewResponseDto();
        responseDto.setMessage("An unexpected error occurred: " + ex.getMessage());
//        responseDto.setCandidateId(null);
        responseDto.setEmployeeId(null);
        responseDto.setZoomLink(null);
        responseDto.setInterviewDateTime(null);
        responseDto.setDuration(null);

        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
