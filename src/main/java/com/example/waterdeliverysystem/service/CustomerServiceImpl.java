package com.example.waterdeliverysystem.service;

import com.example.waterdeliverysystem.mapper.CustomerMapper;
import com.example.waterdeliverysystem.model.Customer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> getCustomerList() {
        return customerMapper.getCustomerList();
    }

    @Override
    public List<Customer> getCustomerListByPage(int page, int rows) {

        PageHelper.startPage(page,rows);

        List<Customer> customerList = customerMapper.getCustomerList();

        PageInfo<Customer> info = new PageInfo<Customer>(customerList);

        return info.getList();
    }

    @Override
    public int addCustomer(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerMapper.getCustomerById(id);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public int deleteCustomerById(int id) {
        return customerMapper.deleteCustomerById(id);
    }

    @Override
    public List<Customer> getCustomerListByCustomerName(String cusstomerName) {
        return customerMapper.getCustomerListByCustomerName(cusstomerName);
    }
}
