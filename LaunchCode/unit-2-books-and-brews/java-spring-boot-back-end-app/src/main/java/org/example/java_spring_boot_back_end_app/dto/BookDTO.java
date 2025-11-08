package org.example.java_spring_boot_back_end_app.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookDTO {

    @Column(name="book_title")// I want the column to be named Book title instead of just title
    @NotBlank(message="Book title is required.") //value can not be blank/null
    @Size(min=2, max=60, message="Book title must be 2 - 60 characters long.") // creating a min/max character validation
    private String title;

    //setting the relationship between author and book
    @NotNull(message="Book author is required.")
    private int authorId;

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

    int[] genreIds;

    public BookDTO(String title, String description, int authorId, int[] genreIds, boolean isTrending, float salePrice, float originalPrice) {
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.genreIds = genreIds;
        this.isTrending = isTrending;
        this.salePrice = salePrice;
        this.originalPrice = originalPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTrending() {
        return isTrending;
    }

    public void setTrending(boolean trending) {
        isTrending = trending;
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

    public int[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(int[] genreIds) {
        this.genreIds = genreIds;
    }
}
