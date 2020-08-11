package com.example.training_project2.Searchmicroservice.DTOs;

public class SuccessFailureResponseDTO {
    Boolean success;
    String message;

    public SuccessFailureResponseDTO(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public SuccessFailureResponseDTO() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
