package com.lfaiska.velazques.domain.dto;

import java.util.Date;
import java.util.List;

public class SaleDto {
    private Date date;
    private int customerId;
    private List<ItemDto> items;
    private Double totalValue;

    public SaleDto(Date date, int customerId, List<ItemDto> items, Double totalValue) {
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

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
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
        return "SaleDto{" +
                "date=" + date +
                ", customerId=" + customerId +
                ", items=" + items +
                ", totalValue=" + totalValue +
                '}';
    }
}
