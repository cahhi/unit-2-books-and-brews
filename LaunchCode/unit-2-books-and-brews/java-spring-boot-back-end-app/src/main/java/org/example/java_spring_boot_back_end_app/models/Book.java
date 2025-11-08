package org.example.java_spring_boot_back_end_app.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

//Converting the Book Model into an entity


@Entity //Spring and Hibernate know to look at the rest of the annotations added
public class Book {

    //Identify the id to be a primary key and auto-incremented
    @Id //Making this the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Generating the value of the ID automatically and making sure to autoincrement properly
    private int id;

    private String title;

    @ManyToOne //many books to one author
    @JsonManagedReference
    private Author author;

    @NotNull(message="Must specify if a book is trending using true/false.")
    private boolean isTrending;

    @NotNull(message="Book sales price is required.")
    private float salePrice;

    @NotNull(message="Book original price is required.")
    private float originalPrice;

    //adding a list of Genre objects and setting them to a many-to-many relationship
    @ManyToMany
    @JsonManagedReference
    private List<Genre> genres;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "description_id", referencedColumnName = "id")
    private Description description;



    public Book() {}; //need to be able to create an object and then use real constructor when ready to place values

    public Book(String title, Author author, Description description, List<Genre> genres) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.genres = genres;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }



    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return
                "Title: '" + title + '\'' +
                ", Author: '" + author + '\'' +
                ", Description: '" + description + '\'' +
                ", Genres: '" + genres + '\'';

    }

    //make easy certain operations  to be completed
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}