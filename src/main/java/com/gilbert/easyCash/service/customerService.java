package com.gilbert.easyCash.service;

import com.gilbert.easyCash.dao.customerDao;
import com.gilbert.easyCash.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class customerService {

    @Autowired
    @Qualifier("customerRepo")
    private customerDao cDao;

    public int insertCustomer(Customer customer){
        cDao.insertCustomer(customer);
        return 1;
    }

    public List<Customer> getAllCustomers(){
        return cDao.getAllCustomers();
    }

    public double withdraw(int customer_id,double amount){return cDao.withdraw(customer_id,amount);}

    public Customer getCustomerById(int customer_id){
        return cDao.getCustomerById(customer_id);
    }

}
