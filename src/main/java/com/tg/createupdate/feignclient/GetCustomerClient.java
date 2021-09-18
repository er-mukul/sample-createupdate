package com.tg.createupdate.feignclient;

import com.tg.createupdate.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "getCustomerClient")
public interface GetCustomerClient {
    @RequestMapping(value = "${getCustomerClient.customer.url}/{userName}",
            method = RequestMethod.GET)
    CustomerDto getCustomer(@PathVariable String userName);

}
