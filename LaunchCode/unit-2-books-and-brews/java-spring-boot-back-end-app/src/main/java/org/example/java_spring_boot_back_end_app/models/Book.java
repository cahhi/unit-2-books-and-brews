package org.example.java_spring_boot_back_end_app.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.w3c.dom.stylesheets.LinkStyle;

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

    @NotBlank(message="Book description is required.")
    @Size(min=2, max=255, message="Book description must be 2 - 255 characters long.")
    private String description;

    @NotBlank(message="Book genre is required.")
    @Size(min=2, max=10, message="Book genre must be 2 - 10 characters long.")
    private String genre;

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


    public Book() {}; //need to be able to create an object and then use real constructor when ready to place values

    public Book(String title, Author author, String description, List<Genre> genres, Boolean isTrending, float salePrice, float originalPrice) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.genres = genres;
        this.isTrending = isTrending;
        this.salePrice = salePrice;
        this.originalPrice = originalPrice;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Boolean getIsTrending() {
        return isTrending;
    }

    public void setIsTrending(Boolean isTrending) {
        this.isTrending = isTrending;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    @Override
    public String toString() {
        return
                "Title: '" + title + '\'' +
                ", Author: '" + author + '\'' +
                ", Description: '" + description + '\'' +
                ", Genre: '" + genre + '\'' +
                ", Trending: '" + isTrending + '\'' +
                ", Sale Price: '" + salePrice + '\'' +
                ", Original Price: '" + originalPrice + '\'';

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