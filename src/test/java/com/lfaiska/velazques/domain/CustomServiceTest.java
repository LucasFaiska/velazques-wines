package com.lfaiska.velazques.domain;

import com.lfaiska.velazques.domain.dto.CustomerDto;
import com.lfaiska.velazques.domain.dto.PurchaseDto;
import com.lfaiska.velazques.domain.exceptions.NotFoundRegisterException;
import com.lfaiska.velazques.domain.service.CustomerServiceImpl;
import com.lfaiska.velazques.infrastructure.entity.CustomerEntity;
import com.lfaiska.velazques.infrastructure.entity.ItemEntity;
import com.lfaiska.velazques.infrastructure.entity.SaleEntity;
import com.lfaiska.velazques.infrastructure.repository.CustomerRepository;
import com.lfaiska.velazques.infrastructure.repository.SaleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CustomServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private CustomerServiceImpl subject;

    @Before
    public void setup() {
        ArrayList<CustomerEntity> customerEntities = new ArrayList<>();
        customerEntities.add(new CustomerEntity(1, "Customer 1", "001"));
        customerEntities.add(new CustomerEntity(2, "Customer 2", "002"));
        customerEntities.add(new CustomerEntity(3, "Customer 3", "003"));
        Mockito.when(customerRepository.getAllCustomers()).thenReturn(customerEntities);

        ArrayList<ItemEntity> itemEntities = new ArrayList<>();
        itemEntities.add(new ItemEntity("Product 1", "Variety 1", "BR", "Category 1", "1990", 10.0));
        itemEntities.add(new ItemEntity("Product 2", "Variety 2", "BR", "Category 2", "1990", 20.0));
        itemEntities.add(new ItemEntity("Product 3", "Variety 3", "BR", "Category 3", "1990", 30.0));

        ArrayList<SaleEntity> saleEntities = new ArrayList<>();
        saleEntities.add(new SaleEntity("123", "19-02-2016", "000.001", itemEntities, 200.0));
        saleEntities.add(new SaleEntity("123", "19-02-2016", "000.001", itemEntities, 100.0));
        saleEntities.add(new SaleEntity("123", "19-02-2015", "000.001", itemEntities, 100.0));
        saleEntities.add(new SaleEntity("123", "19-02-2015", "000.001", itemEntities, 100.0));
        saleEntities.add(new SaleEntity("123", "19-02-2016", "000.001", itemEntities, 100.0));

        saleEntities.add(new SaleEntity("123", "19-02-2016", "000.002", itemEntities, 100.0));
        saleEntities.add(new SaleEntity("123", "19-02-2016", "000.002", itemEntities, 100.0));
        saleEntities.add(new SaleEntity("123", "19-02-2015", "000.002", itemEntities, 100.0));
        saleEntities.add(new SaleEntity("123", "19-02-2016", "000.002", itemEntities, 100.0));


        saleEntities.add(new SaleEntity("123", "19-02-2016", "000.003", itemEntities, 100.0));
        saleEntities.add(new SaleEntity("123", "19-02-2015", "000.003", itemEntities, 100.0));
        saleEntities.add(new SaleEntity("123", "19-02-2016", "000.003", itemEntities, 100.0));
        Mockito.when(saleRepository.getAllSales()).thenReturn(saleEntities);
    }

    @Test
    public void whenGetCustomersOrderedByPurchasedValueShouldReturnCustomerListDtoOrdered() {
        List<CustomerDto> customerDtoList = subject.getCustomersOrderedByPurchasedValue();
        Assert.assertEquals("Customer 1", customerDtoList.get(0).getName());
        Assert.assertEquals(Double.valueOf(600.0), customerDtoList.get(0).getTotalPurchaseHistory());

        Assert.assertEquals("Customer 2", customerDtoList.get(1).getName());
        Assert.assertEquals(Double.valueOf(400.0), customerDtoList.get(1).getTotalPurchaseHistory());

        Assert.assertEquals("Customer 3", customerDtoList.get(2).getName());
        Assert.assertEquals(Double.valueOf(300.0), customerDtoList.get(2).getTotalPurchaseHistory());
    }

    @Test
    public void whenGetCustomerWithMostGreaterPurchaseInYearGreaterPurchase() throws NotFoundRegisterException {
        PurchaseDto purchaseDto = subject.getCustomerWithMostGreaterPurchaseInYear(2016);
        Assert.assertEquals("Customer 1", purchaseDto.getCustomer().getName());
        Assert.assertEquals(Double.valueOf(200.0), purchaseDto.getSale().getTotalValue());
    }

    @Test
    public void whenGetLoyalCustomersShouldReturnCustomerListDtoOrdered() {
        List<CustomerDto> customerDtoList = subject.getLoyalCustomers();
        Assert.assertEquals("Customer 1", customerDtoList.get(0).getName());
        Assert.assertEquals(5, customerDtoList.get(0).getPurchaseCount());

        Assert.assertEquals("Customer 2", customerDtoList.get(1).getName());
        Assert.assertEquals(4, customerDtoList.get(1).getPurchaseCount());

        Assert.assertEquals("Customer 3", customerDtoList.get(2).getName());
        Assert.assertEquals(3, customerDtoList.get(2).getPurchaseCount());
    }

}
