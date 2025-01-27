package com.profile.candidate.model;

import jakarta.persistence.*;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "candidates")
public class CandidateDetails {

    @Id
    @Column(unique = true, nullable = false)
    private String candidateId;  // Manually set candidate ID

    @NotBlank(message = "Full name is required")
    @Size(max = 100, message = "Full name must not exceed 100 characters")
    private String fullName;

    @NotBlank(message = "Email ID is required")
    @Email(message = "Invalid email format")
    private String emailId;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "\\+\\d{10,15}", message = "Contact number must be in international format (e.g., +1234567890)")
    private String contactNumber;

    private String currentOrganization;

    @NotBlank(message = "Qualification is required")
    private String qualification;

    @NotNull(message = "Total experience is required")
    @Min(value = 0, message = "Total experience cannot be negative")
    private Integer totalExperience;

    private String relevantExperience;

    private Double currentCTC;

    private Double expectedCTC;

    private String noticePeriod;

    private String currentLocation;

    private String preferredLocation;

    @ElementCollection
    @CollectionTable(name = "candidate_skills", joinColumns = @JoinColumn(name = "candidate_id"))
    @Column(name = "skill")
    private List<String> skills;

    @Embedded
    private PreliminaryRoundFeedback preliminaryRoundFeedback;

    private String zoomLink;  // Manually set Zoom link

    @Column(nullable = false)
    private LocalDate profileReceivedDate;

    @PrePersist
    public void prePersist() {
        if (this.profileReceivedDate == null) {
            this.profileReceivedDate = LocalDate.now();  // Set the date before saving
        }
        if (this.candidateId == null) {
            generateCandidateId();  // Call the method to generate the candidate ID
        }
    }

    public void generateCandidateId() {
        if (this.candidateId == null || this.candidateId.isEmpty()) {
            Random random = new Random();
            int randomNumber = 100 + random.nextInt(900);  // Generates a random number between 100 and 999
            this.candidateId = "DATAQ" + randomNumber;  // Combine the prefix with the random number
        }
    }


    // Auto-generated date

    // Getters and Setters
    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCurrentOrganization() {
        return currentOrganization;
    }

    public void setCurrentOrganization(String currentOrganization) {
        this.currentOrganization = currentOrganization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Integer getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Integer totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getRelevantExperience() {
        return relevantExperience;
    }

    public void setRelevantExperience(String relevantExperience) {
        this.relevantExperience = relevantExperience;
    }

    public Double getCurrentCTC() {
        return currentCTC;
    }

    public void setCurrentCTC(Double currentCTC) {
        this.currentCTC = currentCTC;
    }

    public Double getExpectedCTC() {
        return expectedCTC;
    }

    public void setExpectedCTC(Double expectedCTC) {
        this.expectedCTC = expectedCTC;
    }

    public String getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(String noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public PreliminaryRoundFeedback getPreliminaryRoundFeedback() {
        return preliminaryRoundFeedback;
    }

    public void setPreliminaryRoundFeedback(PreliminaryRoundFeedback preliminaryRoundFeedback) {
        this.preliminaryRoundFeedback = preliminaryRoundFeedback;
    }

    public String getZoomLink() {
        return zoomLink;
    }

    public void setZoomLink(String zoomLink) {
        this.zoomLink = zoomLink;
    }

    public LocalDate getProfileReceivedDate() {
        return profileReceivedDate;
    }

    public void setProfileReceivedDate(LocalDate profileReceivedDate) {
        this.profileReceivedDate = profileReceivedDate;
    }
}