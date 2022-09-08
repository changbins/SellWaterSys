package com.example.waterdeliverysystem.service;

import com.example.waterdeliverysystem.model.Customer;

import java.util.List;

public interface CustomerService {


    public List<Customer> getCustomerList();

    public List<Customer> getCustomerListByPage(int page , int rows);

    int addCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public int updateCustomer(Customer customer);

    public int deleteCustomerById(int id);

    public List<Customer> getCustomerListByCustomerName(String cusstomer);
}
