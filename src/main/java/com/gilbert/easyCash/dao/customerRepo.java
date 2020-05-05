package com.gilbert.easyCash.dao;

import com.gilbert.easyCash.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Qualifier("customerRepo")
public class customerRepo implements customerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insertCustomer(UUID customer_id, Customer customer) {
//        jdbcTemplate.update("NSERT INTO `customers` (`customer_id`, `customer_fname`, `customer_lname`, `phone_number`, `email`, `photo`, `company_id`, `money_amount`, `username`, `password`, `serial_code`, `cooperative_id`, `date_registered`) VALUES\n" +
//                "(null,?,?,?,?,?,?,?, ?, ?, ?, ?, ?)",new Object[]{customer.get});
        return 1;
    }

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> customers = jdbcTemplate.query("select * from customers limit 500", new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer1 = new Customer(resultSet.getInt("customer_id"),resultSet.getString("customer_fname"),resultSet.getString("customer_lname"),resultSet.getString("phone_number"),resultSet.getInt("money_amount"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("serial_code"));
                return customer1;
            }
        });


        return customers;
    }

    @Override
    public double withdraw(int customer_id, double amount) {
        Customer c=getCustomerById(customer_id);

        if(amount<=c.getBalance()){
            double new_balance=c.getBalance()-amount;
            jdbcTemplate.update("update customers set money_amount=? where customer_id=?",new Object[]{new_balance,customer_id});
        }

        return 0;
    }

    @Override
    public Customer getCustomerById(int customer_id) {
        Customer customer = jdbcTemplate.queryForObject("select * from customers where customer_id=? ", new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer1 = new Customer(resultSet.getInt("customer_id"), resultSet.getString("customer_fname"), resultSet.getString("customer_lname"), resultSet.getString("phone_number"), resultSet.getInt("money_amount"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("serial_code"));
                return customer1;
            }
        }, customer_id);
        return customer;
    }


}
