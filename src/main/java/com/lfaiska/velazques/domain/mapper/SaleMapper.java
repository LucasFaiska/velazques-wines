package com.lfaiska.velazques.domain.mapper;

import com.lfaiska.velazques.domain.entity.SaleModel;
import com.lfaiska.velazques.infrastructure.entity.SaleEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        return new SaleModel(entity.getCode(), dateFromString(entity.getDate()), Integer.parseInt(entity.getClientId().replace(".","")), entity.getTotalValue());
    }
}
