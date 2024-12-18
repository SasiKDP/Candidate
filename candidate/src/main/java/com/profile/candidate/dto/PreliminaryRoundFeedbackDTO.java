package com.profile.candidate.dto;

import javax.validation.constraints.NotBlank;

public class PreliminaryRoundFeedbackDTO {

    private String communicationSkills;
    private Double requiredTechnologiesRating;
    private String overallFeedback;
    @NotBlank(message = "Zoom link is required")
    private String zoomLink;  // Manually provided Zoom link

    // Getters and Setters

    public String getCommunicationSkills() {
        return communicationSkills;
    }

    public void setCommunicationSkills(String communicationSkills) {
        this.communicationSkills = communicationSkills;
    }

    public Double getRequiredTechnologiesRating() {
        return requiredTechnologiesRating;
    }

    public void setRequiredTechnologiesRating(Double requiredTechnologiesRating) {
        this.requiredTechnologiesRating = requiredTechnologiesRating;
    }

    public String getOverallFeedback() {
        return overallFeedback;
    }

    public void setOverallFeedback(String overallFeedback) {
        this.overallFeedback = overallFeedback;
    }

    public String getZoomLink() {
        return zoomLink;
    }

    public void setZoomLink(String zoomLink) {
        this.zoomLink = zoomLink;
    }
}
