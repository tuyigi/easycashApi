package com.gilbert.easyCash.controller;


import com.gilbert.easyCash.model.Customer;
import com.gilbert.easyCash.model.Withdraw;
import com.gilbert.easyCash.service.customerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/customer")
@RestController
@Api(value = "API Description")
public class CustomerController {


    @Autowired
    public customerService cService;

    @ApiOperation(value = "It save new customer")
    @PostMapping
    void insertCustomer(@RequestBody Customer customer){
        cService.insertCustomer(customer);
    }

    @ApiOperation(value = "it will return all customers")
    @GetMapping
    List<Customer> getAllCustomer(){
        return cService.getAllCustomers();
    }

    @ApiOperation(value = "it will withdraw money on customer account")
    @PutMapping
    void widthdrwa(@RequestBody Withdraw withdraw){
        cService.withdraw(withdraw.getCustomer_id(),withdraw.getAmount());
    }

    @ApiOperation(value = "it return a specific customer ")
    @GetMapping("{customer_id}")
    Customer getCustomer(@PathVariable int customer_id){
        return cService.getCustomerById(customer_id);
    }
}
