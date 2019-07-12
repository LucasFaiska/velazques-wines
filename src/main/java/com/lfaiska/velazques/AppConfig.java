package com.lfaiska.velazques;

import com.lfaiska.velazques.domain.service.CustomerService;
import com.lfaiska.velazques.domain.service.CustomerServiceImpl;
import com.lfaiska.velazques.infrastructure.repository.CustomerRepository;
import com.lfaiska.velazques.infrastructure.repository.CustomerRepositoryImpl;
import com.lfaiska.velazques.infrastructure.repository.SaleRepository;
import com.lfaiska.velazques.infrastructure.repository.SaleRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl(customerRepository(), saleRepository());
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepositoryImpl();
    }

    @Bean
    public SaleRepository saleRepository() {
        return new SaleRepositoryImpl();
    }

    @Bean
    public RestTemplate getRestClient() {
        return new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
    }
}
