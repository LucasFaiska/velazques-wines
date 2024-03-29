package com.lfaiska.velazques.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SaleEntity {
    @JsonProperty("codigo")
    private String code;
    @JsonProperty("data")
    private String date;
    @JsonProperty("cliente")
    private String customerId;
    @JsonProperty("itens")
    private List<ItemEntity> itemEntities;
    @JsonProperty("valorTotal")
    private Double totalValue;

    public SaleEntity() {
    }

    public SaleEntity(String code, String date, String customerId, List<ItemEntity> itemEntities, Double totalValue) {
        this.code = code;
        this.date = date;
        this.customerId = customerId;
        this.itemEntities = itemEntities;
        this.totalValue = totalValue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<ItemEntity> getItemEntities() {
        return itemEntities;
    }

    public void setItemEntities(List<ItemEntity> itemEntities) {
        this.itemEntities = itemEntities;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "code='" + code + '\'' +
                ", date='" + date + '\'' +
                ", customerId='" + customerId + '\'' +
                ", itemEntities=" + itemEntities +
                ", totalValue=" + totalValue +
                '}';
    }
}
