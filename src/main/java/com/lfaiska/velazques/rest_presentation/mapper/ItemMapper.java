package com.lfaiska.velazques.rest_presentation.mapper;


import com.lfaiska.velazques.domain.dto.ItemDto;
import com.lfaiska.velazques.rest_presentation.entity.ItemResponse;

public class ItemMapper {
    public static ItemResponse dtoToResponse(ItemDto dto) {
        return new ItemResponse(dto.getProduct(), dto.getVariety(), dto.getCountry(), dto.getHarvest(), dto.getPrice());
    }
}
