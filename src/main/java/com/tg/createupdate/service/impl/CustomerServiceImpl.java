package com.tg.createupdate.service.impl;

import com.tg.createupdate.dto.CustomerDto;
import com.tg.createupdate.entity.Customer;
import com.tg.createupdate.feignclient.GetCustomerClient;
import com.tg.createupdate.repository.CustomerRepository;
import com.tg.createupdate.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final GetCustomerClient getCustomerClient;

    @Override
    public void createCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder().customerName(customerDto.getCustomerName())
                .userName(customerDto.getUserName())
                .marketingPreference(customerDto.getMarketingPreference())
                .build();

        customerRepository.save(customer);


    }

    @Override
    public boolean updateCustomer(String userName, CustomerDto customerDto) {
     CustomerDto customerDtoFromGetService = getCustomerClient.getCustomer(userName);
     if(customerDtoFromGetService!=null){
         Customer customer = Customer.builder()
                 .id(customerDtoFromGetService.getId())
                 .customerName(customerDto.getCustomerName())
                 .userName(customerDto.getUserName())
                 .marketingPreference(customerDto.getMarketingPreference())
                 .build();
         customerRepository.save(customer);
         return true;
     } else {
         return false;
     }
    }
}
