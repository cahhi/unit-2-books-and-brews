package org.example.java_spring_boot_back_end_app.models;

import java.util.Objects;


public class Book {

    private static int nextId = 1; //constructor will increment the id for each book automatically


    private final int id; // set in constructor
    private String title;
    private String author;
    private long isbn;
    private String description;
    private float salePrice;
    private float originalPrice;

    public Book(String title, String author, long isbn, String description, float salePrice, float originalPrice) {
        this.id = nextId; //manually telling system to set id using nextId
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.salePrice = salePrice;
        this.originalPrice = originalPrice;
        nextId++; // incremented automatically
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

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", isbn: " + isbn +
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