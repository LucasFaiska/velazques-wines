package com.lfaiska.velazques.domain.service;

import com.lfaiska.velazques.domain.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getCustomersOrderedByPurchasedValue();
}
