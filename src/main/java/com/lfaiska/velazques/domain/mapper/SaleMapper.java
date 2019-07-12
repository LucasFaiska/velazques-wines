package com.lfaiska.velazques.domain.mapper;

import com.lfaiska.velazques.domain.dto.ItemDto;
import com.lfaiska.velazques.domain.dto.SaleDto;
import com.lfaiska.velazques.domain.entity.SaleModel;
import com.lfaiska.velazques.infrastructure.entity.SaleEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

public class SaleMapper {

    private static Date dateFromString(String stringDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return formatter.parse(stringDate);
        } catch (ParseException exception) {
            return new Date();
        }
    }

    public static SaleModel entityToModel(SaleEntity entity) {
        return new SaleModel(entity.getCode(),
                dateFromString(entity.getDate()),
                Integer.parseInt(entity.getClientId().replace(".","")),
                entity.getItemEntities().stream().map(ItemMapper::entityToModel).collect(Collectors.toList()),
                entity.getTotalValue());
    }

    public static SaleDto modelToDto(SaleModel model) {
        return new SaleDto(model.getDate(),
                model.getCustomerId(),
                model.getItens().stream().map(ItemMapper::modelToDto).collect(Collectors.toList()),
                model.getTotalValue());
    }
}
