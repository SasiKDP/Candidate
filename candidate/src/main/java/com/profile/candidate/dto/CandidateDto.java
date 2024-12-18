package com.profile.candidate.dto;
import javax.validation.constraints.*;
import java.util.List;
public class CandidateDto {

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

    @NotNull(message = "Current CTC is required")
    @Min(value = 0, message = "Current CTC cannot be negative")
    private Double currentCTC;

    @NotNull(message = "Expected CTC is required")
    @Min(value = 0, message = "Expected CTC cannot be negative")
    private Double expectedCTC;

    @NotBlank(message = "Notice period is required")
    private String noticePeriod;

    @NotBlank(message = "Current location is required")
    private String currentLocation;

    @NotBlank(message = "Preferred location is required")
    private String preferredLocation;

    @NotEmpty(message = "Skills are required")
    private List<String> skills;

    private PreliminaryRoundFeedbackDTO preliminaryRoundFeedback;



    // Getters and Setters

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

    public PreliminaryRoundFeedbackDTO getPreliminaryRoundFeedback() {
        return preliminaryRoundFeedback;
    }

    public void setPreliminaryRoundFeedback(PreliminaryRoundFeedbackDTO preliminaryRoundFeedback) {
        this.preliminaryRoundFeedback = preliminaryRoundFeedback;
    }

}
