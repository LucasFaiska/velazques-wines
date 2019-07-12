package com.lfaiska.velazques.domain.mapper;

import com.lfaiska.velazques.domain.dto.ItemDto;
import com.lfaiska.velazques.domain.entity.ItemModel;
import com.lfaiska.velazques.infrastructure.entity.ItemEntity;

public class ItemMapper {
    public static ItemModel entityToModel(ItemEntity entity) {
        return new ItemModel(entity.getProduct(), entity.getVariety(), entity.getCountry(), entity.getCategory(), entity.getHarvest(), entity.getPrice());
    }

    public static ItemDto modelToDto(ItemModel model) {
        return new ItemDto(model.getProduct(), model.getVariety(), model.getCountry(), model.getHarvest(), model.getPrice());
    }
}
