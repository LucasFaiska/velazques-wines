package com.lfaiska.velazques.restPresentation.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {
    @JsonProperty("nome")
    private String name;
    @JsonProperty("cpf")
    private String document;
    @JsonProperty("totalCompras")
    private Double totalPurchaseHistory;
    @JsonProperty("quantidadeCompras")
    private int purchaseCount;

    public CustomerResponse() {
    }

    public CustomerResponse(String name, String document, Double totalPurchaseHistory, int purchaseCount) {
        this.name = name;
        this.document = document;
        this.totalPurchaseHistory = totalPurchaseHistory;
        this.purchaseCount = purchaseCount;
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

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", totalPurchaseHistory=" + totalPurchaseHistory +
                ", purchaseCount=" + purchaseCount +
                '}';
    }
}
