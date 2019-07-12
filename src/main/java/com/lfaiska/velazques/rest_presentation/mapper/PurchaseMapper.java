package com.lfaiska.velazques.rest_presentation.mapper;

import com.lfaiska.velazques.domain.dto.PurchaseDto;
import com.lfaiska.velazques.rest_presentation.entity.PurchaseResponse;

public class PurchaseMapper {
    public static PurchaseResponse dtoToResponse(PurchaseDto dto) {
        return new PurchaseResponse(CustomerMapper.dtoToResponse(dto.getCustomer()), SaleMapper.dtoToResponse(dto.getSale()));
    }
}
