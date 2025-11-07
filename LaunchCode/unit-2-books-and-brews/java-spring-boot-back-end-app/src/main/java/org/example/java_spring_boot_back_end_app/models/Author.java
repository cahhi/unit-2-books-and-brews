package org.example.java_spring_boot_back_end_app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //TODO: Once AuthorDTO is created, transfer validation annotations for firstName and lastName

    @NotBlank(message = "Author's first name is required.")
    @Size(min=1, max=40, message = "Author's first name must be 1 - 40 characters long.")
    private String firstName;

    @NotBlank(message = "Author's last name is required.")
    @Size(min=1, max=40, message = "Author's last name must be 1 - 40 characters long.")
    private String lastName;

    @OneToMany(mappedBy = "author")
    @JsonBackReference //managed on the backend by book
    private final List<Book> books = new ArrayList<>();

    public Author() {};

    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
