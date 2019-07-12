package com.lfaiska.velazques.rest_presentation.mapper;

import com.lfaiska.velazques.domain.dto.CustomerDto;
import com.lfaiska.velazques.rest_presentation.entity.CustomerResponse;

public class CustomerMapper {
    public static CustomerResponse dtoToResponse(CustomerDto dto) {
        return new CustomerResponse(dto.getName(), dto.getDocument(), dto.getTotalPurchaseHistory());
    }
}
