package com.sujeet.Ecommerce_Backend.Model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean productAvailable;
    private String brand;
    private String category;
    @Column(name = "description")
    private String description;
    private String name;
    private BigDecimal price;
    private int stockQuantity;
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private Date releaseDate;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

    public Product() {
    }

    public Product(int id, boolean productAvailable, String brand, String category, String description, String name, BigDecimal price, int stockQuantity, Date releaseDate, String imageName, String imageType, byte[] imageData) {
        this.id = id;
        this.productAvailable = productAvailable;
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.releaseDate = releaseDate;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageData = imageData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return productAvailable;
    }

    public void setAvailable(boolean productAvailable) {
        this.productAvailable = productAvailable;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return stockQuantity;
    }

    public void setQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
