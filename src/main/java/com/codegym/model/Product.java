package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @NotEmpty
    private String productName;

    @NotEmpty
    private String productPrice;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @NotEmpty
    private String discount;

    @NotEmpty
    private String productPhoto;

    @NotEmpty
    private String amount;

    @NotEmpty
    private Long shopping;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



    public Product() {
    }

    public Product(Long productId, @NotEmpty String productName, @NotEmpty String productPrice, Producer producer, @NotEmpty String discount, @NotEmpty String productPhoto, @NotEmpty String amount, @NotEmpty Long shopping, Category category){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.producer = producer;
        this.discount = discount;
        this.productPhoto = productPhoto;
        this.amount = amount;
        this.shopping = shopping;
        this.category = category;

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Long getShopping() {
        return shopping;
    }

    public void setShopping(Long shopping) {
        this.shopping = shopping;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
