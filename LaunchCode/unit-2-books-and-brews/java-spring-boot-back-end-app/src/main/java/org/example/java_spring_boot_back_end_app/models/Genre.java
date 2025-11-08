package org.example.java_spring_boot_back_end_app.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Create GenreDTO to transfer validation annotations for the title

    @NotBlank(message = "Genre is required")
    @Size(min=1, max=30, message = "Genre must be 1 - 30 characters long")
    private String title;

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference
    private final List<Book> books = new ArrayList<>();

    public Genre() {};

    public Genre(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
