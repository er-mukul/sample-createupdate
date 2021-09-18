package com.tg.createupdate.service;

import com.tg.createupdate.dto.CustomerDto;

public interface CustomerService {
    void createCustomer(CustomerDto customerDto);
    boolean updateCustomer(String userName, CustomerDto customerDto);
}
