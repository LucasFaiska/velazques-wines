package com.lfaiska.velazques.infrastructure.repository;

import com.lfaiska.velazques.infrastructure.entity.SaleEntity;

import java.util.List;

public interface SaleRepository {
    List<SaleEntity> getAllSales();
}
