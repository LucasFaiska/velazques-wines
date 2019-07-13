package com.lfaiska.velazques.domain.service;

import com.lfaiska.velazques.domain.dto.CustomerDto;
import com.lfaiska.velazques.domain.dto.PurchaseDto;
import com.lfaiska.velazques.domain.dto.SaleDto;
import com.lfaiska.velazques.domain.entity.CustomerModel;
import com.lfaiska.velazques.domain.entity.SaleModel;
import com.lfaiska.velazques.domain.mapper.CustomerMapper;
import com.lfaiska.velazques.domain.mapper.SaleMapper;
import com.lfaiska.velazques.infrastructure.repository.CustomerRepository;
import com.lfaiska.velazques.infrastructure.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
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

    private List<CustomerModel> fetchCustomers() {
        return this.customerRepository.getAllCustomers().stream().map(
                CustomerMapper::entityToModel
        ).collect(Collectors.toList());
    }

    private List<SaleModel> fetchSales() {
        return this.saleRepository.getAllSales().stream().map(
                SaleMapper::entityToModel
        ).collect(Collectors.toList());
    }

    private Double getCustomerPurchasedAmount(int customerId, List<SaleModel> sales) {
        return sales.stream().filter(sale -> sale.getCustomerId() == customerId).mapToDouble(SaleModel::getTotalValue).sum();
    }

    public List<CustomerDto> getCustomersOrderedByPurchasedValue() {
        List<CustomerModel> customerModelList = fetchCustomers();
        List<SaleModel> saleModelList = fetchSales();

        return customerModelList.stream().map(customer ->
                CustomerMapper.modelToDto(customer, getCustomerPurchasedAmount(customer.getId(), saleModelList))
        ).sorted(Comparator.comparingDouble(CustomerDto::getTotalPurchaseHistory).reversed()).collect(Collectors.toList());
    }

    private boolean isDateInYear(int year, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) == year;
    }

    public PurchaseDto getCustomerWithMostGreaterPurchaseInYear(int year) {
        List<CustomerModel> customerModelList = fetchCustomers();
        List<SaleModel> saleModelList = fetchSales();

        SaleDto greaterSaleInYear = SaleMapper.modelToDto(
                saleModelList.stream().filter(sale ->
                        isDateInYear(year, sale.getDate())
                ).max(Comparator.comparing(SaleModel::getTotalValue)).get()
        );

        CustomerDto customerWithMostGreaterPurchase = CustomerMapper.modelToDto(customerModelList.stream()
                .filter(customer -> customer.getId() == greaterSaleInYear.getCustomerId()).findFirst().get());

        return new PurchaseDto(customerWithMostGreaterPurchase, greaterSaleInYear);
    }

    private int getCustomerPurchaseCount(int customerId, List<SaleModel> sales) {
        return sales.stream().filter(sale -> sale.getCustomerId() == customerId).collect(Collectors.toList()).size();
    }

    @Override
    public List<CustomerDto> getLoyalCustomers() {
        List<CustomerModel> customerModelList = fetchCustomers();
        List<SaleModel> saleModelList = fetchSales();

        return customerModelList.stream().map(customer ->
                CustomerMapper.modelToDto(customer, getCustomerPurchaseCount(customer.getId(), saleModelList))
        ).sorted(Comparator.comparing(CustomerDto::getPurchaseCount).reversed()).collect(Collectors.toList());
    }
}
