package com.gilbert.easyCash.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Customers")
public class Customer {



@Id
    public int customer_id;

    public String getCustomer_fname() {
        return customer_fname;
    }

    public String getCustomer_lname() {
        return customer_lname;
    }


    private String customer_fname;
    private String customer_lname;
    private String phone_number;
    private String email;

    public Customer(@JsonProperty("customer_id") int customer_id,@JsonProperty("customer_fname") String customer_fname, @JsonProperty("customer_lname")String customer_lname,@JsonProperty("phone_number") String phone_number,@JsonProperty("balance") double balance, @JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("card_number") String card_number) {
        this.customer_id = customer_id;
        this.customer_fname = customer_fname;
        this.customer_lname = customer_lname;
        this.phone_number = phone_number;
        this.email = email;
        this.balance = balance;
        this.username = username;
        this.password = password;
        this.card_number = card_number;
    }

    private double balance;
    private String username;
    private String password;
    private String card_number;



    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCard_number() {
        return card_number;
    }

}
