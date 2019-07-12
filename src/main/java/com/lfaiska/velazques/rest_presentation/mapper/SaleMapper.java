package com.lfaiska.velazques.rest_presentation.mapper;

import com.lfaiska.velazques.domain.dto.SaleDto;
import com.lfaiska.velazques.rest_presentation.entity.SaleResponse;

import java.util.stream.Collectors;

public class SaleMapper {
    public static SaleResponse dtoToResponse(SaleDto dto) {
        return new SaleResponse(dto.getDate(),
                dto.getCustomerId(),
                dto.getItems().stream().map(ItemMapper::dtoToResponse).collect(Collectors.toList()),
                dto.getTotalValue());
    }
}
