package org.example.java_spring_boot_back_end_app.models;

import jakarta.persistence.*;

import java.util.Objects;

//Converting the Book Model into an entity


@Entity //Spring and Hibernate know to look at the rest of the annotations added
public class Book {

    //Identify the id to be a primary key and auto-incremented
    @Id //Making this the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Generating the value of the ID automatically and making sure to autoincrement properly
    private int id;

    @Column(name="book_title") // I want the column to be named Book title instead of just title
    private String title;

    private String author;

    private String description;

    private String genre;

    private boolean isTrending;

    private float salePrice;

    private float originalPrice;

    public Book() {}; //need to be able to create an object and then use real constructor when ready to place values

    public Book(String title, String author, String description, String genre, Boolean isTrending, float salePrice, float originalPrice) {
        this.title = title;
        this.author = author;
        this.description = description;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
                "title: '" + title + '\'' +
                ", author: '" + author + '\'' +
                ", description: '" + description + '\'' +
                ", sale price: '" + salePrice + '\'' +
                ", original price: '" + originalPrice + '\'';
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