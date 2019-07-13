package com.lfaiska.velazques.restPresentation.mapper;


import com.lfaiska.velazques.domain.dto.ItemDto;
import com.lfaiska.velazques.restPresentation.entity.ItemResponse;

public class ItemMapper {
    public static ItemResponse dtoToResponse(ItemDto dto) {
        return new ItemResponse(dto.getProduct(), dto.getVariety(), dto.getCountry(), dto.getHarvest(), dto.getPrice());
    }
}
