package com.lfaiska.velazques.restPresentation.mapper;

import com.lfaiska.velazques.domain.dto.CustomerDto;
import com.lfaiska.velazques.restPresentation.entity.CustomerResponse;

public class CustomerMapper {
    public static CustomerResponse dtoToResponse(CustomerDto dto) {
        return new CustomerResponse(dto.getName(), dto.getDocument(), dto.getTotalPurchaseHistory(), dto.getPurchaseCount());
    }
}
