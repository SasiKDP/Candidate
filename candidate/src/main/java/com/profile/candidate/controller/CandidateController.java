package com.profile.candidate.controller;

import com.profile.candidate.dto.CandidateResponseDto;
import com.profile.candidate.exceptions.CandidateAlreadyExistsException;
import com.profile.candidate.exceptions.CandidateNotFoundException;
import com.profile.candidate.model.CandidateDetails;
import com.profile.candidate.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);

    // Endpoint to submit candidate profile (Create new candidate)
    @PostMapping("/submit")
    public ResponseEntity<CandidateResponseDto> submitCandidate(@RequestBody CandidateDetails candidateDetails) {
        try {
            // Service method to create or submit the candidate
            CandidateResponseDto response = candidateService.submitCandidate(candidateDetails);

            // Log the success of candidate submission
            logger.info("Candidate successfully submitted: {}", candidateDetails.getFullName());
            return new ResponseEntity<>(response, HttpStatus.OK);  // Use CREATED status for successful creation

        } catch (CandidateAlreadyExistsException ex) {
            // Handle specific CandidateAlreadyExistsException
            logger.error("Candidate already exists: {}", ex.getMessage());
            CandidateResponseDto errorResponse = new CandidateResponseDto(
                    ex.getMessage(),
                    null,
                    null,
                    null
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.OK); // 409 for conflict

        } catch (CandidateNotFoundException ex) {
            // Handle specific CandidateNotFoundException
            logger.error("Candidate not found: {}", ex.getMessage());
            CandidateResponseDto errorResponse = new CandidateResponseDto(
                    "Candidate not found",
                    null,
                    null,
                    null
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

        } catch (Exception ex) {
            // General error handler for any issues during candidate submission
            logger.error("An error occurred while submitting the candidate: {}", ex.getMessage());
            CandidateResponseDto errorResponse = new CandidateResponseDto(
                    "An error occurred while submitting the candidate",
                    null,
                    null,
                    null
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
