package com.gilbert.easyCash.dao;

import com.gilbert.easyCash.model.Customer;

import java.util.List;
import java.util.UUID;

public interface customerDao {
    int insertCustomer(UUID customer_id, Customer customer);
    default int insertCustomer(Customer customer){
        UUID customer_id=UUID.randomUUID();
        return insertCustomer(customer_id,customer);
    }
    List<Customer> getAllCustomers();

    double withdraw(int customer_id,double amount);

    Customer getCustomerById(int customer_id);
}
