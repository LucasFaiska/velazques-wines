package com.lfaiska.velazques.rest_presentation.entity;


import java.util.List;

public class CustomerListResponse {
    private List<CustomerResponse> customers;

    public CustomerListResponse() {
    }

    public CustomerListResponse(List<CustomerResponse> customers) {
        this.customers = customers;
    }

    public List<CustomerResponse> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerResponse> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "CustomerListResponse{" +
                "customers=" + customers +
                '}';
    }
}
