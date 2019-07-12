package com.lfaiska.velazques.rest_presentation.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemResponse {
    @JsonProperty("nome")
    private String product;
    @JsonProperty("variedade")
    private String variety;
    @JsonProperty("pais")
    private String country;
    @JsonProperty("safra")
    private String harvest;
    @JsonProperty("preco")
    private Double price;

    public ItemResponse(String product, String variety, String country, String harvest, Double price) {
        this.product = product;
        this.variety = variety;
        this.country = country;
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
        return "ItemResponse{" +
                "product='" + product + '\'' +
                ", variety='" + variety + '\'' +
                ", country='" + country + '\'' +
                ", harvest='" + harvest + '\'' +
                ", price=" + price +
                '}';
    }
}
