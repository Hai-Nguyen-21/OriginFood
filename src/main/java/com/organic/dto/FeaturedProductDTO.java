package com.organic.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FeaturedProductDTO {
    @Id
    private Long id;
    private int id_product;
    private String name_product;
    private String image;
    private double price;
    private int quantity;

    public FeaturedProductDTO(int ID_PRODUCT, String NAME_PRODUCT, String IMAGE, double PRICE, int QUANTITY) {
        this.id_product = ID_PRODUCT;
        this.name_product = NAME_PRODUCT;
        this.image = IMAGE;
        this.price = PRICE;
        this.quantity = QUANTITY;
    }

    public FeaturedProductDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
