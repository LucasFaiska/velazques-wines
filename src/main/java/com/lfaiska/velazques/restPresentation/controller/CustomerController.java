package com.lfaiska.velazques.restPresentation.controller;

import com.lfaiska.velazques.domain.exceptions.NotFoundRegisterException;
import com.lfaiska.velazques.domain.service.CustomerService;
import com.lfaiska.velazques.restPresentation.entity.CustomerListResponse;
import com.lfaiska.velazques.restPresentation.entity.ErrorResponse;
import com.lfaiska.velazques.restPresentation.entity.PurchaseResponse;
import com.lfaiska.velazques.restPresentation.mapper.CustomerMapper;
import com.lfaiska.velazques.restPresentation.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

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
        return new CustomerListResponse(customerService.getCustomersOrderedByPurchasedValue()
                .stream().map(CustomerMapper::dtoToResponse).collect(Collectors.toList()));
    }

    @GetMapping("/customers/purchases/greater/{year}")
    @ResponseBody
    public PurchaseResponse getCustomertWithGreaterPurchase(@PathVariable String year) {
        try {
            return PurchaseMapper.dtoToResponse(customerService.getCustomerWithMostGreaterPurchaseInYear(Integer.parseInt(year)));
        } catch (NotFoundRegisterException exception) {
            return new PurchaseResponse();
        }
    }

    @GetMapping("/customers/loyal")
    @ResponseBody
    public CustomerListResponse getLoyalCustomers() {
        return new CustomerListResponse(customerService.getLoyalCustomers().stream().map(CustomerMapper::dtoToResponse).collect(Collectors.toList()));
    }

}
