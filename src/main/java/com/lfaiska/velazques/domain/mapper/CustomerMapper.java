package com.lfaiska.velazques.domain.mapper;

import com.lfaiska.velazques.domain.entity.CustomerModel;
import com.lfaiska.velazques.infrastructure.entity.CustomerEntity;

public class CustomerMapper {
    public static CustomerModel entityToModel(CustomerEntity entity) {
        return new CustomerModel(entity.getId(), entity.getName(), entity.getDocument());
    }
}
