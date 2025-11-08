package org.example.java_spring_boot_back_end_app.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference
    private final List<Book> books = new ArrayList<>();

    public Genre(String title) {
        this.title = title;
    }
    public Genre() {};

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    //make easy certain operations  to be completed
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id == genre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
