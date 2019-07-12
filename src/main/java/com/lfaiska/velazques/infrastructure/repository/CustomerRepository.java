package com.lfaiska.velazques.infrastructure.repository;

import com.lfaiska.velazques.infrastructure.entity.CustomerEntity;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface CustomerRepository {
    List<CustomerEntity> getAllCustomers();
}
