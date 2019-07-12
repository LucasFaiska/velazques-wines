package com.lfaiska.velazques.rest_presentation.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseResponse {
    @JsonProperty("cliente")
    private CustomerResponse customer;
    @JsonProperty("compra")
    private SaleResponse sale;

    public PurchaseResponse(CustomerResponse customer, SaleResponse sale) {
        this.customer = customer;
        this.sale = sale;
    }

    public CustomerResponse getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponse customer) {
        this.customer = customer;
    }

    public SaleResponse getSale() {
        return sale;
    }

    public void setSale(SaleResponse sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "PurchaseResponse{" +
                "customer=" + customer +
                ", sale=" + sale +
                '}';
    }
}
