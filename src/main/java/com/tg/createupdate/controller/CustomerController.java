package com.tg.createupdate.controller;

import com.tg.createupdate.dto.CustomerDto;
import com.tg.createupdate.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer", produces = "application/json")
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDto customer) {
        try {
            customerService.createCustomer(customer);
        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{userName}")
    public ResponseEntity updateCustomer(@PathVariable(name = "userName") String userName,
                                         @RequestBody CustomerDto customer) {
        boolean isUpdated;
        try {
            isUpdated = customerService.updateCustomer(userName,customer);
        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        if(isUpdated){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
}
