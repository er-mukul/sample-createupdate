package com.tg.createupdate.service.impl;

import com.tg.createupdate.dto.CustomerDto;
import com.tg.createupdate.enums.MarketingPreference;
import com.tg.createupdate.feignclient.GetCustomerClient;
import com.tg.createupdate.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private GetCustomerClient getCustomerClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createCustomer() {
        customerServiceImpl.createCustomer(CustomerDto.builder().build());
        verify(customerRepository,times(1)).save(any());
    }

    @Test
    void updateCustomer() {
        when(getCustomerClient.getCustomer(anyString()))
                .thenReturn(CustomerDto.builder()
                        .id(1L)
                        .customerName("TestUser")
                        .userName("User1")
                        .marketingPreference(MarketingPreference.EMAIL)
                        .build());

        boolean response = customerServiceImpl.updateCustomer("User1",CustomerDto.builder().build());
        verify(customerRepository,times(1)).save(any());
        assertTrue(response);
    }

    @Test
    void updateCustomerWhenCustomerDoesNotExist() {
        when(getCustomerClient.getCustomer(anyString()))
                .thenReturn(null);

        boolean response = customerServiceImpl.updateCustomer("User1",CustomerDto.builder().build());
        assertFalse(response);
    }
}