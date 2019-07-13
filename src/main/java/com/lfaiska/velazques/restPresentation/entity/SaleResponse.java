package com.lfaiska.velazques.restPresentation.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleResponse {
    @JsonProperty("data")
    private Date date;
    @JsonProperty("cliente")
    private int customerId;
    @JsonProperty("itens")
    private List<ItemResponse> items;
    @JsonProperty("valorTotal")
    private Double totalValue;

    public SaleResponse(Date date, int customerId, List<ItemResponse> items, Double totalValue) {
        this.date = date;
        this.customerId = customerId;
        this.items = items;
        this.totalValue = totalValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<ItemResponse> getItems() {
        return items;
    }

    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "SaleResponse{" +
                "date=" + date +
                ", customerId=" + customerId +
                ", items=" + items +
                ", totalValue=" + totalValue +
                '}';
    }
}
