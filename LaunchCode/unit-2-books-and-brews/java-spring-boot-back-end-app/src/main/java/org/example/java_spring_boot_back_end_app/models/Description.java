package org.example.java_spring_boot_back_end_app.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    private String summary;

    @NotNull(message="Must specify if a book is trending using true/false.")
    private boolean isTrending;

    @NotNull(message="Book sales price is required.")
    private float salesPrice;

    @NotNull(message="Book original price is required.")
    private float originalPrice;

    @OneToOne(mappedBy = "description")
    private Book book;

    public Description(){};

    public Description(String summary, Boolean isTrending, float salesPrice, float originalPrice) {
        this.summary = summary;
        this.isTrending = isTrending;
        this.salesPrice = salesPrice;
        this.originalPrice = originalPrice;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return summary;
    }

    public void setDescription(String description) {
        this.summary = description;
    }

    public Boolean getTrending() {
        return isTrending;
    }

    public void setTrending(Boolean trending) {
        isTrending = trending;
    }

    public float getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }
}
