package com.lfaiska.velazques.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemEntity {
    @JsonProperty("produto")
    private String product;
    @JsonProperty("variedade")
    private String variety;
    @JsonProperty("pais")
    private String country;
    @JsonProperty("categoria")
    private String category;
    @JsonProperty("safra")
    private String harvest;
    @JsonProperty("preco")
    private Double price;

    public ItemEntity() {
    }

    public ItemEntity(String product, String variety, String country, String category, String harvest, Double price) {
        this.product = product;
        this.variety = variety;
        this.country = country;
        this.category = category;
        this.harvest = harvest;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHarvest() {
        return harvest;
    }

    public void setHarvest(String harvest) {
        this.harvest = harvest;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "product='" + product + '\'' +
                ", variety='" + variety + '\'' +
                ", country='" + country + '\'' +
                ", category='" + category + '\'' +
                ", harvest='" + harvest + '\'' +
                ", price=" + price +
                '}';
    }
}
