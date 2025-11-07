package org.example.java_spring_boot_back_end_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthorDTO {

    @NotBlank(message = "Author's first name is required.")
    @Size(min=1, max=40, message = "Author's first name must be 1 - 40 characters long.")
    private String firstName;

    @NotBlank(message = "Author's last name is required.")
    @Size(min=1, max=40, message = "Author's last name must be 1 - 40 characters long.")
    private String lastName;

    public AuthorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
