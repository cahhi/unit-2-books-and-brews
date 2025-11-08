package org.example.java_spring_boot_back_end_app.dto;



import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.java_spring_boot_back_end_app.models.Description;


public class BookDTO {

    @Column(name="book_title")// I want the column to be named Book title instead of just title
    @NotBlank(message="Book title is required.") //value can not be blank/null
    @Size(min=2, max=60, message="Book title must be 2 - 60 characters long.") // creating a min/max character validation
    private String title;

    //setting the relationship between author and book
    @NotNull(message="Book author is required.")
    private int authorId;

    int[] genreIds;

    private Description description;

    @NotNull(message="Must specify if a book is trending using true/false.")
    private boolean isTrending;

    @NotNull(message="Book sales price is required.")
    private float salePrice;

    @NotNull(message="Book original price is required.")
    private float originalPrice;


    public BookDTO(String title, int authorId, int[] genreIds, Description description) {
        this.title = title;
        this.authorId = authorId;
        this.genreIds = genreIds;
        this.description = description;
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

    public int[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(int[] genreIds) {
        this.genreIds = genreIds;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
