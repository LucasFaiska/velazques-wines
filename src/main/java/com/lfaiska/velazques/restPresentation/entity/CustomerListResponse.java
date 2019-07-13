package com.lfaiska.velazques.restPresentation.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerListResponse {
    @JsonProperty("clientes")
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
