package com.lfaiska.velazques.rest_presentation.entity;

public class CustomerResponse {
    private String name;
    private String document;
    private Double totalPurchase;

    public CustomerResponse() {
    }

    public CustomerResponse(String name, String document, Double totalPurchase) {
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

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", totalPurchase=" + totalPurchase +
                '}';
    }
}
