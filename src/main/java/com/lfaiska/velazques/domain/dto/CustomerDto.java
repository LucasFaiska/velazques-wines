package com.lfaiska.velazques.domain.dto;

public class CustomerDto {
    private String name;
    private String document;
    private Double totalPurchaseHistory;

    public CustomerDto(String name, String document) {
        this.name = name;
        this.document = document;
    }

    public CustomerDto(String name, String document, Double totalPurchaseHistory) {
        this.name = name;
        this.document = document;
        this.totalPurchaseHistory = totalPurchaseHistory;
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

    public Double getTotalPurchaseHistory() {
        return totalPurchaseHistory;
    }

    public void setTotalPurchaseHistory(Double totalPurchaseHistory) {
        this.totalPurchaseHistory = totalPurchaseHistory;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", totalPurchaseHistory=" + totalPurchaseHistory +
                '}';
    }
}
