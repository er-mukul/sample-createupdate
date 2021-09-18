package com.tg.createupdate.controller;

import com.tg.createupdate.dto.CustomerDto;
import com.tg.createupdate.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class CustomerControllerTest {
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createCustomer() {
        doNothing().when(customerService).createCustomer(any(CustomerDto.class));
        ResponseEntity response = customerController.createCustomer(CustomerDto.builder().build());
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }

    @Test
    void updateCustomer() {
        when(customerService.updateCustomer(anyString(), any(CustomerDto.class)))
                .thenReturn(true);
        ResponseEntity response = customerController.updateCustomer("testUsername",
                CustomerDto.builder().build());
        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
    }

    @Test
    void updateCustomerWhenCustomerDoesNotExist() {
        when(customerService.updateCustomer(anyString(),any(CustomerDto.class)))
                .thenReturn(false);
        ResponseEntity response = customerController.updateCustomer("testUsername",
                CustomerDto.builder().build());
        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
    }
}