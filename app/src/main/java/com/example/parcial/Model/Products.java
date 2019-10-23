package com.example.parcial.Model;

public class Products {
    private Integer id;
    private String product;
    private String category;
    private String quantity;

    public Products(Integer id, String product, String category, String quantity) {
        this.id = id;
        this.product = product;
        this.category = category;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
