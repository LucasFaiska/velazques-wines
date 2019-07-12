package com.lfaiska.velazques.domain.dto;

public class PurchaseDto {
    private CustomerDto customer;
    private SaleDto sale;

    public PurchaseDto() {
    }

    public PurchaseDto(CustomerDto customer, SaleDto sale) {
        this.customer = customer;
        this.sale = sale;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public SaleDto getSale() {
        return sale;
    }

    public void setSale(SaleDto sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "PurchaseDto{" +
                "customer=" + customer +
                ", sale=" + sale +
                '}';
    }
}
