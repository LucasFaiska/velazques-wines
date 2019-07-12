package com.lfaiska.velazques.domain.dto;

public class CustomerDto {
    private String name;
    private String document;
    private Double totalPurchase;

    public CustomerDto(String name, String document, Double totalPurchase) {
        this.name = name;
        this.document = document;
        this.totalPurchase = totalPurchase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Double getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(Double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }
}
