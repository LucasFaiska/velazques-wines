package com.lfaiska.velazques.domain.service;

import com.lfaiska.velazques.domain.dto.CustomerDto;
import com.lfaiska.velazques.domain.dto.PurchaseDto;
import com.lfaiska.velazques.domain.exceptions.NotFoundRegisterException;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getCustomersOrderedByPurchasedValue();
    PurchaseDto getCustomerWithMostGreaterPurchaseInYear(int year) throws NotFoundRegisterException;
    List<CustomerDto> getLoyalCustomers();
}
