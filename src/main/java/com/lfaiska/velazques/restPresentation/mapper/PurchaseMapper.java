package com.lfaiska.velazques.restPresentation.mapper;

import com.lfaiska.velazques.domain.dto.PurchaseDto;
import com.lfaiska.velazques.restPresentation.entity.PurchaseResponse;

public class PurchaseMapper {
    public static PurchaseResponse dtoToResponse(PurchaseDto dto) {
        return new PurchaseResponse(CustomerMapper.dtoToResponse(dto.getCustomer()), SaleMapper.dtoToResponse(dto.getSale()));
    }
}
