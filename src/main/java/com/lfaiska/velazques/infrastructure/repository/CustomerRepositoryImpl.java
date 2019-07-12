package com.lfaiska.velazques.infrastructure.repository;

import com.lfaiska.velazques.infrastructure.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Value("${customer.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public List<CustomerEntity> getAllCustomers() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CustomerEntity>>() {
                })
                .getBody();
    }

}
