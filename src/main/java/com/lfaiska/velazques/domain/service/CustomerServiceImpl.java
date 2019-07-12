package com.lfaiska.velazques.domain.service;

import com.lfaiska.velazques.domain.dto.CustomerDto;
import com.lfaiska.velazques.domain.entity.CustomerModel;
import com.lfaiska.velazques.domain.entity.SaleModel;
import com.lfaiska.velazques.domain.mapper.CustomerMapper;
import com.lfaiska.velazques.domain.mapper.SaleMapper;
import com.lfaiska.velazques.infrastructure.repository.CustomerRepository;
import com.lfaiska.velazques.infrastructure.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               SaleRepository saleRepository) {
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
    }

    private Double getCustomerPurchasedAmount(int customerId, List<SaleModel> sales) {
        return sales.stream().filter(sale -> sale.getCustomerId() == customerId).mapToDouble(SaleModel::getTotalValue).sum();
    }

    public List<CustomerDto> getCustomersOrderedByPurchasedValue() {
        List<CustomerModel> customerModelList = this.customerRepository.getAllCustomers().stream().map(
                CustomerMapper::entityToModel
        ).collect(Collectors.toList());

        List<SaleModel> saleModelList = this.saleRepository.getAllSales().stream().map(
                SaleMapper::entityToModel
        ).collect(Collectors.toList());

        return customerModelList.stream().map(customer ->
                new CustomerDto(
                        customer.getName(),
                        customer.getDocument(),
                        getCustomerPurchasedAmount(customer.getId(), saleModelList)
                )
        ).sorted(Comparator.comparingDouble(CustomerDto::getTotalPurchase).reversed()).collect(Collectors.toList());
    }
}
