package org.example.java_spring_boot_back_end_app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    //make easy certain operations  to be completed
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
