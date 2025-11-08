package org.example.java_spring_boot_back_end_app.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class GenreDTO {

    @NotBlank(message = "Genre is required")
    @Size(min=1, max=30, message = "Genre must be 1 - 30 characters long.")
    private String title;

    public GenreDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
