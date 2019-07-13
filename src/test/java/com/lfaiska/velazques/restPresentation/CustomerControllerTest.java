package com.lfaiska.velazques.restPresentation;

import com.lfaiska.velazques.domain.dto.CustomerDto;
import com.lfaiska.velazques.domain.dto.ItemDto;
import com.lfaiska.velazques.domain.dto.PurchaseDto;
import com.lfaiska.velazques.domain.dto.SaleDto;
import com.lfaiska.velazques.domain.exceptions.NotFoundRegisterException;
import com.lfaiska.velazques.domain.service.CustomerService;
import com.lfaiska.velazques.restPresentation.controller.CustomerController;
import com.lfaiska.velazques.restPresentation.entity.CustomerListResponse;
import com.lfaiska.velazques.restPresentation.entity.PurchaseResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController subject;

    @Test
    public void whenGetCustomersOrderedByPurchasedValueShouldReturnCustomerListResponse() {
        ArrayList<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
        customerDtoList.add(new CustomerDto("Lucas", "123", 10.0));
        customerDtoList.add(new CustomerDto("João", "123", 5.0));

        Mockito.when(customerService.getCustomersOrderedByPurchasedValue()).thenReturn(customerDtoList);
        CustomerListResponse customerListResponse = subject.getCustomers();

        Assert.assertEquals("Lucas", customerListResponse.getCustomers().get(0).getName());
        Assert.assertEquals("João", customerListResponse.getCustomers().get(1).getName());
    }

    @Test
    public void whenGetCustomersWithGreaterPurchaseShouldReturnPurchaseResponse() throws NotFoundRegisterException {
        CustomerDto customerDto = new CustomerDto("Lucas", "123", 10.0);
        ArrayList<ItemDto> itensDtoList = new ArrayList<ItemDto>();
        itensDtoList.add(new ItemDto("Produto x", "Variedade Y", "Brazil", "1999", 10.0));
        SaleDto saleDto = new SaleDto(new Date(), 123, itensDtoList, 10.0);
        PurchaseDto purchaseDto = new PurchaseDto(customerDto, saleDto);

        Mockito.when(customerService.getCustomerWithMostGreaterPurchaseInYear(123)).thenReturn(purchaseDto);
        PurchaseResponse purchaseResponse = subject.getCustomertWithGreaterPurchase("123");
        Assert.assertEquals("Lucas", purchaseResponse.getCustomer().getName());
    }

    @Test
    public void whenGetLoyalCustomersShouldReturnCustomerListResponse() throws NotFoundRegisterException {
        ArrayList<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
        customerDtoList.add(new CustomerDto("Lucas", "123", 10.0));
        customerDtoList.add(new CustomerDto("João", "123", 5.0));

        Mockito.when(customerService.getLoyalCustomers()).thenReturn(customerDtoList);
        CustomerListResponse customerListResponse = subject.getLoyalCustomers();

        Assert.assertEquals("Lucas", customerListResponse.getCustomers().get(0).getName());
        Assert.assertEquals("João", customerListResponse.getCustomers().get(1).getName());
    }


}
