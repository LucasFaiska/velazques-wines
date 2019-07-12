package com.lfaiska.velazques.infrastructure.repository;

import com.lfaiska.velazques.infrastructure.entity.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SaleRepositoryImpl implements SaleRepository {

    @Value("${sale.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public List<SaleEntity> getAllSales() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SaleEntity>>() {
                })
                .getBody();
    }

}
