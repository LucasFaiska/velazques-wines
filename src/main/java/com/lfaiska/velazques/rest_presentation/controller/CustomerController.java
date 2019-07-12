package com.lfaiska.velazques.rest_presentation.controller;

import com.lfaiska.velazques.domain.service.CustomerService;
import com.lfaiska.velazques.rest_presentation.entity.CustomerListResponse;
import com.lfaiska.velazques.rest_presentation.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    @ResponseBody
    public CustomerListResponse getCustomers() {
        return new CustomerListResponse(customerService.getCustomersOrderedByPurchasedValue().stream().map(CustomerMapper::dtoToResponse).collect(Collectors.toList()));
    }
}
