package org.example.java_spring_boot_back_end_app.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @NotBlank(message="Summary of book is required.")
    private String summary;

    @NotNull(message="Book sales price is required.")
    private float salesPrice;

    @NotNull(message="Book original price is required.")
    private float originalPrice;

    private String image;

    @OneToOne(mappedBy = "description")
    private Book book;

    public Description(){};

    public Description(String summary, String image, float salesPrice, float originalPrice) {
        this.summary = summary;
        this.salesPrice = salesPrice;
        this.originalPrice = originalPrice;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}
}
