package com.lfaiska.velazques.domain.entity;

import java.util.Date;

public class SaleModel {
    private String code;
    private Date date;
    private int customerId;
    private Double totalValue;

    public SaleModel() {
    }

    public SaleModel(String code, Date date, int customerId, Double totalValue) {
        this.code = code;
        this.date = date;
        this.customerId = customerId;
        this.totalValue = totalValue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "SaleModel{" +
                "code='" + code + '\'' +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                ", totalValue=" + totalValue +
                '}';
    }
}
